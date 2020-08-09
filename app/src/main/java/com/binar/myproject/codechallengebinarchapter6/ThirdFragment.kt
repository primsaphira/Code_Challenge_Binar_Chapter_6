package com.binar.myproject.codechallengebinar_chapter5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {
    private lateinit var listener: FragmentListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivButtonLanjut.setOnClickListener {
            listener.goToMenuActivity(etUser.text.toString())
        }
    }
    fun setListener(fragmentListener: FragmentListener) {
        this.listener = fragmentListener
    }
}