package com.example.ciceksepeti

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ciceksepeti.databinding.ActivityMainBinding
import com.example.ciceksepeti.models.Product
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.DynamicFilter
import com.example.ciceksepeti.viewmodel.MainViewModel
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.activity.BaseActivity
import com.example.ciceksepeti.adapter.FlowersListAdapter
import com.example.ciceksepeti.fragment.*
import com.example.ciceksepeti.models.Data
import com.example.ciceksepeti.utils.SharedPrefsHelper


class MainActivity : BaseActivity(), OnMainListeners {
    val CATEGORY_FILTER_LIST_FRAGMENT_TAG = "CATEGORY_FILTER_LIST_FRAGMENT_TAG"
    val CATEGORY_FILTER_LIST_DETAIL_FRAGMENT_TAG = "CATEGORY_FILTER_LIST_DETAIL_FRAGMENT_TAG"
    val FLOWERS_LIST_FRAGMENT_TAG = "FLOWERS_LIST_FRAGMENT_TAG"
    val FLOWERS_LIST_DETAIL_FRAGMENT_TAG = "FLOWERS_LIST_DETAIL_FRAGMENT_TAG"

    private var progressBar: ProgressBar? = null
    private var progressBarLinearLayout: LinearLayout? = null
    private var viewModel: MainViewModel? = null
    private var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, com.example.ciceksepeti.R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        binding.viewModel = viewModel

        progressBarLinearLayout = binding.linearLoadingSpinner
        progressBar = binding.loadingSpinner
        fragmentManager = supportFragmentManager

        binding.buttonContinue.setOnClickListener {
            binding.constraintLoginandSignup.visibility = View.GONE

            replaceFragmentAtMainContainer(
                fragmentManager!!,
                FLOWERS_LIST_FRAGMENT_TAG,
                FlowersListFragment()
            )
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showProgressBarExternal() {
        progressBarLinearLayout!!.setVisibility(View.VISIBLE)
        progressBar!!.visibility = View.VISIBLE
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    override fun hideProgressBarExternal() {
        progressBarLinearLayout!!.setVisibility(View.GONE)
        progressBar!!.visibility = View.GONE
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun clickItemDetail(product: Product) {
        replaceFragmentAtMainContainer(
            fragmentManager!!,
            FLOWERS_LIST_DETAIL_FRAGMENT_TAG,
            FlowersDetailFragment(product)
        )
    }

    override fun clickItemCategory(dynamicFilter: DynamicFilter) {
        replaceFragmentAtMainContainer(
            fragmentManager!!,
            CATEGORY_FILTER_LIST_FRAGMENT_TAG,
            CategoryFilterListDetailFragment(dynamicFilter)
        )
    }


    override fun openFlowersFilterList(dynamicFilter: ArrayList<DynamicFilter>?) {
        replaceFragmentAtMainContainer(
            fragmentManager!!,
            CATEGORY_FILTER_LIST_FRAGMENT_TAG,
            CategoryFilterListFragment(dynamicFilter)
        )
    }

    override fun detailFilter() {
        replaceFragmentAtMainContainer(
            fragmentManager!!,
            FLOWERS_LIST_FRAGMENT_TAG,
            FlowersListFragment()
        )
    }

    override fun onBackPressed() {
        val f = supportFragmentManager.findFragmentById(com.example.ciceksepeti.R.id.containerFragment)
        if (f is FlowersListFragment) {

        } else {
            super.onBackPressed()
        }
    }
}

