package com.github.junyihjy.firstfm;

import android.os.Bundle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;
import mortar.ViewPresenter;

public class Main {

    @dagger.Component @Singleton interface Component {
        void inject(MainView t);
    }

    @Singleton
    static class Presenter extends ViewPresenter<MainView> {
        private final DateFormat format = new SimpleDateFormat();
        private int serial = -1;

        @Inject Presenter() {
        }

        @Override protected void onLoad(Bundle savedInstanceState) {
            if (savedInstanceState != null && serial == -1) serial = savedInstanceState.getInt("serial");
            getView().show("Update #" + ++serial + " at " + format.format(new Date()));
        }

        @Override protected void onSave(Bundle outState) {
            outState.putInt("serial", serial);
        }
    }
}