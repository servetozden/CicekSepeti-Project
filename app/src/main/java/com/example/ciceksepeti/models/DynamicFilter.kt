package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class DynamicFilter () : Parcelable {
    @SerializedName("detailId")
    @Expose
    var detailId: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("sequence")
    @Expose
    var sequence: Int? = null

    @SerializedName("clearLink")
    @Expose
    var clearLink: Any? = null

    @SerializedName("filterType")
    @Expose
    var filterType: Int? = null

    @SerializedName("urlTag")
    @Expose
    var urlTag: Any? = null

    @SerializedName("values")
    @Expose
    var values: List<Value>? = null

    @SerializedName("filterBehaviour")
    @Expose
    var filterBehaviour: Int? = null

    @SerializedName("isMainCategory")
    @Expose
    var isMainCategory: Boolean? = null

    @SerializedName("isReload")
    @Expose
    var isReload: Boolean? = null

    @SerializedName("isRemovableDetail")
    @Expose
    var isRemovableDetail: Boolean? = null

    @SerializedName("dropdownTitle")
    @Expose
    var dropdownTitle: Any? = null

    @SerializedName("dropdownInfo")
    @Expose
    var dropdownInfo: Any? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    constructor(parcel: Parcel) : this() {
        detailId = parcel.readValue(Int::class.java.classLoader) as? Int
        name = parcel.readString()
        sequence = parcel.readValue(Int::class.java.classLoader) as? Int
        filterType = parcel.readValue(Int::class.java.classLoader) as? Int
        filterBehaviour = parcel.readValue(Int::class.java.classLoader) as? Int
        isMainCategory = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isReload = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isRemovableDetail = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(detailId)
        parcel.writeString(name)
        parcel.writeValue(sequence)
        parcel.writeValue(filterType)
        parcel.writeValue(filterBehaviour)
        parcel.writeValue(isMainCategory)
        parcel.writeValue(isReload)
        parcel.writeValue(isRemovableDetail)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DynamicFilter> {
        override fun createFromParcel(parcel: Parcel): DynamicFilter {
            return DynamicFilter(parcel)
        }

        override fun newArray(size: Int): Array<DynamicFilter?> {
            return arrayOfNulls(size)
        }
    }
}