package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Value () : Parcelable {
    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("selected")
    @Expose
    var selected: Boolean? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("filterQueryString")
    @Expose
    var filterQueryString: Any? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("icon")
    @Expose
    var icon: String? = null

    @SerializedName("group")
    @Expose
    var group: Int? = null

    @SerializedName("detailValueId")
    @Expose
    var detailValueId: Int? = null

    @SerializedName("regionRequired")
    @Expose
    var regionRequired: Boolean? = null

    @SerializedName("filterQueryStringWithProductGroup")
    @Expose
    var filterQueryStringWithProductGroup: Any? = null

    @SerializedName("isChecked")
    @Expose
    var isChecked: Boolean = false

    constructor(parcel: Parcel) : this() {
        count = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        selected = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        link = parcel.readString()
        name = parcel.readString()
        icon = parcel.readString()
        group = parcel.readValue(Int::class.java.classLoader) as? Int
        detailValueId = parcel.readValue(Int::class.java.classLoader) as? Int
        regionRequired = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(count)
        parcel.writeValue(id)
        parcel.writeValue(selected)
        parcel.writeString(link)
        parcel.writeString(name)
        parcel.writeString(icon)
        parcel.writeValue(group)
        parcel.writeValue(detailValueId)
        parcel.writeValue(regionRequired)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Value> {
        override fun createFromParcel(parcel: Parcel): Value {
            return Value(parcel)
        }

        override fun newArray(size: Int): Array<Value?> {
            return arrayOfNulls(size)
        }
    }
}