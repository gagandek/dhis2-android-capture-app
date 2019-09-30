package org.dhis2.usescases.login

import dagger.Module
import dagger.Provides
import org.dhis2.data.dagger.PerActivity
import org.dhis2.data.sharedPreferences.SharePreferencesProvider

/**
 * QUADRAM. Created by ppajuelo on 07/02/2018.
 */

@Module
@PerActivity
class LoginModule {

    @Provides
    @PerActivity
    internal fun providePresenter(sharePreferencesProvider: SharePreferencesProvider): LoginContracts.Presenter {
        return LoginPresenter(sharePreferencesProvider)
    }


}
