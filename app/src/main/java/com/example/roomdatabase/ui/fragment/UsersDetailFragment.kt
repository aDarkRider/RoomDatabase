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
import com.example.roomdatabase.adapters.UserAdapter
import com.example.roomdatabase.databinding.FragmentUsersDetailBinding
import com.example.roomdatabase.model.view_models.fragments.UsersDetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersDetailFragment : Fragment() {

    private val mViewModel: UsersDetailFragmentViewModel by viewModels()

    private lateinit var mBinding: FragmentUsersDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentUsersDetailBinding.inflate(layoutInflater)

        val adapter = UserAdapter()

        mBinding.userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mBinding.userRecyclerView.adapter = adapter

        mViewModel.getUsers().observe(viewLifecycleOwner) {
            adapter.setUsers(it)
            Toast.makeText(requireContext(), it.size.toString(), Toast.LENGTH_SHORT).show()
        }

        mBinding.floatingUserBtn.setOnClickListener {
            findNavController().navigate(R.id.action_usersDetailFragment_to_addUserFragment)
        }

        return mBinding.root
    }

}