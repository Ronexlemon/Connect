package com.example.connect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connect.composeuis.HomeScreen
import com.example.connect.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
   private  lateinit var  binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity() as AppCompatActivity).supportActionBar!!.hide()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.bottomNav.setOnItemReselectedListener { view->
            when(view.itemId){
                R.id.all ->{
                    Toast.makeText(requireActivity(),"all",Toast.LENGTH_SHORT).show()
                }
                R.id.menwear ->{
                    Toast.makeText(requireActivity(),"menwear",Toast.LENGTH_SHORT).show()
                }
                R.id.womenwear ->{
                    Toast.makeText(requireActivity(),"Womenwear",Toast.LENGTH_SHORT).show()
                }
                R.id.chiildren ->{
                    Toast.makeText(requireActivity(),"childwear",Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.homecompose.setContent {
HomeScreen()
        }
        return binding.root
    }



}