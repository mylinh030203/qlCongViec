package com.example.qlcongviec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qlcongviec.data.dataResource.listCV
import com.example.qlcongviec.model.Talk
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        var name = txtnameadd.text.toString()
        var des = txtdesadd.text.toString()
        var date = txtdateadd.text.toString()

        btnadd.setOnClickListener {
            var selected : Int = radioGroupadd.checkedRadioButtonId
            var states : String = when (selected){
                R.id.hoanthanh -> "Đã hoàn thành"
                R.id.choanthanh -> "Chưa hoàn thành"
                else -> "Chưa hoàn thành"
            }
            listCV.add(Talk(name,des,date,states))
            var inten = Intent(this, MainActivity::class.java)
            startActivity(inten)
        }

    }
}