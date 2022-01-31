package com.example.ciceksepeti.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.R
import com.example.ciceksepeti.adapter.FlowersListAdapter
import com.example.ciceksepeti.databinding.FragmentFlowersListBinding
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.requestbody.PostService
import kotlin.collections.ArrayList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ciceksepeti.models.*
import com.example.ciceksepeti.utils.SharedPrefsHelper
import com.example.ciceksepeti.viewmodel.MainViewModel


class FlowersListFragment : BaseFragment() {

    private lateinit var binding: FragmentFlowersListBinding
    private lateinit var adapter: FlowersListAdapter
    var productArrayList: List<Product>? = null
    var resultArrayList: List<Data>? = null
    var filterArrayList: ArrayList<DynamicFilter>? = null
    var mainViewModel: MainViewModel? = null
    private var state: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            state = requireArguments().getString("dataFilter")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_flowers_list, container, false)

        binding.viewModel = getViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        getMainListener()?.showProgressBarExternal()
        mainViewModel!!.getResponseData()!!.observe(viewLifecycleOwner,
            Observer<Any?> { data ->
                getMainListener()?.hideProgressBarExternal()
                resultArrayList = data as List<Data>
                productArrayList = data[0].products
                filterArrayList = data[0].mainFilter!!.dynamicFilter as ArrayList<DynamicFilter>?
                binding.textProductTotal.hint = productArrayList?.size.toString() + " " +  getString(R.string.product_size_text)
                adapter = FlowersListAdapter(productArrayList as ArrayList<Product>, getMainListener())
                val recyclerView: RecyclerView = binding.rvChooseAllFlowers
                recyclerView.adapter = adapter

            })

        binding.constraintFilter.setOnClickListener {
            getMainListener()?.openFlowersFilterList(filterArrayList)
        }

    }

    private fun getMainListener(): OnMainListeners? {
        return activity as OnMainListeners?
    }

}
