package com.dotinfiny.banglesystem.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.dotinfiny.banglesystem.database.DatabaseConfig.Companion.getInstance
import com.dotinfiny.banglesystem.model.api.PostModel
import com.dotinfiny.banglesystem.model.local.DbPostModel

class DatabaseRepository(private val context: Context) {

    suspend fun removeAllTables() {
        getInstance(context)!!.daoImplement()!!.deleteTableEnteries()
    }

    suspend fun insertNewData(list: ArrayList<PostModel>) {
        removeAllTables()
        getInstance(context)!!.daoImplement()!!.insertListOfPost(list)
    }

    fun getPost(): LiveData<List<PostModel>> {
        return getInstance(context)!!.daoImplement()!!.getPost()
    }

    fun getDbPost(): LiveData<List<DbPostModel>> {
        return getInstance(context)!!.daoImplement()!!.getDbPost()
    }

    suspend fun markAsFavourite(data: DbPostModel) {
        getInstance(context)!!.daoImplement()!!.addFavourite(data)

    }

    suspend fun removeFromTable(data: DbPostModel) {
        getInstance(context)!!.daoImplement()!!.deleteFromFavourite(data.id)
    }

}
