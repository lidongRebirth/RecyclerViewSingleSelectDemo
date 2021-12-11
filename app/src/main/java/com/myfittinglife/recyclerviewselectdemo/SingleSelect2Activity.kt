package com.myfittinglife.recyclerviewselectdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.myfittinglife.recyclerviewselectdemo.adapter.SingleSelectAdapter2
import kotlinx.android.synthetic.main.activity_single_select2.*

/**
 @Author LD
 @Time 2021/12/11 9:46
 @Describe 单选，可不选择
 @Modify
*/
class SingleSelect2Activity : AppCompatActivity() {

    var dataList = mutableListOf<String>()
    var singleSelectAdapter =
        SingleSelectAdapter2(
            dataList
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_select2)

        initData()
        initRecyclerView()
    }

    private fun  initData(){
        dataList.add("10-28")
        dataList.add("10-29")
        dataList.add("10-30")
        dataList.add("10-31")
        dataList.add("11-1")
        dataList.add("11-2")
        dataList.add("11-3")
        dataList.add("11-4")
        dataList.add("11-5")
        dataList.add("11-6")
        dataList.add("11-7")
        dataList.add("11-8")
        dataList.add("11-9")
        dataList.add("11-10")
        dataList.add("11-11")
        dataList.add("11-12")
        dataList.add("11-13")
        dataList.add("11-14")
        dataList.add("11-15")
        dataList.add("11-16")
        dataList.add("11-17")
        dataList.add("11-18")
    }
    private fun  initRecyclerView(){
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mRecyclerView.layoutManager = layoutManager
        //将动画去除
        (mRecyclerView.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
        mRecyclerView.adapter = singleSelectAdapter

        singleSelectAdapter.setOnMyItemClickListener(object :SingleSelectAdapter2.MyItemClickListener{
            override fun onClick(position: Int, isSelect: Boolean) {
                if(isSelect){
                    Toast.makeText(this@SingleSelect2Activity,"选中：${dataList[position]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@SingleSelect2Activity,"取消选中：${dataList[position]}",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}