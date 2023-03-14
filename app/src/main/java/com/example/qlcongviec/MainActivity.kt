package com.example.qlcongviec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sub1 = TaskListFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayoutlist,sub1)
            commit()
        }
    }
}