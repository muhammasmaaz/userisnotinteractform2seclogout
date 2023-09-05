package com.example.userisnotactivelogout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnlogin).setOnClickListener {
            val intent = Intent(this@MainActivity, profileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}

