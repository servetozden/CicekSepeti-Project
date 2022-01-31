package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SubCategoryModel () : Parcelable {
    @SerializedName("shapeType")
    @Expose
    var shapeType: Int? = null

    @SerializedName("shapeTypeNewVersion")
    @Expose
    var shapeTypeNewVersion: Int? = null

    @SerializedName("subCategoryList")
    @Expose
    var subCategoryList: List<Any>? = null

    constructor(parcel: Parcel) : this() {
        shapeType = parcel.readValue(Int::class.java.classLoader) as? Int
        shapeTypeNewVersion = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(shapeType)
        parcel.writeValue(shapeTypeNewVersion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubCategoryModel> {
        override fun createFromParcel(parcel: Parcel): SubCategoryModel {
            return SubCategoryModel(parcel)
        }

        override fun newArray(size: Int): Array<SubCategoryModel?> {
            return arrayOfNulls(size)
        }
    }
}