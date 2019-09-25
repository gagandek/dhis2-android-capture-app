package org.dhis2.test

import io.reactivex.Observable
import io.reactivex.Single
import org.dhis2.data.server.UserManager
import org.hisp.dhis.android.core.D2
import org.hisp.dhis.android.core.user.User

class FakeUserManager: UserManager {
    override fun logIn(username: String, password: String): Observable<User> {
        return Observable.just(User.Builder()
                .build())
    }

    override fun isUserLoggedIn(): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userInitials(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userFullName(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userName(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getD2(): D2 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}