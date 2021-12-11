package com.myfittinglife.recyclerviewselectdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


/**
@Author LD
@Time 2020/11/17 9:23
@Describe RecyclerView的单选多选实现
@Modify
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //单选(必选一个)
        btnSingleSelect.setOnClickListener {
            startActivity(Intent(this,SingleSelectActivity::class.java))
        }
        //单选(可不选择)
        btnSingleSelect2.setOnClickListener {
            startActivity(Intent(this,SingleSelect2Activity::class.java))
        }

        //多选
        btnMutilSelect.setOnClickListener {
            startActivity(Intent(this,MutilSelectActivity::class.java))
        }






    }
}