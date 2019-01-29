package com.costular.common.util.extensions

fun String.obtainExtension(): String = substringAfterLast('.', "")