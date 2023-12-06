package com.example.notes.screens.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notes.R
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.databinding.FragmentNoteBinding
import com.example.notes.model.AppNote
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.Normalizer

class NoteFragment : Fragment() {

    private lateinit var _binding: FragmentNoteBinding
    private val binding get() = _binding!!
    private val args: NoteFragmentArgs by navArgs()
    private val noteVewModel: NoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            noteName.text = "${args.name}"
            noteText.text = "${args.text}"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnDelete -> {
                deleteNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote() {
        val noteToDelete = AppNote(
            id = args.id,
            name = args.name,
            text = args.text
        )

        noteVewModel.delete(noteToDelete){
            findNavController().popBackStack()
            Toast.makeText(requireContext(), "Запись удалена", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }
}