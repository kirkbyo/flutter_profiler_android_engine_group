Sample app which replicates the problem described in: https://github.com/flutter/flutter/issues/136054.

## Reproduction

1. Create a new flutter project: `flutter create app`
2. In the Android Platform code, create a custom `FlutterApplication`:

```kotlin
import io.flutter.app.FlutterApplication
import io.flutter.embedding.engine.FlutterEngineGroup

class App : FlutterApplication() {
    lateinit var engines: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engines = FlutterEngineGroup(this);
    }
}
```

3. In the activity, use the engine group to create `provideFlutterEngine`:

```kotlin
import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        val app = context.applicationContext as App
        return app.engines.createAndRunDefaultEngine(context);
    }
}
```

4. In your `AndroidManifest.xml`, use the custom application:

```xml
    <application
        android:label="app"
        android:name=".App"
        android:icon="@mipmap/ic_launcher">
```

5. Run the app in the app in profile `flutter run --profile`