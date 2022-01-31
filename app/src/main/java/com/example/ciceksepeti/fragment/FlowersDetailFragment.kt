package com.example.ciceksepeti.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ciceksepeti.R
import com.example.ciceksepeti.databinding.FragmentFlowersDetailBinding
import com.example.ciceksepeti.listeners.OnMainListeners
import com.example.ciceksepeti.models.Product
import com.example.ciceksepeti.utils.SharedPrefsHelper

class FlowersDetailFragment(product: Product) : Fragment() {
    private lateinit var binding: FragmentFlowersDetailBinding
    private var state: Parcelable? = null
    private var product = product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            state = requireArguments().getParcelable("STATE")
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_flowers_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var stde = SharedPrefsHelper.getInstance(requireContext())?.getDataWithKey("sd")


        Glide.with(this).load(product.image).centerCrop().thumbnail(0.5f).diskCacheStrategy(
            DiskCacheStrategy.ALL).into(binding.flowersImageView)

        binding.flowerName.text = product.name
        binding.cargoDetail.text = product.deliveryBadgeText
        binding.flowersPrice.text = product.price!!.current.toString()+" TL"
        binding.flowersPriceInstallment.text = product.installmentText

        var oldAmount = product.price!!.old
        if (oldAmount != null && oldAmount > 0 ) {
            binding.flowersPriceDiscount.text = product.price!!.old.toString() +" TL"
        }else{
            binding.flowersPriceDiscount.visibility = View.GONE
        }


    }

    private fun getMainListener(): OnMainListeners? {
        return activity as OnMainListeners?
    }


}