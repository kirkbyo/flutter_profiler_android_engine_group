package com.example.app

import io.flutter.app.FlutterApplication
import io.flutter.embedding.engine.FlutterEngineGroup

class App : FlutterApplication() {
    lateinit var engines: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engines = FlutterEngineGroup(this);
    }
}