package com.binar.myproject.codechallengebinar_chapter5.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.myproject.codechallengebinar_chapter5.MenuActivity
import com.binar.myproject.codechallengebinar_chapter5.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogin.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
            val usernamePlayer = sharedPreferences.getString("username", "No username")
            val passwordPlayer = sharedPreferences.getString("password", "No password")

            if (etUsername.text.toString() == usernamePlayer && etPassword.text.toString() == passwordPlayer) {

                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                //gagal login
                Toast.makeText(this, "Username / Password Salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}
