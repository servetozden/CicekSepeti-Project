package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MultipleResourceModel  () : Parcelable {
    @SerializedName("result")
    @Expose
    var result: Result? = null

    @SerializedName("error")
    @Expose
    private val error: Error? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MultipleResourceModel> {
        override fun createFromParcel(parcel: Parcel): MultipleResourceModel {
            return MultipleResourceModel(parcel)
        }

        override fun newArray(size: Int): Array<MultipleResourceModel?> {
            return arrayOfNulls(size)
        }
    }



}