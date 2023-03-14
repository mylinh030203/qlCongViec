package com.example.qlcongviec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qlcongviec.model.Talk
import kotlinx.android.synthetic.main.layout_item.view.*

class rvAdapter(val list: List<Talk>, val rvInterface: rvInterface): RecyclerView.Adapter<rvAdapter.congViecHolder>() {
    inner class congViecHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): congViecHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent,false)
        return congViecHolder(view)
    }

    override fun onBindViewHolder(holder: congViecHolder, position: Int) {
        holder.itemView.apply {
            tvCongviec.text = list[position].name

            holder.itemView.setOnClickListener {
                rvInterface.onclick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}