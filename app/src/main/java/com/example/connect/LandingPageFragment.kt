package com.example.connect

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.navigation.findNavController


import com.example.connect.composeuis.LandingPage
import com.example.connect.databinding.FragmentLandingPageBinding


class LandingPageFragment : Fragment() {
    private lateinit var binding: FragmentLandingPageBinding
    private lateinit var  handler: Handler


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_landing_page,container,false)
        (requireActivity() as AppCompatActivity).supportActionBar!!.hide()
        binding.compose.setContent {
LandingPage()
        }

 navi()
        return binding.root
    }


    private fun navi() {

        Handler(Looper.getMainLooper()).postDelayed({

requireView().findNavController().navigate(R.id.action_landingPageFragment_to_homeFragment)


        }, 2000)
    }

}