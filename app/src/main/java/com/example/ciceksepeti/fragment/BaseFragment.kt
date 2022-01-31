package com.example.ciceksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ciceksepeti.viewmodel.MainViewModel
import java.util.*

open class BaseFragment : Fragment() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(Objects.requireNonNull(activity)!!)[MainViewModel::class.java]

    }

    protected fun getViewModel(): MainViewModel? {
        return viewModel
    }

}