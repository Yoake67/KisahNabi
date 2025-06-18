package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NabiNuhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nabi_nuh)

        val buttonSebelumnya: Button = findViewById(R.id.sebelumnyake2)

        buttonSebelumnya.setOnClickListener {
            val intent = Intent(this, NabiIdrisActivity::class.java)
            startActivity(intent)
        }

        val buttonSelanjutnya: Button = findViewById(R.id.selanjutnyake4)

        buttonSelanjutnya.setOnClickListener {
            val intent = Intent(this, NabiHudActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}