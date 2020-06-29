package com.example.flutterapp;

import android.widget.Toast;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private String TOAST_CHANNEL = "com.example.flutterapp/toast";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), TOAST_CHANNEL)
                .setMethodCallHandler((call, result) -> {
                    if (call.method.equals("show_toast")) {
                        Toast.makeText(this, call.argument("message"), Toast.LENGTH_SHORT).show();
                        result.success(true);
                    }
                });
    }
}
