package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ProductDeliveryCity () : Parcelable {
    @SerializedName("deliveryCityImage")
    @Expose
    var deliveryCityImage: String? = null

    @SerializedName("isSendToSingleCity")
    @Expose
    var isSendToSingleCity: Boolean? = null

    constructor(parcel: Parcel) : this() {
        deliveryCityImage = parcel.readString()
        isSendToSingleCity = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(deliveryCityImage)
        parcel.writeValue(isSendToSingleCity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductDeliveryCity> {
        override fun createFromParcel(parcel: Parcel): ProductDeliveryCity {
            return ProductDeliveryCity(parcel)
        }

        override fun newArray(size: Int): Array<ProductDeliveryCity?> {
            return arrayOfNulls(size)
        }
    }
}