package com.dotinfiny.banglesystem.app

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dotinfiny.banglesystem.Utils.HawkUtil
import com.dotinfiny.banglesystem.repository.DatabaseRepository
import com.dotinfiny.banglesystem.ui.login.LoginActivity
import com.kaopiz.kprogresshud.KProgressHUD
import com.techwireme.athath.util.launchActivityFinish


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
                dbRepository!!.removeAllTables()
                getPrefUtil().doLogout()
                launchActivityFinish<LoginActivity> {//SignInActivity here
                }
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
        dbRepository!!.removeAllTables()
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
}