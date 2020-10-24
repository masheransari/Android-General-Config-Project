package com.dotinfiny.banglesystem.ui.splash

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import com.dotinfiny.banglesystem.MainActivity
import com.dotinfiny.banglesystem.R
import com.dotinfiny.banglesystem.Utils.Constants
import com.dotinfiny.banglesystem.app.BaseActivity
import com.dotinfiny.banglesystem.ui.login.LoginActivity
import com.techwireme.athath.util.launchActivityFinish
import kotlinx.android.synthetic.main.activity_splash.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            openUI()
        }, 3000)

        link.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(Constants.DEVELOPER_WEBSITE_URL))
            startActivity(browserIntent)
        }
    }

    fun openUI() {
        if (getPrefUtil().userId != null && getPrefUtil().userToken != null) {
            launchActivityFinish<LoginActivity> { }
        } else {
            launchActivityFinish<MainActivity> { }
        }
    }

    fun printHashKey(pContext: Context) {
        try {
            val info: PackageInfo = pContext.getPackageManager()
                .getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.encode(md.digest(), 0))
                Log.i("Splash", "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.e("Splash", "printHashKey()", e)
        } catch (e: Exception) {
            Log.e("Splash", "printHashKey()", e)
        }
    }


}