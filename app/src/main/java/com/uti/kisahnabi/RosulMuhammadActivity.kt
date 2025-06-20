package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RosulMuhammadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rosul_muhammad)

        val buttonkeKembali: Button = findViewById(R.id.kembalikekisahnabi)

        buttonkeKembali.setOnClickListener {
            val intent = Intent(this, KisahNabi::class.java)
            startActivity(intent)
        }

        val buttonSelanjutnya: Button = findViewById(R.id.selanjutnyake2)

        buttonSelanjutnya.setOnClickListener {
            val intent = Intent(this, NabiIdrisActivity::class.java)
            startActivity(intent)
        }

        val buttonKembali: Button = findViewById(R.id.kembalikisahnabi)

        buttonKembali.setOnClickListener {
            val intent = Intent(this, KisahNabi::class.java)
            startActivity(intent)
        }
        setContentView(R.layout.activity_rosul_muhammad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}