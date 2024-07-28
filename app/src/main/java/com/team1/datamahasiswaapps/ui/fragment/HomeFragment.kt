package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.team1.datamahasiswaapps.R
import com.team1.datamahasiswaapps.common.KEY_BUNDLE_TO_DETAIL
import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.databinding.FragmentHomeBinding
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.ui.adapter.StudentRecyclerViewAdapter
import com.team1.datamahasiswaapps.ui.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModelHomeFragment: HomeFragmentViewModel by viewModel<HomeFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewShow()
        binding.addActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
        }
    }

    private fun recyclerviewShow() {
        val studentsRecyclerViewAdapter = StudentRecyclerViewAdapter(itemClicked = {onItemClicked(it)})

        viewModelHomeFragment.getAllStudentsData()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelHomeFragment.listStudentsData.collect { uiState ->
                    when (uiState) {
                        is ResourcesState.Loading -> {
                            binding.progressActionBar.visibility = View.VISIBLE
                        }

                        is ResourcesState.Success -> {
                            binding.progressActionBar.visibility = View.GONE
                            studentsRecyclerViewAdapter.submitList(uiState.data)
                        }

                        is ResourcesState.Error -> {
                            Snackbar.make(
                                requireContext(),
                                binding.root,
                                "${uiState.message}",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }

                        is ResourcesState.Idle -> {}
                    }
                }
            }
        }

        binding.rvListLeagueGroup.setHasFixedSize(true)
        binding.rvListLeagueGroup.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvListLeagueGroup.adapter = studentsRecyclerViewAdapter
        binding.rvListLeagueGroup.itemAnimator = null
    }

    private fun onItemClicked(data:Students){
        val bundle = bundleOf(KEY_BUNDLE_TO_DETAIL to data.id)
        findNavController().navigate(R.id.action_homeFragment_to_detailItemFragment,bundle)

    }

    override fun onResume() {
        super.onResume()
        viewModelHomeFragment.getAllStudentsData()
    }
}