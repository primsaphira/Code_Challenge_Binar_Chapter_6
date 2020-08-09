package com.binar.myproject.codechallengebinar_chapter5

interface FragmentListener {

    fun openFirstFragment()
    fun openSecondFragment()
    fun openThirdFragment()

    fun goToMenuActivity(namaUser:String)

    fun passNamaUser(namaUser: String)

    fun namaPemain(namaUser: String)
}