package com.example.qlcongviec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var i = intent
        var bundle = Bundle()
        var title = i.getStringExtra("congviec")
        var pos = i.getIntExtra("stt",0)
        bundle.putString("congviec",title)
        bundle.putInt("pos",pos)
        val sub2 = TaskDetailFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayoutdetail,sub2)
            commit()
        }
        sub2.arguments = bundle
    }
}