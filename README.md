[![Maven Central][img version shield]][maven]

TISDK
===========

TISDK - SDK for the sale of insurance in mobile applications.

![Gif](img/steps.gif)

# Installation

1) Add to the `build.gradle` of your project:
```Groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

2) Add to the `build.gradle` of your app module:
```Groovy
android {
    defaultConfig {
        multiDexEnabled true
    }
    
    compileOptions {
        sourceCompatibility = '1.8'
        targetCompatibility = '1.8'
    }
}

configurations {
    cleanedAnnotations
    compile.exclude group: 'org.jetbrains' , module:'annotations'
}

dependencies {
    implementation 'ru.tinkoff.tisdk:tisdk:1.2.0'
    implementation 'com.android.support:multidex:1.0.3'
}
```

# Usage

1) Initialize InsuranceBuyingEntrance
```Kotlin
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
```
"fines" - origin application id.

2) Add entry points to the appropriate sections
```Kotlin
class MainActivity : AppCompatActivity() {

    private val insuranceBuyingEntrance = InsuranceBuyingEntrance.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        osago.setOnClickListener {
            insuranceBuyingEntrance.startOsago("osagoProcessId", this, null)
        }
        casco.setOnClickListener {
            insuranceBuyingEntrance.startCasco("cascoProcessId", this, null)
        }
    }
}
```
[img version shield]: https://img.shields.io/maven-central/v/ru.tinkoff.tisdk/tisdk.svg?maxAge=3600
[maven]: https://search.maven.org/search?q=g:ru.tinkoff.tisdk%20a:tisdk