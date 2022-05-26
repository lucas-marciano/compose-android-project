package com.lucasmarciano.composeproject.features.sales.components

import com.lucasmarciano.composeproject.R
import com.lucasmarciano.composeproject.utils.ComposableArgs

sealed class TabItem(var id: Int, var name: Int, var screen: ComposableArgs) {
    object Selling : TabItem(TabsIds.SELLING_ID.id, R.string.my_business_tab_name_sell, {})
    object Charges : TabItem(TabsIds.CHARGES_ID.id, R.string.my_business_tab_name_charges, {})

    fun findTab(item: TabItem) = when (item) {
        is Selling -> Selling
        is Charges -> Charges
    }

    fun getTabs() = arrayOf(Selling, Charges)
}
