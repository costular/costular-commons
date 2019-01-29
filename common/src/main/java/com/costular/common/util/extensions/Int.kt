package com.costular.common.util.extensions

import android.content.res.Resources

fun Int.toDp(resources: Resources): Int = (this / resources.displayMetrics.density).toInt()

fun Int.toPx(resources: Resources): Int = (this * resources.displayMetrics.density).toInt()