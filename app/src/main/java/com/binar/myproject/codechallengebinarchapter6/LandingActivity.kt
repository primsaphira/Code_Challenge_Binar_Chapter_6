package com.binar.myproject.codechallengebinar_chapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_third.*

class LandingActivity : AppCompatActivity(), FragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        openFirstFragment()
    }

    fun commitFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }


    override fun openFirstFragment() {
        val objectFirstFragment = FirstFragment()
        objectFirstFragment.setListener(this)
        commitFragment(objectFirstFragment)
    }

    override fun openSecondFragment() {
        val objectSecondFragment = SecondFragment()
        objectSecondFragment.setListener(this)
        commitFragment(objectSecondFragment)
    }

    override fun openThirdFragment() {
        val objectThirdFragment = ThirdFragment()
        objectThirdFragment.setListener(this)
        commitFragment(objectThirdFragment)
    }

    override fun goToMenuActivity(nama: String) {
        val intentKeMenuActivity = Intent(this, MenuActivity::class.java)
        intentKeMenuActivity.putExtra("nama", etUser.text.toString())
        startActivity(intentKeMenuActivity)
    }

    override fun passNamaUser(nama: String) {
        val intentKeGameComputerActivity = Intent(this, GameComputerActivity::class.java)
        intentKeGameComputerActivity.putExtra("nama", etUser.text.toString())
        startActivity(intentKeGameComputerActivity)
    }

    override fun namaPemain(nama: String) {
        val intentKeGamePlayerActivity = Intent(this, GamePlayerActivity::class.java)
        intentKeGamePlayerActivity.putExtra("nama", etUser.text.toString())
        startActivity(intentKeGamePlayerActivity)
    }
}