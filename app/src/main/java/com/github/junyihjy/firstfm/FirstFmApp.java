package com.github.junyihjy.firstfm;

import android.app.Application;
import android.support.annotation.NonNull;

import mortar.MortarScope;

public class FirstFmApp extends Application {
    private MortarScope rootScope;

    @Override
    public Object getSystemService(@NonNull String name) {
        if (rootScope == null) rootScope = MortarScope.buildRootScope().build("Root");

        return rootScope.hasService(name) ? rootScope.getService(name) : super.getSystemService(name);
    }
}
