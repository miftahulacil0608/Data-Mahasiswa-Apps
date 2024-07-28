package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.team1.datamahasiswaapps.R
import com.team1.datamahasiswaapps.common.KEY_BUNDLE_TO_DETAIL
import com.team1.datamahasiswaapps.common.KEY_BUNDLE_TO_EDIT
import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.databinding.FragmentDetailItemBinding
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.ui.viewmodel.DetailFragmentViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailItemFragment : Fragment() {

    private lateinit var binding: FragmentDetailItemBinding
    private var id: Int? = null
    private val viewModelDetailItemFragment: DetailFragmentViewModel by viewModel<DetailFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentDetailItemBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = arguments?.getInt(KEY_BUNDLE_TO_DETAIL)
        viewModelDetailItemFragment.getStudentsDataDetail(id!!)
        studentsDataDetail()

        Log.d("detailfragment", "onViewCreated: $id")
    }

    private fun studentsDataDetail() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelDetailItemFragment.studentsData.collect {
                    when (it) {
                        is ResourcesState.Loading -> {
                            binding.progressbarDetailDataStudent.visibility = View.VISIBLE
                        }

                        is ResourcesState.Success -> {
                            binding.progressbarDetailDataStudent.visibility = View.GONE
                            showDataBinding(it.data)

                        }

                        is ResourcesState.Error -> {
                            Snackbar.make(
                                requireContext(),
                                binding.root,
                                "ga ada data",
                                Snackbar.LENGTH_SHORT
                            )
                                .show()

                            Log.d("Detail Item Fragment", "studentsDataDetail: ${it.message}")
                        }

                        is ResourcesState.Idle -> {}

                    }
                }
            }
        }
    }

    private fun showDataBinding(data: Students) {
        binding.textviewUsername.text = data.username
        binding.textviewNim.text = data.nim.toString()
        binding.textviewFaculty.text = data.faculty
        binding.textviewMajor.text = data.major
        binding.textviewAddress.text = data.address
        buttonEditClicked(data)
        buttonDeletedClicked(data)
    }

    private fun buttonEditClicked(data: Students) {
        val bundle = bundleOf(KEY_BUNDLE_TO_EDIT to data)
        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_detailItemFragment_to_editItemFragment, bundle)
        }
    }

    private fun buttonDeletedClicked(students: Students) {
        binding.btnDelete.setOnClickListener {
            viewModelDetailItemFragment.deletedStudentsData(students).also {
                Snackbar.make(requireContext(),binding.root,"Data Berhasil Dihapus",Snackbar.LENGTH_SHORT).show()
                findNavController().navigateUp()

            }
        }
    }
}