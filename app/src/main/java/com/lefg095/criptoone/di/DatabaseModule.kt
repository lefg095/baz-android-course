package com.lefg095.criptoone.di

import android.content.Context
import androidx.room.Room
import com.lefg095.criptoone.domain.dao.BookDao
import com.lefg095.criptoone.domain.dao.OrderDao
import com.lefg095.criptoone.domain.dao.TickerDao
import com.lefg095.criptoone.domain.database.CoinOneDatabase
import com.lefg095.criptoone.util.NAME_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideBookDao(appDatabase: CoinOneDatabase): BookDao {
        return appDatabase.bookDao()
    }

    @Provides
    fun provideTickerDao(appDatabase: CoinOneDatabase): TickerDao {
        return appDatabase.tickerDao()
    }

    @Provides
    fun provideOrderDao(appDatabase: CoinOneDatabase) : OrderDao {
        return appDatabase.orderDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext app: Context): CoinOneDatabase {
        return Room.databaseBuilder(
            app,
            CoinOneDatabase::class.java,
            NAME_DB
        ).fallbackToDestructiveMigration()
        .build()
    }

}