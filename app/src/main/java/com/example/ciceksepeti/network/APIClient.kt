package com.example.ciceksepeti.network

import androidx.lifecycle.MutableLiveData
import com.example.ciceksepeti.models.Data
import com.example.ciceksepeti.models.MultipleResourceModel
import com.example.ciceksepeti.requestbody.PostService
import com.example.ciceksepeti.utils.Constants
import com.example.ciceksepeti.viewmodel.MainViewModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.LiveData

object APIClient  {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit as Retrofit
    }


}