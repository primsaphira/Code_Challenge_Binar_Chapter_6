package com.binar.myproject.codechallengebinar_chapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_computer.*
import kotlinx.android.synthetic.main.activity_game_player.*
import kotlinx.android.synthetic.main.activity_game_player.batu1
import kotlinx.android.synthetic.main.activity_game_player.batu2
import kotlinx.android.synthetic.main.activity_game_player.gunting1
import kotlinx.android.synthetic.main.activity_game_player.gunting2
import kotlinx.android.synthetic.main.activity_game_player.imageClose
import kotlinx.android.synthetic.main.activity_game_player.imageRepeat
import kotlinx.android.synthetic.main.activity_game_player.kertas1
import kotlinx.android.synthetic.main.activity_game_player.kertas2
import kotlinx.android.synthetic.main.activity_game_player.tvKeteranganPlayerSatu
import kotlinx.android.synthetic.main.activity_game_player.tvPemainMenang

class GamePlayerActivity : AppCompatActivity() {
    var pilihanPemain1: String = ""
    var pilihanPemain2 = ""
    val gameService = GameService()
    var indexPemain1: Int = -1
    var indexPemain2 = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_player)

        //menerima data nama dari intent di kelas third fragment

        val namaUserBermain = intent.getStringExtra("nama")

        //set ke textView di xml layout GameActivity

        tvKeteranganPlayerSatu.text = namaUserBermain


        imageClose.setOnClickListener {

            finish()

        }
        imageRepeat.setOnClickListener {
            batu1.foreground = null
            kertas1.foreground = null
            gunting1.foreground = null
            batu2.foreground = null
            kertas2.foreground = null
            gunting2.foreground = null

            pilihanPemain1 = ""
            pilihanPemain2 = ""
            indexPemain1 = -1
            indexPemain2 = -1
            tvPemainMenang.text = "Klik pilihan anda"
        }
        batu1.setOnClickListener {
            optionErasePlayer1()
            batu1.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain1 = 0
            pilihanPemain1 = gameService.gameSuit[indexPemain1]
            runGame()
        }
        kertas1.setOnClickListener {
            optionErasePlayer1()
            kertas1.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain1 = 2
            pilihanPemain1 = gameService.gameSuit[indexPemain1]
            runGame()
        }
        gunting1.setOnClickListener {
            optionErasePlayer1()
            gunting1.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain1 = 1
            pilihanPemain1 = gameService.gameSuit[indexPemain1]
            runGame()
        }
        batu2.setOnClickListener {
            optionErasePlayer2()
            batu2.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain2 = 0
            pilihanPemain2 = gameService.gameSuit[indexPemain2]
            runGame()
        }
        kertas2.setOnClickListener {
            optionErasePlayer2()
            kertas2.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain2 = 2
            pilihanPemain2 = gameService.gameSuit[indexPemain2]
            runGame()
        }
        gunting2.setOnClickListener {
            optionErasePlayer2()
            gunting2.foreground = resources.getDrawable(R.drawable.background_selection, null)
            indexPemain2 = 1
            pilihanPemain2 = gameService.gameSuit[indexPemain2]
            runGame()
        }
    }

    fun runGame() {
        if (pilihanPemain1 != "" && pilihanPemain2 != "") {
            val hasil = gameService.calculateWinner(indexPemain1, indexPemain2).resultValue
            tvPemainMenang.text = hasil
        } else {
            tvPemainMenang.text = "Klik kedua pilihan anda pada gambar"
        }
    }

    fun optionErasePlayer1() {
        batu1.foreground = null
        kertas1.foreground = null
        gunting1.foreground = null

    }

    fun optionErasePlayer2() {
        batu2.foreground = null
        kertas2.foreground = null
        gunting2.foreground = null
    }

}
