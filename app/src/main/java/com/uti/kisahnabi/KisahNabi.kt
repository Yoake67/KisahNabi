package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class KisahNabi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kisah_nabi)

        val buttonNabiAdam: Button = findViewById(R.id.BtnNabi1)

        buttonNabiAdam.setOnClickListener {
            val intent = Intent(this, NabiAdamActivity::class.java)
            startActivity(intent)
        }

        val buttonNabiIdris: Button = findViewById(R.id.BtnNabi2)

        buttonNabiIdris.setOnClickListener {
            val intent = Intent(this, NabiIdrisActivity::class.java)
            startActivity(intent)
        }

        val buttonNabiNuh: Button = findViewById(R.id.BtnNabi3)

        buttonNabiNuh.setOnClickListener {
            val intent = Intent(this, NabiNuhActivity::class.java)
            startActivity(intent)
        }

        val buttonNabiHud: Button = findViewById(R.id.BtnNabi4)

        buttonNabiHud.setOnClickListener {
            val intent = Intent(this, NabiHudActivity::class.java)
            startActivity(intent)
        }

        val buttonNabiSaleh: Button = findViewById(R.id.BtnNabi5)

        buttonNabiSaleh.setOnClickListener {
            val intent = Intent(this, NabiSalehActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}