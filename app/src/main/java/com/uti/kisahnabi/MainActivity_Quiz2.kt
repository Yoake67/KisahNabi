package com.uti.kisahnabi // Ganti dengan nama package aplikasi Anda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menggunakan layout activity_main_quiz2.xml
        setContentView(R.layout.activity_main_quiz2)

        // 1. Ambil referensi komponen dari layout XML
        val radioGroupSoal2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val buttonSubmit2 = findViewById<Button>(R.id.submit2)

        // 2. ID dari RadioButton yang merupakan jawaban benar untuk soal nomor 2
        val idJawabanBenarSoal2 = R.id.opsiD_soal2_jawaban

        // 3. Atur aksi ketika tombol SUBMIT diklik
        buttonSubmit2.setOnClickListener {
            // Dapatkan ID dari RadioButton yang sedang dipilih oleh pengguna
            val idJawabanTerpilih = radioGroupSoal2.checkedRadioButtonId

            // 4. Periksa apakah pengguna sudah memilih jawaban atau belum
            if (idJawabanTerpilih == -1) {
                // Jika belum, tampilkan pesan peringatan
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika sudah, periksa kebenarannya
                if (idJawabanTerpilih == idJawabanBenarSoal2) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Lanjutkan ke halaman kuis berikutnya (soal 3)
                val intent = Intent(this, MainActivity_quiz3::class.java)
                startActivity(intent)

                // PERINTAH finish() DIHAPUS DARI SINI
                // Dengan menghapus finish(), activity ini tetap ada di 'tumpukan' (stack),
                // sehingga Anda bisa kembali ke halaman ini dari halaman berikutnya.
            }
        }
    }
}
