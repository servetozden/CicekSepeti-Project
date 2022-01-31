package com.example.ciceksepeti.viewmodel

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ciceksepeti.models.Data
import com.example.ciceksepeti.models.MultipleResourceModel
import com.example.ciceksepeti.network.APIClient
import com.example.ciceksepeti.requestbody.PostService
import com.example.ciceksepeti.utils.SharedPrefsHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var dataList: MutableLiveData<List<Data?>>? = null
    lateinit var postService: PostService

    val context: Context? = null

    fun getResponseData(): MutableLiveData<List<Data?>>? {
        if (dataList == null) {
            dataList = MutableLiveData<List<Data?>>()

            loadResponseData()
        }

        return dataList
    }

    private fun loadResponseData() {
        postService = APIClient.getClient().create(PostService::class.java)
        var post = postService.getFlowersList()
       /* val mdata: HashMap<String, String> = HashMap()
        mdata.put("detailList","2007217")
        mdata.put("checkList","2007124")
        mdata.put("priceList","1")
        var post = postService.getFlowersFilterList(mdata)*/

        post?.enqueue(object : Callback<MultipleResourceModel?> {
            override fun onResponse(
                call: Call<MultipleResourceModel?>,
                response: Response<MultipleResourceModel?>
            ) {
                val multipleResourceList = response.body()

                var productDetail = multipleResourceList!!.result!!.data
                dataList!!.value = listOf(productDetail)

            }

            override fun onFailure(call: Call<MultipleResourceModel?>, t: Throwable) {

            }
        })
    }

}

