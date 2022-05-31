package com.lucasmarciano.composeproject.features.sales.components

import com.lucasmarciano.composeproject.R

sealed class TabItem(var id: Int, var name: Int) {
    object Selling : TabItem(TabsIds.SELLING_ID.id, R.string.my_business_tab_name_sell)
    object Charges : TabItem(TabsIds.CHARGES_ID.id, R.string.my_business_tab_name_charges)

    fun getTabs() = arrayOf(Selling, Charges)
}
