package dev.ogabek.webshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class ShareCatchWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_catch_web)

        initViews()

    }

    private fun initViews() {
        val intent = intent
        val action = intent.action
        val type = intent.type
        if (Intent.ACTION_SEND == action && type != null) {
            if ("text/plain" == type) {
                handleSendURL(intent)
            } else {
                Toast.makeText(this, "Could not handle", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleSendURL(intent: Intent) {
        val webView = findViewById<WebView>(R.id.wv_load_url)
        webView.webViewClient = WebViewClient()
        val sharedURL = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (URLUtil.isValidUrl(sharedURL))
            webView.loadUrl(sharedURL!!)
        else
            Toast.makeText(this, "Invalid url", Toast.LENGTH_SHORT).show()
    }

}