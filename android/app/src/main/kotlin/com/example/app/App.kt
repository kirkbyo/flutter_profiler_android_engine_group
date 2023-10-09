package com.example.app

import android.content.Context
import io.flutter.app.FlutterApplication
import io.flutter.embedding.engine.FlutterEngineGroup

class App : FlutterApplication() {
    lateinit var engines: FlutterEngineGroup
    private var isEngineAttached = false;

    override fun onCreate() {
        super.onCreate()
        createEngineGroupIfNeeded(this);
    }

    fun createEngineGroupIfNeeded(context: Context) {
        if (isEngineAttached) {
            return;
        }
        engines = FlutterEngineGroup(this);
        isEngineAttached = true;
    }
}