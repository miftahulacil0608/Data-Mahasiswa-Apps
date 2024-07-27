package com.team1.datamahasiswaapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.team1.datamahasiswaapps.R
import com.team1.datamahasiswaapps.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeBinding.inflate(inflater,container,false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
        }
    }

}