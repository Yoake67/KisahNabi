package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Hasil_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Pastikan Anda memiliki layout bernama 'activity_main_hasil_quiz'
        setContentView(R.layout.activity_main_hasil_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Hubungkan view dari layout
        // Pastikan ID ini ada di file XML Anda
        val tvSkorAkhir = findViewById<TextView>(R.id.tv_skor_akhir)
        val tvJawabanBenar = findViewById<TextView>(R.id.tv_jawaban_benar)
        val tvJawabanSalah = findViewById<TextView>(R.id.tv_jawaban_salah)
        val btnSelesai = findViewById<Button>(R.id.btn_selesai)

        // Ambil skor final yang dikirim dari MainActivity_Quiz10
        val skorAkhir = intent.getIntExtra("SKOR_AKHIR", 0)

        // Hitung jumlah jawaban benar dan salah (20 poin per soal benar)
        val jumlahSoal = 10
        val jawabanBenar = skorAkhir / 20
        val jawabanSalah = jumlahSoal - jawabanBenar

        // Tampilkan semua data ke komponen TextView
        tvSkorAkhir.text = skorAkhir.toString()
        tvJawabanBenar.text = "Benar: $jawabanBenar"
        tvJawabanSalah.text = "Salah: $jawabanSalah"

        // Beri aksi pada tombol "Selesai" untuk kembali ke menu utama
        btnSelesai.setOnClickListener {
            // Ganti MainActivity::class.java dengan activity menu utama Anda jika namanya berbeda
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}