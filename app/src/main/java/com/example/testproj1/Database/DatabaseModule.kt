package com.example.testproj1.Database

import android.content.Context
import com.example.testproj1.Database.Dao.DataDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getdatabase(@ApplicationContext context: Context):Database1
    {
        return Database1.getdatabase(context)
    }
    @Provides
    fun provideDataDAO(database: Database1): DataDAO {
        return database.datadao()
    }
}