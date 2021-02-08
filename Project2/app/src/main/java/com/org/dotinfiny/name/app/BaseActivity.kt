package com.org.dotinfiny.name

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dotinfiny.banglesystem.repository.DatabaseRepository
import com.google.android.material.snackbar.Snackbar
import com.kaopiz.kprogresshud.KProgressHUD
import com.org.dotinfiny.name.utils.HawkUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


open class BaseActivity : AppCompatActivity() {
    //    private var progressBarDialog = ProgressBarDialog()
    private var progressBarDialog: KProgressHUD? = null
    private var prefUtil: HawkUtil? = null
    private var dbRepository: DatabaseRepository? = null

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun logout(context: Context) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Want to logout!").setMessage("Are you sure to logout from application?")
            .setCancelable(false)
            .setPositiveButton("Logout") { _, _ ->
                if (dbRepository == null) {
                    dbRepository = DatabaseRepository(context)
                }
                GlobalScope.launch {
                    dbRepository!!.removeAllTables()
                }
                getPrefUtil().doLogout()
//                launchActivityFinish<LoginActivity> {//SignInActivity here
//                }
                finish()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    fun logoutWithoutDialog(context: Context) {
        if (dbRepository == null) {
            dbRepository = DatabaseRepository(context)
        }
        GlobalScope.launch {
            dbRepository!!.removeAllTables()
        }
        getPrefUtil().doLogout()
    }

    fun getPrefUtil(): HawkUtil {
        if (prefUtil == null) {
            prefUtil = HawkUtil.getInstance(this)
        }
        return prefUtil!!
    }

    fun addProgressBar(
        ctx: Context,
        _message: String/*, @DrawableRes @Nullable int icon*/
    ) {
        if (progressBarDialog == null) {
            progressBarDialog = KProgressHUD.create(ctx)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
        }

        progressBarDialog?.setLabel(_message)
        progressBarDialog?.show()
    }

    fun dismissDialogBox() {
        if (progressBarDialog != null) {
            if (progressBarDialog!!.isShowing) {
                progressBarDialog!!.dismiss()
            }
        }
    }

    fun showSnackBar(view: View, content: String) {
        Snackbar.make(view, content, Snackbar.LENGTH_LONG)
            .setAction("CLOSE", object : View.OnClickListener {
                override fun onClick(p0: View?) {

                }
            })
            .setActionTextColor(resources.getColor(R.color.holo_red_light))
            .show()
    }

    fun showSnackBar(view: View) {
        Snackbar.make(
            view,
            "Internet Connectivity Error, please check your internet connection",
            Snackbar.LENGTH_LONG
        )
            .setAction("CLOSE", object : View.OnClickListener {
                override fun onClick(p0: View?) {

                }
            })
            .setActionTextColor(resources.getColor(R.color.holo_red_light))
            .show()
    }
}