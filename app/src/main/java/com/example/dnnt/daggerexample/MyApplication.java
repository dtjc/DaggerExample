package com.example.dnnt.daggerexample;

import android.app.Application;
import android.util.Log;

import com.example.dnnt.daggerexample.dagger2.AppComponent;
import com.example.dnnt.daggerexample.dagger2.DaggerAppComponent;
import com.example.dnnt.daggerexample.dagger2.qualifier.SingleThreadPool;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by dnnt on 17-12-13.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    @Inject
    @SingleThreadPool
    ExecutorService es;
    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        Log.i(TAG,"ExecutorService: " + es.toString());
        Log.i(TAG, "MyApplication: " + this.toString());
    }
}
