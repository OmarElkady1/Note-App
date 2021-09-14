package com.example.note.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.note.R
import com.example.note.adapter.ListAdapter
import com.example.note.adapter.NoteOnClick
import com.example.note.data.Note
import com.example.note.update.UpdateFragmentArgs
import com.example.note.viewModel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(),NoteOnClick {
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var noteRecyclerView:RecyclerView
    lateinit var noteList:List<Note>
    lateinit var noteViewModel :NoteViewModel
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view =inflater.inflate(R.layout.fragment_list, container, false)

        //recycler
        noteRecyclerView =view.findViewById(R.id.recyclerView)
        noteList =ArrayList<Note>()


        //viewModel

        noteViewModel= ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            note ->
            val adapter =ListAdapter(note,this)
            noteRecyclerView.adapter=adapter

        })

        floatingActionButton=view.findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
         return view


    }

    override fun clickListner(position: Note) {
        Toast.makeText(requireContext(),"Clicked ${position.id}",Toast.LENGTH_LONG).show()
        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(position)
        findNavController().navigate(action)

    }

}