package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Data () : Parcelable{
    @SerializedName("categoryName")
    @Expose
    var categoryName: Any? = null

    @SerializedName("products")
    @Expose
    var products: List<Product>? = null

    @SerializedName("filter")
    @Expose
    var filter: Any? = null

    @SerializedName("banners")
    @Expose
    var banners: Any? = null

    @SerializedName("mainFilter")
    @Expose
    var mainFilter: MainFilter? = null

    @SerializedName("branch")
    @Expose
    var branch: Any? = null

    @SerializedName("message")
    @Expose
    var message: Any? = null

    @SerializedName("productCount")
    @Expose
    var productCount: Int? = null

    @SerializedName("title")
    @Expose
    var title: Any? = null

    @SerializedName("isAlternate")
    @Expose
    var isAlternate: Boolean? = null

    @SerializedName("hasOldPrice")
    @Expose
    var hasOldPrice: Boolean? = null

    @SerializedName("isDailyOpportunityPage")
    @Expose
    var isDailyOpportunityPage: Boolean? = null

    @SerializedName("storeId")
    @Expose
    var storeId: Any? = null

    @SerializedName("backgroundColor")
    @Expose
    var backgroundColor: Any? = null

    @SerializedName("subCategoryModel")
    @Expose
    var subCategoryModel: SubCategoryModel? = null

    @SerializedName("suggestCategoryList")
    @Expose
    var suggestCategoryList: List<Any>? = null

    @SerializedName("segmentData")
    @Expose
    var segmentData: SegmentData? = null

    @SerializedName("advertIconText")
    @Expose
    var advertIconText: String? = null

    constructor(parcel: Parcel) : this() {
        products = parcel.createTypedArrayList(Product)
        productCount = parcel.readValue(Int::class.java.classLoader) as? Int
        isAlternate = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hasOldPrice = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isDailyOpportunityPage = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        advertIconText = parcel.readString()
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}