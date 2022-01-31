package com.example.ciceksepeti.requestbody

import com.example.ciceksepeti.models.Data
import com.example.ciceksepeti.models.MultipleResourceModel
import com.example.ciceksepeti.models.Price
import com.example.ciceksepeti.models.Product
import retrofit2.Call
import retrofit2.http.*

interface PostService {

    @GET("/v2/product/ch/dynamicproductlist")
    fun getFlowersList(): Call<MultipleResourceModel>

    @GET("/v2/product/ch/dynamicproductlist")
    fun getFlowersFilterList(@QueryMap(encoded = true) detailList: Map<String,String>): Call<MultipleResourceModel>

}
