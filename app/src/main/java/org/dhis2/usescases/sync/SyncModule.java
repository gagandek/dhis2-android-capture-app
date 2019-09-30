package org.dhis2.usescases.sync;

import org.dhis2.data.dagger.PerActivity;
import org.dhis2.data.sharedPreferences.SharePreferencesProvider;
import org.hisp.dhis.android.core.D2;

import dagger.Module;
import dagger.Provides;

@Module
@PerActivity
public class SyncModule {

    @Provides
    @PerActivity
    SyncContracts.Presenter providePresenter(D2 d2, SharePreferencesProvider provider) {
        return new SyncPresenter(d2, provider);
    }
}
