package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.team1.datamahasiswaapps.R
import com.team1.datamahasiswaapps.common.utils.Validator
import com.team1.datamahasiswaapps.databinding.FragmentAddItemBinding
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.ui.viewmodel.AddItemFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddItemFragment : Fragment() {
    private lateinit var binding: FragmentAddItemBinding
    private val viewModelAddFragment: AddItemFragmentViewModel by viewModel<AddItemFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAddItemBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            if (validateInput()) {
                val username = binding.usernameInputText.text.toString()
                val nim = binding.nimInputText.text.toString().toLong()
                val faculty = binding.facultyInputText.text.toString()
                val major = binding.majorInputText.text.toString()
                val address = binding.addressInputText.text.toString()
                val dataStudentsInput = Students(
                    username = username,
                    nim = nim,
                    faculty = faculty,
                    major = major,
                    address = address
                )
                viewModelAddFragment.addStudentsData(dataStudentsInput).also {
                    Snackbar.make(
                        requireContext(),
                        binding.root,
                        "data berhasil ditambahkan",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    findNavController().navigateUp()
                }
            }
        }
    }


    private fun validateInput(): Boolean {
        var isValid = true

        val username = binding.usernameInputText.text.toString()
        val nim = binding.nimInputText.text.toString()
        val faculty = binding.facultyInputText.text.toString()
        val major = binding.majorInputText.text.toString()
        val address = binding.addressInputText.text.toString()


        if (!Validator.isNotEmpty(username) || !Validator.isNameValid(username)) {
            binding.usernameInputText.error = "Nama harus minimal 3 huruf"
            isValid = false
        } else {
            binding.usernameInputText.error = null
        }

        if (!Validator.isNotEmpty(nim) || !Validator.isNimValid(nim)) {
            binding.nimInputText.error = "NIM harus terdiri dari 12 angka"
            isValid = false
        } else {
            binding.nimInputText.error = null
        }

        if (!Validator.isNotEmpty(faculty) || !Validator.isFacultyValid(faculty)) {
            binding.facultyInputText.error = "Fakultas harus minimal 3 huruf"
            isValid = false
        } else {
            binding.facultyInputText.error = null
        }

        if (!Validator.isNotEmpty(major) || !Validator.isMajorValid(major)) {
            binding.majorInputText.error = "Jurusan harus minimal 3 huruf"
            isValid = false
        } else {
            binding.majorInputText.error = null
        }

        if (!Validator.isNotEmpty(address) || !Validator.isAddressValid(address)) {
            binding.addressInputText.error = "Alamat harus minimal 20 huruf"
            isValid = false
        } else {
            binding.addressInputText.error = null
        }

        return isValid
    }
}