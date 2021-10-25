package com.example.roomdatabase.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.R
import com.example.roomdatabase.adapters.AdminAdapter
import com.example.roomdatabase.databinding.FragmentAdminDetailBinding
import com.example.roomdatabase.model.view_models.fragments.AdminsDetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminDetailFragment : Fragment() {

    private val mViewModel: AdminsDetailFragmentViewModel by viewModels()

    private lateinit var mBinding: FragmentAdminDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAdminDetailBinding.inflate(layoutInflater)

        val adapter = AdminAdapter()

        mBinding.adminRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mBinding.adminRecyclerView.adapter = adapter

        mViewModel.getAdmins().observe(viewLifecycleOwner) {
            adapter.setAdmins(it)
            Toast.makeText(requireContext(), it.size.toString(), Toast.LENGTH_SHORT).show()
        }

        mBinding.floatingAdminBtn.setOnClickListener {
            findNavController().navigate(R.id.action_adminDetailFragment_to_addAdminFragment)
        }
        return mBinding.root
    }

}