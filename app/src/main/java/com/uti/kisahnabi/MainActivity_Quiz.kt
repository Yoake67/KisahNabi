package com.uti.kisahnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Ambil referensi komponen dari layout XML
        val radioGroupSoal1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val buttonSubmit1 = findViewById<Button>(R.id.submit1)

        // ID dari RadioButton yang merupakan jawaban benar
        val idJawabanBenar = R.id.Nabi_Ibrahim1

        // 2. Atur aksi ketika tombol SUBMIT diklik
        buttonSubmit1.setOnClickListener {
            // Dapatkan ID dari RadioButton yang sedang dipilih oleh pengguna
            val idJawabanTerpilih = radioGroupSoal1.checkedRadioButtonId

            // 3. Periksa apakah pengguna sudah memilih jawaban atau belum
            if (idJawabanTerpilih == -1) {
                // Jika belum ada yang dipilih, tampilkan pesan peringatan
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // --- LOGIKA SKOR DIMULAI DI SINI ---

                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenar) 10 else 0

                // Pindah ke halaman kuis berikutnya, sambil membawa skor
                val intent = Intent(this, MainActivity_Quiz2::class.java)
                intent.putExtra("SKOR_SEMENTARA", skorSoalIni)
                startActivity(intent)
            }
        }
    }
}