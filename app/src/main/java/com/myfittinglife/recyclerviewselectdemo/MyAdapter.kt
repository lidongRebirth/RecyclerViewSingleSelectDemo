package com.myfittinglife.recyclerviewselectdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author LD
 * @Time 2020/11/17 9:47
 * @Describe  单选适配器
 * @Modify
 */
class MyAdapter(var mDataList: MutableList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    companion object{
        const val TAG = "ceshi"
    }
    //记录选中的位置
    var currentPosition = -1

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //日期
        var date = itemView.findViewById<TextView>(R.id.tvDate)
    }


    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.date.text = mDataList[position]

        Log.i(TAG, "onBindViewHolder: ")
        var my = currentPosition
        var my2 = holder.adapterPosition
        var my3 = holder.layoutPosition
        Log.i(TAG, "current值为:$currentPosition ，position位置为：${holder.layoutPosition} ")
        holder.itemView.isSelected = currentPosition == holder.adapterPosition
        holder.itemView.setOnClickListener {
            //设置新的位置为选中状态
            holder.itemView.isSelected =true

            //更新旧的位置
            var a = currentPosition
            var b = holder.adapterPosition
            notifyItemChanged(currentPosition)      //它会等后面执行完成才会执行这个更新
            //新的位置
            currentPosition = holder.adapterPosition
            Log.i(TAG, "点击的位置为 $position")
            Log.i(TAG, "赋值完后的currentPosition为：$currentPosition")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_single_select, parent, false)
        return MyViewHolder(view)
    }
}