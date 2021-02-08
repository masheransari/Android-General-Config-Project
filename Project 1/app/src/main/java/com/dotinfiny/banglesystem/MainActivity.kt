package com.dotinfiny.banglesystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dotinfiny.banglesystem.app.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}