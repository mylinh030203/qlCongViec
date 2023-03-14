package com.example.qlcongviec

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.qlcongviec.model.Talk
import com.example.qlcongviec.data.dataResource.listCV

class TaskDetailFragment : Fragment(R.layout.fragment_task_detail) {
    fun list(pos:Int):Talk{
        return listCV[pos]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_task_detail,container,false)
        var title : TextView = view.findViewById(R.id.title)
        var mota : TextView = view.findViewById(R.id.des)
        var date : TextView = view.findViewById(R.id.date)
        var state : TextView = view.findViewById(R.id.state)
        var btnupdate: Button = view.findViewById(R.id.btnupdate)
        var txtdes : EditText = view.findViewById(R.id.txtdes)
        var txtdate : EditText = view.findViewById(R.id.txtdate)
        var rg:RadioGroup = view.findViewById(R.id.radioGroup)
        var btndelete : Button = view.findViewById(R.id.delete)
        title.text = arguments?.getString("congviec","khoan 1 ")
        var i = arguments?.getInt("pos",0) as Int
        when(title.text){
            list(i).name-> {
                mota.text = list(i).des.toString()
                date.text = list(i).date.toString()
                state.text = list(i).state.toString()
                btnupdate.setOnClickListener {
                    if((txtdes.text).toString() !=""){
                        mota.text = (txtdes.text).toString()
                        txtdes.setText("")
                    }
                    if((txtdate.text).toString()!=""){
                        date.text = (txtdate.text).toString()
                        txtdate.setText("")
                    }

                    var selected : Int = rg.checkedRadioButtonId
                    var states : String = when (selected){
                        R.id.hoanthanh -> "Đã hoàn thành"
                        R.id.choanthanh -> "Chưa hoàn thành"
                        else -> state.toString()
                    }
                    if(selected != -1){
                        state.text = states
                    }

                }
                btndelete.setOnClickListener {
                    var intent : Intent = Intent(activity,MainActivity::class.java)
                    listCV.removeAt(i)
                    startActivity(intent)
                }
            }

        }
        return view
    }
}