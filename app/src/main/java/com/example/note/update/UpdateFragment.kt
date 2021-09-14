package com.example.note.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.note.R
import com.example.note.data.Note
import com.example.note.viewModel.NoteViewModel

class UpdateFragment : Fragment() {
    lateinit var updateButton: Button
    lateinit var updatetitleText: EditText
    lateinit var updatediscrepText: EditText
    lateinit var noteViewModel: NoteViewModel
    private val arges by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)
        updateButton = view.findViewById(R.id.update)
        updatetitleText = view.findViewById(R.id.update_title)
        updatediscrepText = view.findViewById(R.id.update_note)
        updatetitleText.setText(arges.customeObject.title)
        updatediscrepText.setText(arges.customeObject.description)
        noteViewModel =ViewModelProvider(this).get(NoteViewModel::class.java)
        updateButton.setOnClickListener {
            updatenoteToDataBAse()
        }
        return view
    }

    private fun updatenoteToDataBAse() {
        val title = updatetitleText.text.toString()
        val discreaption = updatediscrepText.text.toString()
        if (inputCheck(title, discreaption)) {
                 val note = Note(arges.customeObject.id,title,discreaption)
                  noteViewModel.updateNote(note)
            Toast.makeText(requireContext(), " adding sucessfully", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(requireContext(), " erorrrrrrrrrrr", Toast.LENGTH_SHORT).show()

        }

    }

    private fun inputCheck(title: String, discreaption: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(discreaption))


    }


}