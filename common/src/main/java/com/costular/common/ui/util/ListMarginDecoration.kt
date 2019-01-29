package com.costular.common.ui.util

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.costular.common.util.extensions.toPx

internal class ListMarginDecoration(resources: Resources,
                                    marginDps: Int = 8) : RecyclerView.ItemDecoration() {

    var marginPx: Int = marginDps.toPx(resources)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent != null && view != null) {
            val itemPosition = parent.getChildAdapterPosition(view)
            val totalCount = parent.adapter?.itemCount ?: 0

            if (itemPosition >= 0 && itemPosition < totalCount - 1) {
                outRect.bottom = marginPx
            }
        }
    }

}