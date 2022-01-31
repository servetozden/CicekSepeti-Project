package com.example.ciceksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.R
import com.example.ciceksepeti.adapter.CategoryListAdapter
import com.example.ciceksepeti.databinding.FragmentCategoryListBinding
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.DynamicFilter
import com.example.ciceksepeti.viewmodel.MainViewModel

class CategoryFilterListFragment(dynamicFilter: ArrayList<DynamicFilter>?) : BaseFragment() {

    private lateinit var binding: FragmentCategoryListBinding
    private var state: ArrayList<DynamicFilter>? = null

    private lateinit var adapter: CategoryListAdapter

    private var dynamicFilter = dynamicFilter
    var mainViewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            state = requireArguments().getParcelableArrayList("key")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_category_list, container, false)

        binding.viewModel = getViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CategoryListAdapter(dynamicFilter as ArrayList<DynamicFilter>, getMainListener())
        val recyclerView: RecyclerView = binding.rvChooseAllFlowers
        recyclerView.adapter = adapter

    }
    private fun getMainListener(): OnMainListeners? {
        return activity as OnMainListeners?
    }

    
}