package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KisahrosulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kisahrosul)

        val buttonKembalikeMain: Button = findViewById(R.id.kembalikemain)

        buttonKembalikeMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonRosulMuhammad: Button = findViewById(R.id.BtnNabi1)

        buttonRosulMuhammad.setOnClickListener {
            val intent = Intent(this, RosulMuhammadActivity::class.java)
            startActivity(intent)
        }

        val buttonRosulIsa: Button = findViewById(R.id.BtnNabi2)

        buttonRosulIsa.setOnClickListener {
            val intent = Intent(this, RosulIsaActivity::class.java)
            startActivity(intent)
        }

        val buttonRosulIbrahim: Button = findViewById(R.id.BtnNabi3)

        buttonRosulIbrahim.setOnClickListener {
            val intent = Intent(this, RosulIbrahimActivity::class.java)
            startActivity(intent)
        }

        val buttonRosulMusa: Button = findViewById(R.id.BtnNabi4)

        buttonRosulMusa.setOnClickListener {
            val intent = Intent(this, RosulMusaActivity::class.java)
            startActivity(intent)
        }

        val buttonRosulNuh: Button = findViewById(R.id.BtnNabi5)

        buttonRosulNuh.setOnClickListener {
            val intent = Intent(this, RosulNuhActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}