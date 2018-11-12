[![Maven Central][img version shield]][maven]

TISDK
===========

TISDK - SDK for the sale of insurance in mobile applications.

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
}

dependencies {
    implementation 'ru.tinkoff.tisdk:tisdk:$latestVersion'
    implementation 'com.android.support:multidex:1.0.3'
}
```

# Usage

1) Initialize InsuranceBuyingEntrance
```Java
public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        String sessionId = UUID.randomUUID().toString();

        InsuranceBuyingEntrance.instance().init(
                getApplicationContext(),
                () -> sessionId,
                false,
                "fines",
                ServiceLocator.class
        );
    }
}
```
"fines" - origin application id.

2) Add entry points to the appropriate sections
```Java
public class DemoTisdkActivity extends AppCompatActivity {
    private InsuranceBuyingEntrance insuranceBuyingEntrance = InsuranceBuyingEntrance.instance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_tisdk);
    }

    public void onClickOsago(View view) {
        insuranceBuyingEntrance.startOsago(this, null);
    }

    public void onClickCasco(View view) {
        insuranceBuyingEntrance.startCasco(this, null);
    }

}
```

[img version shield]: https://img.shields.io/maven-central/v/ru.tinkoff.tisdk/tisdk.svg?maxAge=3600
[maven]: https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22ru.tinkoff.tisdk%22