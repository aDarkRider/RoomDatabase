package com.example.roomdatabase.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentAddAdminBinding
import com.example.roomdatabase.model.view_models.fragments.AddAdminFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAdminFragment : Fragment() {

    private val mViewModel: AddAdminFragmentViewModel by viewModels()
    private lateinit var mBinding: FragmentAddAdminBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAddAdminBinding.inflate(layoutInflater)

        mViewModel.insertState.observe(viewLifecycleOwner) {
            if (it == AddAdminFragmentViewModel.InsertState.INSERTING) {
                mBinding.addAdminBtn.isEnabled = false
            }
            if (it == AddAdminFragmentViewModel.InsertState.INSERTED) {
                findNavController().popBackStack(R.id.adminDetailFragment, false)
            }
        }

        mBinding.addAdminBtn.setOnClickListener {
            val name = mBinding.edAdminName.text.toString()
            val phone = mBinding.edAdminPhone.text.toString()
            val password = mBinding.edAdminPassword.text.toString()

            when {
                name.isEmpty() -> {
                    mBinding.edAdminName.error = "Please Enter Admin Name"
                    mBinding.edAdminName.requestFocus()
                }
                phone.isEmpty() -> {
                    mBinding.edAdminPhone.error = "Please Enter Admin Phone"
                    mBinding.edAdminPhone.requestFocus()
                }
                password.isEmpty() -> {
                    mBinding.edAdminPassword.error = "Please Enter Admin Password"
                    mBinding.edAdminPassword.requestFocus()
                }
                else -> {
                    mViewModel.insertAdmin(name, phone, password)
                }
            }
        }

        return mBinding.root
    }

}