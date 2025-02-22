package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.team1.datamahasiswaapps.R
import com.team1.datamahasiswaapps.common.KEY_BUNDLE_TO_EDIT
import com.team1.datamahasiswaapps.common.utils.Validator
import com.team1.datamahasiswaapps.databinding.FragmentEditItemBinding
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.ui.viewmodel.EditFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditItemFragment : Fragment() {
    private lateinit var binding: FragmentEditItemBinding
    private val viewModelEditItemFragment: EditFragmentViewModel by viewModel<EditFragmentViewModel>()
    private var bundleResult: Students? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentEditItemBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bundleResult = arguments?.getParcelable(KEY_BUNDLE_TO_EDIT)

        bundleResult?.let {
            showItemBinding(it)
            Log.d("EditFragment", "onViewCreated: ${it}")
            updateButtonClicked(it.id!!)
        }

    }

    private fun showItemBinding(data: Students) {
        binding.usernameInputTextEditFragment.setText(data.username)
        binding.nimInputTextEditFragment.setText(data.nim.toString())
        binding.facultyInputTextEditFragment.setText(data.faculty)
        binding.majorInputTextEditFragment.setText(data.major)
        binding.addressInputTextEditFragment.setText(data.address)


    }

    private fun updateButtonClicked(id: Int) {
        binding.btnSubmitEditFragment.setOnClickListener {
            if (validateInput()) {
                val username = binding.usernameInputTextEditFragment.text.toString()
                val address = binding.addressInputTextEditFragment.text.toString()

                viewModelEditItemFragment.updateStudentsData(
                    newUsername = username,
                    newAddress = address,
                    id = id
                ).also {
                    Log.d("EditFragment", "updateButtonClicked: $username")
                    Snackbar.make(requireContext(),binding.root,"Data Berhasil Diperbarui", Snackbar.LENGTH_SHORT).show()

                    findNavController().popBackStack(R.id.homeFragment, false)
                }
            }
        }
    }

    private fun validateInput(): Boolean {
        var isValid = true

        val username = binding.usernameInputTextEditFragment.text.toString()
        val address = binding.addressInputTextEditFragment.text.toString()


        if (!Validator.isNotEmpty(username) || !Validator.isNameValid(username)) {
            binding.usernameInputTextEditFragment.error = "Nama harus minimal 3 huruf"
            isValid = false
        } else {
            binding.usernameInputTextEditFragment.error = null
        }

        if (!Validator.isNotEmpty(address) || !Validator.isAddressValid(address)) {
            binding.addressInputTextEditFragment.error = "Alamat harus minimal 20 huruf"
            isValid = false
        } else {
            binding.addressInputTextEditFragment.error = null
        }

        return isValid
    }
}