package com.myfittinglife.recyclerviewselectdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.myfittinglife.recyclerviewselectdemo.adapter.MutilSelectAdapter
import kotlinx.android.synthetic.main.activity_mutil_select.*

/**
 @Author LD
 @Time 2020/11/17 15:46
 @Describe 多选
 @Modify
*/
class MutilSelectActivity : AppCompatActivity() {

    var dataList = mutableListOf<String>()
    var mutilSelectAdapter = MutilSelectAdapter(dataList)

    companion object{
        const val TAG = "ceshi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutil_select)

        initData()
        initRecyclerView()

        btnGetSelected.setOnClickListener {
            var selectList = mutilSelectAdapter.getSelectList()
            Log.i(TAG, "onCreate:${selectList} ")
            Toast.makeText(this,selectList.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData(){
        dataList.add("0")
        dataList.add("1")
        dataList.add("2")
        dataList.add("3")
        dataList.add("4")
        dataList.add("5")
        dataList.add("6")
        dataList.add("7")
        dataList.add("8")
        dataList.add("9")
        dataList.add("10")
        dataList.add("11")
        dataList.add("12")
        dataList.add("13")
        dataList.add("14")
        dataList.add("15")
        dataList.add("16")
        dataList.add("17")
        dataList.add("18")
        dataList.add("19")
        dataList.add("20")
        dataList.add("21")
        dataList.add("22")
        dataList.add("23")
        dataList.add("24")
        dataList.add("25")
        dataList.add("26")
        dataList.add("27")
        dataList.add("28")
        dataList.add("29")
        dataList.add("30")
        dataList.add("31")
        dataList.add("32")
        dataList.add("33")
        dataList.add("34")
        dataList.add("35")
        dataList.add("36")
        dataList.add("37")
        dataList.add("38")
        dataList.add("39")
        dataList.add("40")
        dataList.add("41")
        dataList.add("42")
        dataList.add("43")
        dataList.add("44")
        dataList.add("45")
        dataList.add("46")
        dataList.add("47")
        dataList.add("48")
        dataList.add("49")
        dataList.add("50")
    }

    private fun initRecyclerView(){

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mutilSelectAdapter

    }
}