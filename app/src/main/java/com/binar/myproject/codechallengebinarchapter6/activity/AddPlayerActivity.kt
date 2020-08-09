package com.binar.myproject.codechallengebinar_chapter5.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddPlayerActivity : AppCompatActivity() {

    var mDb: PlayerDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)

        mDb = PlayerDatabase.getInstance(this)

        btnSave.setOnClickListener {
            val objectPlayer = Player(
                null,
                etNamaPlayer.text.toString(),
                etEmailPlayer.text.toString()
            )

            GlobalScope.async {
                val result = mDb?.playerDao()?.insertPlayer(objectPlayer)
                runOnUiThread {
                    if(result != 0.toLong() ){
                        //sukses
                        Toast.makeText(this@AddPlayerActivity,"Sukses menambahkan ${objectPlayer.nama}",
                            Toast.LENGTH_LONG).show()
                    }else{
                        //gagal
                        Toast.makeText(this@AddPlayerActivity,"Gagal menambahkan ${objectPlayer.nama}",
                            Toast.LENGTH_LONG).show()
                    }
                    finish()
                }
            }
        }
    }
}