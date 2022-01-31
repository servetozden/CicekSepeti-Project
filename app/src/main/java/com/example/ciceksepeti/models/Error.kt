package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Error  () : Parcelable{
    @SerializedName("type")
    @Expose
    var type: Int? = null

    @SerializedName("title")
    @Expose
    var title: Any? = null

    @SerializedName("message")
    @Expose
    var message: Any? = null

    @SerializedName("returnUrl")
    @Expose
    var returnUrl: Any? = null

    constructor(parcel: Parcel) : this() {
        type = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Error> {
        override fun createFromParcel(parcel: Parcel): Error {
            return Error(parcel)
        }

        override fun newArray(size: Int): Array<Error?> {
            return arrayOfNulls(size)
        }
    }


}