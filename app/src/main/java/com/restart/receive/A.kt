package com.restart.receive

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_a.*

class A : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        setSupportActionBar(toolbar)

        // Check if the activity is started from a deep link
        if (intent.action == Intent.ACTION_VIEW) {
            val data: Uri? = intent.data
            data?.let {
                val message = it.getQueryParameter("message") // Use "message" instead of "Hello There..!"
                if (!message.isNullOrBlank()) {
                    // Use the message parameter as needed
                    textView.text = message
                }
            }
        }

        // Button click to send back a result
        buttonSendResult.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnMessage", "Hello There!")
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }

}
