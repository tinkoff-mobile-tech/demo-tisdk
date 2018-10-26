package ru.tinkoff.demotisdk;

import android.support.multidex.MultiDexApplication;

import java.util.UUID;

import ru.tinkoff.tisdk.InsuranceBuyingEntrance;
import ru.tinkoff.tisdk.common.ServiceLocator;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        String sessionId = UUID.randomUUID().toString();

        InsuranceBuyingEntrance.instance().init(
                getApplicationContext(),
                () -> sessionId,
                false,
                ServiceLocator.class
        );
    }
}
