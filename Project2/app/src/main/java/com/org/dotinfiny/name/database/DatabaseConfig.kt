package com.dotinfiny.banglesystem.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.org.dotinfiny.name.Constants


@Database(entities = [], version = 4, exportSchema = false)
abstract class DatabaseConfig : RoomDatabase() {
    abstract fun daoImplement(): DatabaseDao?

    companion object {
        private var instance: DatabaseConfig? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseConfig? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DatabaseConfig::class.java, Constants.DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
