package com.example.app

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        val app = context.applicationContext as App
        return app.engines.createAndRunDefaultEngine(context);
    }
}
