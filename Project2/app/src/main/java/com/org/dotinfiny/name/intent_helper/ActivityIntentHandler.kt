package com.techwireme.athath.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.dotinfiny.banglesystem.R

inline fun <reified T : Any> Activity.launchActivity(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
    overridePendingTransition(R.anim.bottom_up, R.anim.nothing)
    startActivityForResult(intent, requestCode, options)
}

inline fun <reified T : Any> Activity.launchActivityFinish(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    overridePendingTransition(R.anim.bottom_up, R.anim.nothing)
    startActivity(intent, options)
    finish()
}

inline fun <reified T : Any> Activity.launchActivityTop(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
//    startActivity(intent, requestCode, options)
    startActivity(intent, options)
    overridePendingTransition(R.anim.bottom_up, R.anim.nothing)
}

inline fun <reified T : Any> Context.launchActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
    startActivity(intent, options)
//    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)