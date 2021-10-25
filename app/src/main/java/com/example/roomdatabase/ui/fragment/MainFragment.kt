package com.example.roomdatabase.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var mBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater)

        mBinding.btnUser.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_usersDetailFragment)
        }

        mBinding.btnAdmin.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_adminDetailFragment)
        }

        return mBinding.root
    }

}