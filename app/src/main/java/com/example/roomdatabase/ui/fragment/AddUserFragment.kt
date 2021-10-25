package com.example.roomdatabase.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentAddUserBinding
import com.example.roomdatabase.model.view_models.fragments.AddUserFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment() {

    private val mViewModel: AddUserFragmentViewModel by viewModels()
    private lateinit var mBinding: FragmentAddUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAddUserBinding.inflate(layoutInflater)

        mViewModel.insertState.observe(viewLifecycleOwner) {
            if (it == AddUserFragmentViewModel.InsertState.INSERTING) {
                mBinding.addUserBtn.isEnabled = false
            }
            if (it == AddUserFragmentViewModel.InsertState.INSERTED) {
                findNavController().popBackStack(R.id.usersDetailFragment, false)
            }
        }

        mBinding.addUserBtn.setOnClickListener {
            val name = mBinding.edUserName.text.toString()
            val phone = mBinding.edUserPhone.text.toString()
            val password = mBinding.edUserPassword.text.toString()

            when {
                name.isEmpty() ->  {
                    mBinding.edUserName.error = "Please Enter UserName"
                    mBinding.edUserName.requestFocus()
                }
                phone.isEmpty() ->  {
                    mBinding.edUserPhone.error = "Please Enter Phone"
                    mBinding.edUserPhone.requestFocus()
                }
                password.isEmpty() ->  {
                    mBinding.edUserPassword.error = "Please Enter Password"
                    mBinding.edUserPassword.requestFocus()
                }
                else -> {
                    mViewModel.insertUser(name, phone, password)
                }
            }
        }

        return mBinding.root
    }

}