package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Cari tombol QUIZ berdasarkan ID yang sudah dibuat di XML
        val btnQuiz = findViewById<ImageView>(R.id.imageView2_quiz)

        // 2. Beri aksi ketika tombol tersebut diklik
        btnQuiz.setOnClickListener {
            // 3. Buat "niat" (Intent) untuk pindah dari halaman ini (MainActivity)
            //    ke halaman tujuan (MainActivity_Quiz)
            val intent = Intent(this, MainActivity_Quiz::class.java)

            // 4. Jalankan niat tersebut untuk pindah halaman
            startActivity(intent)
            }

//KISAH NABI ---

            // 1. Temukan ImageView "Kisah Nabi" berdasarkan ID-nya
            val btnKisahNabi = findViewById<ImageView>(R.id.btn_kisah_nabi)

            // 2. Beri aksi ketika tombol tersebut diklik
            btnKisahNabi.setOnClickListener {
                // 3. Buat Intent untuk pindah ke halaman KisahNabi
                //    Pastikan nama kelasnya benar (KisahNabi, bukan activity_kisah_nabi)
                val intent = Intent(this, KisahNabi::class.java)

                // 4. Jalankan perpindahan halaman
                startActivity(intent)
            }
        }
    }
