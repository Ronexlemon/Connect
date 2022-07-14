package com.example.connect

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.connect.AppViewModel.AppViewModel
import com.example.connect.composeuis.HomeScreen
import com.example.connect.databinding.FragmentHomeBinding
import com.example.connect.model.MenAsset
import com.example.connect.model.Products
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
   private  lateinit var  binding:FragmentHomeBinding

   private val  viewModel: AppViewModel by viewModels()
    private  lateinit var  menlist :MutableList<Products>

    private lateinit var  drawerToggle: ActionBarDrawerToggle



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
        drawerToggle = ActionBarDrawerToggle(requireActivity(),binding.drawer,R.string.nav_open,R.string.nav_close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        binding.drawer.setBackgroundColor(Color.LTGRAY);
        binding.homecompose.setContent {
 val data by viewModel.state.collectAsState()

            HomeScreen(list =data)
            Log.i("Tags",data.toString())
        }
        return binding.root
    }



}