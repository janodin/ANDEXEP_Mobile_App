package com.example.andexep

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Declare the WebView variable for later use.
    private lateinit var myWebView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for this activity using activity_main.xml.
        setContentView(R.layout.activity_main)

        // Initialize the WebView
        myWebView = findViewById(R.id.webview)

        // Set the WebViewClient to ensure links open within the WebView and not in an external browser
        myWebView.webViewClient = WebViewClient()

        // Enable JavaScript if your webpage uses JavaScript
        myWebView.settings.javaScriptEnabled = true

        // Load the website URL
        myWebView.loadUrl("https://andexep.up.railway.app/")

        // Set up the back button behavior for WebView.
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Check if WebView can navigate back, if so, navigate back.
                if (myWebView.canGoBack()) {
                    myWebView.goBack()
                } else {
                    // If WebView can't navigate back, exit the activity.
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }

        // Attach the back button callback to the activity's back button dispatcher.
        onBackPressedDispatcher.addCallback(this, callback)
    }
}
