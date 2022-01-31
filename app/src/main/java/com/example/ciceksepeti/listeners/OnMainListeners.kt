package com.example.ciceksepeti.listeners

import com.example.ciceksepeti.models.DynamicFilter
import com.example.ciceksepeti.models.Product

interface OnMainListeners {

    fun showProgressBarExternal()

    fun hideProgressBarExternal()

    fun clickItemDetail(product: Product)

    fun clickItemCategory(dynamicFilter: DynamicFilter)

    fun openFlowersFilterList(dynamicFilter: ArrayList<DynamicFilter>?)

    fun detailFilter()

}