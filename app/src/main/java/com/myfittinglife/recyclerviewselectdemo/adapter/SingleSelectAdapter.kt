package com.myfittinglife.recyclerviewselectdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myfittinglife.recyclerviewselectdemo.R

/**
 * @Author LD
 * @Time 2020/11/17 9:47
 * @Describe  单选适配器
 * @Modify
 */
class SingleSelectAdapter(var mDataList: MutableList<String>) :
    RecyclerView.Adapter<SingleSelectAdapter.MyViewHolder>() {

    //选择的位置(-1则代表默认没有选中，0代表默认选中第一个)
    var selPosition = 0
    //临时记录上次选择的位置
    var temp =-1

    companion object{
        const val TAG ="ceshi"
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //日期
        var date = itemView.findViewById<TextView>(R.id.tvDate)
    }


    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.date.text = mDataList[position]

        holder.itemView.isSelected = holder.layoutPosition==selPosition

        holder.itemView.setOnClickListener {
            holder.itemView.isSelected =true
            //将旧的位置保存下来，用于后面把旧的位置颜色变回来
            temp = selPosition
            //设置新的位置
            selPosition = holder.layoutPosition
            //更新旧位置
            notifyItemChanged(temp)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_single_select, parent, false)
        return MyViewHolder(view)
    }
}