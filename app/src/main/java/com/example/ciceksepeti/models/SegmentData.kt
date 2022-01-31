package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SegmentData () : Parcelable {
    @SerializedName("listType")
    @Expose
    var listType: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    constructor(parcel: Parcel) : this() {
        listType = parcel.readString()
        category = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(listType)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SegmentData> {
        override fun createFromParcel(parcel: Parcel): SegmentData {
            return SegmentData(parcel)
        }

        override fun newArray(size: Int): Array<SegmentData?> {
            return arrayOfNulls(size)
        }
    }
}