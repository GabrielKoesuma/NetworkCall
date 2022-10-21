package com.ukm.networkcall.presentation

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.ukm.networkcall.R
import com.ukm.networkcall.databinding.RowItemTestBinding

class TestingAdapter : BaseQuickAdapter<String, BaseDataBindingHolder<RowItemTestBinding>>(
    R.layout.row_item_test
) {
    override fun convert(holder: BaseDataBindingHolder<RowItemTestBinding>, item: String) {
        holder.dataBinding?.testing= item
    }
}