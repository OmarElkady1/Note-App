package com.example.note.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note.R
import com.example.note.data.Note

class ListAdapter(private val listNote:List<Note>,private val onClick: NoteOnClick) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val ide = itemView.findViewById<TextView>(R.id.text_id)
        val title = itemView.findViewById<TextView>(R.id.text_title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentList= listNote[position]
        holder.ide.text=currentList.id.toString()
        holder.title.text=currentList.title

        holder.itemView.setOnClickListener {
            onClick.clickListner(currentList)
        }

    }

    override fun getItemCount(): Int {
       return listNote.size
    }
}




























