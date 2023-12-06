package com.example.notes.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNewNoteBinding
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.model.AppNote
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewNoteFragment : Fragment() {

    private lateinit var _binding: FragmentAddNewNoteBinding
    private val binding get() = _binding!!
    private val addNewNoteViewModel: AddNewNoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {

        binding.btnAddNote.setOnClickListener {
            val name = binding.edNameNote.text.toString()
            val text = binding.edTextNote.text.toString()

            if(name.isEmpty()){
                Toast.makeText(requireContext(),"Введите имя", Toast.LENGTH_SHORT).show()
            }
            else {
                    addNewNoteViewModel.insert(AppNote(name = name, text = text)){
                        findNavController().navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                    }
            }
        }
    }
}