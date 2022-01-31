package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailIdNetModel() : Parcelable{
    @SerializedName("detailValueId")
    @Expose
    var detailValueId: Double? = null

    constructor(parcel: Parcel) : this() {
        detailValueId = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(detailValueId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailIdNetModel> {
        override fun createFromParcel(parcel: Parcel): DetailIdNetModel {
            return DetailIdNetModel(parcel)
        }

        override fun newArray(size: Int): Array<DetailIdNetModel?> {
            return arrayOfNulls(size)
        }
    }
}