package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.team1.datamahasiswaapps.R
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

        //belum nyalain expection kalo data kosong
        //validasi sambil berjalan aja

        binding.btnSubmit.setOnClickListener {
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
                Snackbar.make(requireContext(),binding.root,"data berhasil ditambahkan",Snackbar.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }
}