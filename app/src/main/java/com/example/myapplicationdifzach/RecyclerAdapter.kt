package com.example.myapplicationdifzach

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(
    private var list: List<String>,
):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //Создает View и кладет его во ViewHolder
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // Обновлдяет свое содержимое для элемента, который оказался на экране
        holder.textView.text = list[position]
    }


    override fun getItemCount(): Int = list.size // Общее число элементов

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) { //  Класс для доступа к элеменету списка
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}