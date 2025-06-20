package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NabiIdrisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nabi_idris)

        val buttonSebelumnya: Button = findViewById(R.id.sebelumnyake1)

        buttonSebelumnya.setOnClickListener {
            val intent = Intent(this, NabiAdamActivity::class.java)
            startActivity(intent)
        }

        val buttonSelanjutnya: Button = findViewById(R.id.selanjutnyake3)

        buttonSelanjutnya.setOnClickListener {
            val intent = Intent(this, NabiNuhActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}