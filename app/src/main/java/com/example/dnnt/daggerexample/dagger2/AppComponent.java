package com.example.dnnt.daggerexample.dagger2;

import android.content.Context;

import com.example.dnnt.daggerexample.MyApplication;
import com.example.dnnt.daggerexample.login.LoginComponent;

import java.util.concurrent.ExecutorService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by dnnt on 17-12-16.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MyApplication myApplication);
    LoginComponent.Builder loginComponent();

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Context context);
        AppComponent build();
    }
}
