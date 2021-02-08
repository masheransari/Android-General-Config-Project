package com.dotinfiny.banglesystem.customInterface

import android.view.View

interface OnCustomItemClickListener {
    fun setOnClickListener(data: Any, position: Int, view: View)
}