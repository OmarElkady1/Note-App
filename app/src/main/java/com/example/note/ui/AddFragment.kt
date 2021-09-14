package com.example.note.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.note.R
import com.example.note.data.Note
import com.example.note.viewModel.NoteViewModel

class AddFragment : Fragment() {
    lateinit var viewModel1: NoteViewModel
    lateinit var addButton: Button
    lateinit var titleText: EditText
    lateinit var discrepText: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        viewModel1 = ViewModelProvider(this).get(NoteViewModel::class.java)
        addButton = view.findViewById(R.id.button)
        titleText = view.findViewById(R.id.title)
        discrepText = view.findViewById(R.id.note)

        addButton.setOnClickListener {
            addNoteToDataBAse()
        }
        return view
    }

    private fun addNoteToDataBAse() {
        val title = titleText.text.toString()
        val discreaption = discrepText.text.toString()
        if (inputCheck(title, discreaption)) {
            val note = Note(0, title, discreaption)
            viewModel1.addNote(note)
            Toast.makeText(requireContext(), " adding sucessfully", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(requireContext(), " erorrrrrrrrrrr", Toast.LENGTH_SHORT).show()

        }

    }

    private fun inputCheck(title: String, discreaption: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(discreaption))


    }


}