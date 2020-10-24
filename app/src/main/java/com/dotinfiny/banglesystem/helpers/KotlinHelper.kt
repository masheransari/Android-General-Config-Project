package com.org.dotinfiny.gamesprime.helpers

import android.text.TextUtils
import android.util.Patterns
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

class KotlinHelper {
    companion object {
        fun isJSONValid(jsonString: String?): Boolean {
            return try {
                JSONObject(jsonString)
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }

        fun getRequestBody(body: String): RequestBody =
            RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body)

        fun isValidEmail(target: CharSequence): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }


}