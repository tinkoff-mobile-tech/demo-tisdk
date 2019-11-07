package ru.tinkoff.demotisdk

import androidx.multidex.MultiDexApplication

import java.util.UUID

import ru.tinkoff.tisdk.InsuranceBuyingEntrance
import ru.tinkoff.tisdk.SessionProvider
import ru.tinkoff.tisdk.common.ServiceLocator

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        val sessionId = UUID.randomUUID().toString()

        InsuranceBuyingEntrance.instance().init(
                applicationContext,
                SessionProvider { sessionId },
                false,
                "fines",
                ServiceLocator::class.java
        )
    }
}
