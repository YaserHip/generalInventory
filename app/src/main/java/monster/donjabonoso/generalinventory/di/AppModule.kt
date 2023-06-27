package monster.donjabonoso.generalinventory.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class AppModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {


    }
}