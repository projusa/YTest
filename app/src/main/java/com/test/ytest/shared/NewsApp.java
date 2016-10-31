package com.test.ytest.shared;

import android.app.Application;

import com.test.ytest.view.fragments.NewsFragment;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;

/**
 * Created by igor on 29.10.16.
 */

public class NewsApp extends Application {

    private News news = null;

    @Singleton
    @Component(modules = { NewsModule.class })
    public interface News {

        void inject(NewsFragment newsFragment);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        news = DaggerNewsApp_News.builder().build();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    public News getNews() {
        return news;
    }
}
