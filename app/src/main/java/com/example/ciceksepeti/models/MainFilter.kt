package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MainFilter () : Parcelable {
    @SerializedName("dynamicFilter")
    @Expose
    var dynamicFilter: List<DynamicFilter>? = null

    constructor(parcel: Parcel) : this() {
        dynamicFilter = parcel.createTypedArrayList(DynamicFilter)
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<MainFilter> {
        override fun createFromParcel(parcel: Parcel): MainFilter {
            return MainFilter(parcel)
        }

        override fun newArray(size: Int): Array<MainFilter?> {
            return arrayOfNulls(size)
        }
    }
}