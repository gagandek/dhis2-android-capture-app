package org.dhis2.test

import dagger.Module
import dagger.Provides
import org.dhis2.data.dagger.PerActivity
import org.dhis2.usescases.splash.SplashActivity
import org.dhis2.usescases.splash.SplashContracts
import org.dhis2.usescases.splash.SplashPresenter
import javax.inject.Named

@Module
class FakeSplashModule internal constructor() {
    @Provides
    @PerActivity
    fun providePresenter(): SplashContracts.Presenter {
        return SplashPresenter(FakeUserManager())
    }

    @Provides
    @PerActivity
    @Named(SplashActivity.FLAG)
    fun provideFlag(): String {
        return ""
    }
}