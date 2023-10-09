package com.example.app

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor

class ExampleContentProvider : ContentProvider() {
    private lateinit var engine: FlutterEngine

    override fun onCreate(): Boolean {
        val app = context!!.applicationContext as App

        Log.d("flutter", "(Android) Attempting engine start")

        val flutterLoader = FlutterInjector.instance().flutterLoader()
        flutterLoader.startInitialization(context!!.applicationContext)

        // create the engine group
        app.createEngineGroupIfNeeded(app);

        val entrypoint = DartExecutor.DartEntrypoint(flutterLoader.findAppBundlePath(), "runContentProvider")
        engine = app.engines.createAndRunEngine(context!!, entrypoint)

        Log.d("flutter", "(Android) Attaching Content Provider")


        return true;
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }
}