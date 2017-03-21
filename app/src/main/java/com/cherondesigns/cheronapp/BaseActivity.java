package com.cherondesigns.cheronapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import timber.log.Timber;

/**
 * Created by MKinG on 3/21/2017 AD.
 */

public class BaseActivity extends Application implements Application.ActivityLifecycleCallbacks{

    @Override
    public void onCreate() {
            super.onCreate();

//            Fabric.with(this, new Crashlytics());

            //initial shared pref
//            Singleton.getInstance().initSharedPrefs(this);

            //initial for Timber to work only with Debug mode
            if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            }

            //register activity life cycle
            registerActivityLifecycleCallbacks(this);

            }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
            }

    @Override
    public void onActivityStarted(Activity activity) {
            }

    @Override
    public void onActivityResumed(Activity activity) {
            }

    @Override
    public void onActivityPaused(Activity activity) {

            }

    @Override
    public void onActivityStopped(Activity activity) {

            }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

    @Override
    public void onActivityDestroyed(Activity activity) {

            }
}
