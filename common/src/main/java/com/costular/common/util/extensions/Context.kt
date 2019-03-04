package com.costular.common.util.extensions

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle

inline fun <reified T : Any> Context.launchActivity (
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {})
{
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
    {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}

inline fun <reified T : Service> Context.launchService(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {})
{
    val intent = newIntent<T>(this)
    intent.init()
    startService(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)