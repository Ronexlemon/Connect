package com.example.connect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.connect.AppViewModel.AppViewModel
import com.example.connect.composeuis.HomeScreen
import com.example.connect.databinding.FragmentHomeBinding
import com.example.connect.model.MenAsset
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
   private  lateinit var  binding:FragmentHomeBinding

   private val  viewModel: AppViewModel by viewModels()
    private  lateinit var  menlist :MutableList<MenAsset>

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
            viewModel.response.observe(viewLifecycleOwner, Observer {
              menlist = it.results
            })
            HomeScreen(list = menlist)

        }
        return binding.root
    }



}