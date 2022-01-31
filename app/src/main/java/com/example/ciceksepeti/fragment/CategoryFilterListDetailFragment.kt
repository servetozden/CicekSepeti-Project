package com.example.ciceksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.R
import com.example.ciceksepeti.adapter.CategoryFilterListDetailAdapter
import com.example.ciceksepeti.databinding.FragmentCategoryListDetailBinding
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.DynamicFilter
import com.example.ciceksepeti.models.Value
import com.example.ciceksepeti.viewmodel.MainViewModel

class CategoryFilterListDetailFragment(dynamicFilter: DynamicFilter) : BaseFragment() {

    private lateinit var binding: FragmentCategoryListDetailBinding
    private var dynamicFilter = dynamicFilter

    private lateinit var adapter: CategoryFilterListDetailAdapter
    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_category_list_detail, container, false)

          binding.viewModel = getViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var filterValue = dynamicFilter.values
        var detailId = dynamicFilter.detailId

        adapter = CategoryFilterListDetailAdapter(filterValue as ArrayList<Value>, getMainListener() ,
            detailId!!
        )
        val recyclerView: RecyclerView = binding.rvChooseAllFlowers
        recyclerView.adapter = adapter
    }
    private fun getMainListener(): OnMainListeners? {
        return activity as OnMainListeners?
    }


}