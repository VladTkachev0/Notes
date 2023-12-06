package com.example.notes.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.screens.APP_ACTIVITY
import com.example.notes.screens.TYPE_ROOM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding!!
    private val adapter = MainAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.initDatabase() {
            binding.btnAdd.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_addNewNoteFragment)
            }

            binding.rcView.adapter = adapter
            mainViewModel.getAllNotes().observe(viewLifecycleOwner) {
                val list = it.asReversed()
                adapter.setList(list)
                Log.d("MainFragment", "Notes list: $list")
            }
        }
    }


}