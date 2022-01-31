package com.example.ciceksepeti.models

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Product() : Parcelable, BaseObservable() {
    @SerializedName("adsModel")
    @Expose
    var adsModel: Any? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("webLink")
    @Expose
    var webLink: String? = null

    @SerializedName("deliveryBadgeType")
    @Expose
    var deliveryBadgeType: Int? = null

    @SerializedName("deliveryBadgeText")
    @Expose
    var deliveryBadgeText: String? = null

    @SerializedName("deliveryChargeText")
    @Expose
    var deliveryChargeText: String? = null

    @SerializedName("price")
    @Expose
    var price: Price? = null

    @SerializedName("dateBasedDiscount")
    @Expose
    var dateBasedDiscount: Any? = null

    @SerializedName("marketplaceBranch")
    @Expose
    var marketplaceBranch: Any? = null

    @SerializedName("isMarketplace")
    @Expose
    var isMarketplace: Boolean? = null

    @SerializedName("largeImage")
    @Expose
    var largeImage: String? = null

    @SerializedName("isDiscountAvailable")
    @Expose
    var isDiscountAvailable: Boolean? = null

    @SerializedName("isOriginal")
    @Expose
    var isOriginal: Boolean? = null

    @SerializedName("installment")
    @Expose
    var installment: Boolean? = null

    @SerializedName("installmentText")
    @Expose
    var installmentText: String? = null

    @SerializedName("smallImage")
    @Expose
    var smallImage: String? = null

    @SerializedName("xlargeImage")
    @Expose
    var xlargeImage: String? = null

    @SerializedName("mediumImage")
    @Expose
    var mediumImage: String? = null

    @SerializedName("mostSellestProduct")
    @Expose
    var mostSellestProduct: Boolean? = null

    @SerializedName("isHaveVase")
    @Expose
    var isHaveVase: Boolean? = null

    @SerializedName("isHaveVaseText")
    @Expose
    var isHaveVaseText: String? = null

    @SerializedName("productDeliveryCity")
    @Expose
    var productDeliveryCity: ProductDeliveryCity? = null

    @SerializedName("productGroupId")
    @Expose
    var productGroupId: Int? = null

    @SerializedName("variantCode")
    @Expose
    var variantCode: String? = null

    @SerializedName("entryId")
    @Expose
    var entryId: Int? = null

    @SerializedName("reviewRating")
    @Expose
    var reviewRating: Double? = null

    @SerializedName("deliveryChargeMessage")
    @Expose
    var deliveryChargeMessage: Any? = null

    @SerializedName("reviewCount")
    @Expose
    var reviewCount: Int? = null

    @SerializedName("information")
    @Expose
    var information: String? = null

    @SerializedName("isSubscription")
    @Expose
    var isSubscription: Boolean? = null

    @SerializedName("productType")
    @Expose
    var productType: Int? = null

    @SerializedName("isDigital")
    @Expose
    var isDigital: Boolean? = null

    @SerializedName("role")
    @Expose
    var role: Any? = null

    @SerializedName("responseTimeText")
    @Expose
    var responseTimeText: Any? = null

    @SerializedName("showPriceDroppedTagAtFavoritePage")
    @Expose
    var showPriceDroppedTagAtFavoritePage: Boolean? = null

    @SerializedName("isRequiredLegalPermission")
    @Expose
    var isRequiredLegalPermission: Boolean? = null

    @SerializedName("productCategoryId")
    @Expose
    var productCategoryId: Int? = null

    @SerializedName("eCommerceCategoryName")
    @Expose
    private var eCommerceCategoryName: Any? = null

    @SerializedName("productId")
    @Expose
    var productId: Int? = null

    @SerializedName("variantId")
    @Expose
    var variantId: Any? = null

    @SerializedName("productGroupName")
    @Expose
    var productGroupName: Any? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        code = parcel.readString()
        name = parcel.readString()
        image = parcel.readString()
        link = parcel.readString()
        webLink = parcel.readString()
        deliveryBadgeType = parcel.readValue(Int::class.java.classLoader) as? Int
        deliveryBadgeText = parcel.readString()
        deliveryChargeText = parcel.readString()
        price = parcel.readParcelable(Price::class.java.classLoader)
        isMarketplace = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        largeImage = parcel.readString()
        isDiscountAvailable = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isOriginal = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        installment = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        installmentText = parcel.readString()
        smallImage = parcel.readString()
        xlargeImage = parcel.readString()
        mediumImage = parcel.readString()
        mostSellestProduct = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isHaveVase = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isHaveVaseText = parcel.readString()
        productGroupId = parcel.readValue(Int::class.java.classLoader) as? Int
        variantCode = parcel.readString()
        entryId = parcel.readValue(Int::class.java.classLoader) as? Int
        reviewRating = parcel.readValue(Double::class.java.classLoader) as? Double
        reviewCount = parcel.readValue(Int::class.java.classLoader) as? Int
        information = parcel.readString()
        isSubscription = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        productType = parcel.readValue(Int::class.java.classLoader) as? Int
        isDigital = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        showPriceDroppedTagAtFavoritePage =
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isRequiredLegalPermission = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        productCategoryId = parcel.readValue(Int::class.java.classLoader) as? Int
        productId = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    fun geteCommerceCategoryName(): Any? {
        return eCommerceCategoryName
    }

    fun seteCommerceCategoryName(eCommerceCategoryName: Any?) {
        this.eCommerceCategoryName = eCommerceCategoryName
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(name)
        p0.writeString(link)
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}