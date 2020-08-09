package com.binar.myproject.codechallengebinar_chapter5.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditPlayerActivity : AppCompatActivity() {
    var mDb: PlayerDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_player)

        mDb = PlayerDatabase.getInstance(this)

        val objectStudent = intent.getParcelableExtra<Player>("student")

        etNamaPlayer.setText(objectPlayer.nama)
        etEmailPlayer.setText(objectPlayer.email)

        btnSave.setOnClickListener {
            objectPlayer.nama = etNamaPlayer.text.toString()
            objectPlayer.email = etEmailPlayer.text.toString()

            GlobalScope.async {
                val result = mDb?.playerDao()?.updatePlayer(objectPlayer)

                runOnUiThread {
                    if(result!=0){
                        Toast.makeText(this@EditPlayerActivity,"Sukses mengubah ${objectPlayer.nama}", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@EditPlayerActivity,"Gagal mengubah ${objectPlayer.nama}", Toast.LENGTH_LONG).show()
                    }

                    finish()
                }
            }
        }
    }
}