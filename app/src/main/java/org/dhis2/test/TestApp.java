package org.dhis2.test;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.dhis2.App;
import org.dhis2.AppComponent;
import org.dhis2.data.forms.FormComponent;
import org.dhis2.data.forms.FormModule;
import org.dhis2.data.server.ServerComponent;
import org.dhis2.data.user.UserComponent;
import org.dhis2.usescases.login.LoginComponent;
import org.dhis2.usescases.teiDashboard.TeiDashboardComponent;
import org.dhis2.usescases.teiDashboard.TeiDashboardModule;

public class TestApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @NonNull
    @Override
    protected AppComponent.Builder prepareAppComponent() {
        return super.prepareAppComponent();
    }

    @NonNull
    @Override
    protected AppComponent createAppComponent() {
        return super.createAppComponent();
    }

    @NonNull
    @Override
    public AppComponent appComponent() {
        return super.appComponent();
    }

    @NonNull
    @Override
    public LoginComponent createLoginComponent() {
        return super.createLoginComponent();
    }

    @Nullable
    @Override
    public LoginComponent loginComponent() {
        return super.loginComponent();
    }

    @Override
    public void releaseLoginComponent() {
        super.releaseLoginComponent();
    }

    @Override
    public ServerComponent createServerComponent() {
        return super.createServerComponent();
    }

    @Nullable
    @Override
    public ServerComponent serverComponent() {
        return super.serverComponent();
    }

    @Override
    public void releaseServerComponent() {
        super.releaseServerComponent();
    }

    @Override
    public ServerComponent getServerComponent() {
        return super.getServerComponent();
    }

    @Override
    public UserComponent createUserComponent() {
        return super.createUserComponent();
    }

    @Override
    public UserComponent userComponent() {
        return super.userComponent();
    }

    @Override
    public void releaseUserComponent() {
        super.releaseUserComponent();
    }

    @NonNull
    @Override
    public FormComponent createFormComponent(@NonNull FormModule formModule) {
        return super.createFormComponent(formModule);
    }

    @Nullable
    @Override
    public FormComponent formComponent() {
        return super.formComponent();
    }

    @Override
    public void releaseFormComponent() {
        super.releaseFormComponent();
    }

    @NonNull
    @Override
    public TeiDashboardComponent createDashboardComponent(@NonNull TeiDashboardModule dashboardModule) {
        return super.createDashboardComponent(dashboardModule);
    }

    @Nullable
    @Override
    public TeiDashboardComponent dashboardComponent() {
        return super.dashboardComponent();
    }

    @Override
    public void releaseDashboardComponent() {
        super.releaseDashboardComponent();
    }

    @Override
    public void setTestComponent(AppComponent testingComponent) {
        super.setTestComponent(testingComponent);
    }
}
