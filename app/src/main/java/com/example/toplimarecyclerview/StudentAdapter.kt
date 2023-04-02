package com.example.toplimarecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(var listStudent:ArrayList<ListStudent>): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
        var onClick : ((ListStudent) -> Unit)? = null
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var nama = view.findViewById<TextView>(R.id.txtNama)
        var umur = view.findViewById<TextView>(R.id.txtUmur)
        var nim = view.findViewById<TextView>(R.id.txtNim)
        var img = view.findViewById<ImageView>(R.id.img)
        var card = view.findViewById<CardView>(R.id.cardList)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.nama.text = listStudent[position].nama
        holder.umur.text = listStudent[position].umur.toString()
        holder.nim.text = listStudent[position].nim.toString()
        holder.img.setImageResource(listStudent[position].image)
        holder.card.setOnClickListener{
            onClick?.invoke(listStudent[position])
        }


    }

    override fun getItemCount(): Int {
       return listStudent.size
    }








}