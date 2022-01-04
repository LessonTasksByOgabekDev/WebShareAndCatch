package dev.ogabek.webshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val btn_send = findViewById<Button>(R.id.btn_send)
        val et_url = findViewById<EditText>(R.id.et_url)
        btn_send.setOnClickListener {
            sendUrl(et_url.text.toString())
        }
    }

    private fun sendUrl(url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, url)
        startActivity(Intent.createChooser(intent, "Share"))
    }

}