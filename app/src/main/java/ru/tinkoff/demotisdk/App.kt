package ru.tinkoff.demotisdk

import androidx.multidex.MultiDexApplication
import io.reactivex.plugins.RxJavaPlugins
import ru.tinkoff.core.log.Logger

import java.util.UUID

import ru.tinkoff.tisdk.InsuranceBuyingEntrance
import ru.tinkoff.tisdk.SessionProvider
import ru.tinkoff.tisdk.common.ServiceLocator

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        val sessionId = UUID.randomUUID().toString()

        val insuranceBuyingEntrance = InsuranceBuyingEntrance.instance()

        // Инициализация sdk
        insuranceBuyingEntrance.init(
                context = applicationContext,
                sessionProvider = SessionProvider { sessionId },
                isDebug = false,
                serviceLocatorClass = ServiceLocator::class.java
        )

        // Настройка партнерской программы
        insuranceBuyingEntrance
                .setSource("tisdk_fines")
                .setOrigin("fines")
                .setMarketingChannel("broker")
                .setMarketingSource("broker_systems")

        // Дефолтный обработчик ошибок для RxJava2
        RxJavaPlugins.setErrorHandler {
            Logger.e(javaClass.name, it.message)
        }
    }
}
