package com.example.qlcongviec

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qlcongviec.model.Talk
import com.example.qlcongviec.data.dataResource.listCV

class TaskListFragment : Fragment(R.layout.fragment_task_list) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_task_list, container, false)
        var recyclerView: RecyclerView = view.findViewById(R.id.rvCongViec)
        var btnadd: Button = view.findViewById(R.id.add)
        var list = mutableListOf<Talk>()
        listCV.forEach {
            list.add(it)
        }
        var adapter = rvAdapter(list, object : rvInterface {
            override fun onclick(pos: Int) {
                var intent: Intent = Intent(activity, DetailActivity::class.java)

                intent.putExtra("congviec", list[pos].name)
                intent.putExtra("stt", pos)
                startActivity(intent)

            }
        })
        btnadd.setOnClickListener {
            var intent2 = Intent(activity, AddTaskActivity::class.java)
            startActivity(intent2)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return view

    }

}