package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Price () : Parcelable {
    @SerializedName("current")
    @Expose
    var current: Double? = null

    @SerializedName("old")
    @Expose
    var old: Double? = null

    @SerializedName("tax")
    @Expose
    var tax: Any? = null

    @SerializedName("total")
    @Expose
    var total: Double? = null

    @SerializedName("currency")
    @Expose
    var currency: String? = null

    @SerializedName("currencyCode")
    @Expose
    var currencyCode: String? = null

    @SerializedName("oldTotal")
    @Expose
    var oldTotal: Double? = null

    @SerializedName("discountPercentage")
    @Expose
    var discountPercentage: Any? = null

    @SerializedName("showFirstPrice")
    @Expose
    var showFirstPrice: Boolean? = null

    @SerializedName("subscriptionPrice")
    @Expose
    var subscriptionPrice: Double? = null

    @SerializedName("subscriptionDiscountPercentage")
    @Expose
    var subscriptionDiscountPercentage: Any? = null

    @SerializedName("showCurrencyCode")
    @Expose
    var showCurrencyCode: Boolean? = null

    @SerializedName("showDecimalPart")
    @Expose
    var showDecimalPart: Boolean? = null

    @SerializedName("showDotDecimalPart")
    @Expose
    var showDotDecimalPart: Boolean? = null

    @SerializedName("showRegisterCardButton")
    @Expose
    var showRegisterCardButton: Boolean? = null

    @SerializedName("dateBasedDiscountAmount")
    @Expose
    var dateBasedDiscountAmount: Double? = null

    constructor(parcel: Parcel) : this() {
        current = parcel.readValue(Double::class.java.classLoader) as? Double
        old = parcel.readValue(Double::class.java.classLoader) as? Double
        total = parcel.readValue(Double::class.java.classLoader) as? Double
        currency = parcel.readString()
        currencyCode = parcel.readString()
        oldTotal = parcel.readValue(Double::class.java.classLoader) as? Double
        showFirstPrice = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        subscriptionPrice = parcel.readValue(Double::class.java.classLoader) as? Double
        showCurrencyCode = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        showDecimalPart = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        showDotDecimalPart = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        showRegisterCardButton = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        dateBasedDiscountAmount = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Price> {
        override fun createFromParcel(parcel: Parcel): Price {
            return Price(parcel)
        }

        override fun newArray(size: Int): Array<Price?> {
            return arrayOfNulls(size)
        }
    }
}