package com.example.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.databinding.NoteItemBinding
import com.example.notes.model.AppNote

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var listNotes = emptyList<AppNote>()
    class MainHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = NoteItemBinding.bind(item)

        fun bind(appNote: AppNote) = with(binding) {
            itemNoteName.text = appNote.name
            itemNoteText.text = appNote.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int = listNotes.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(listNotes[position])

        holder.itemView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToNoteFragment(
                listNotes[position].name,
                listNotes[position].text,
                listNotes[position].id
            )
            it.findNavController().navigate(action)

        }
    }

    fun setList(list: List<AppNote>){
        listNotes = list
        notifyDataSetChanged()
    }
}