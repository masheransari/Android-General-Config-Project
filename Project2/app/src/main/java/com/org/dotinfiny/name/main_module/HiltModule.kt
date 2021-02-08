package com.org.dotinfiny.name.main_module

import android.content.Context
import com.dotinfiny.banglesystem.repository.DatabaseRepository
import com.org.dotinfiny.gamesprime.data.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class HiltModule {

    @Provides
    @Singleton
    fun provideAppRepository(@ApplicationContext context: Context): AppRepository =
        AppRepository(context)

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DatabaseRepository =
        DatabaseRepository(context)

//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext context: Context): DatabaseDao =
//        DatabaseConfig.getInstance(context)!!.daoImplement()!!
}