package com.myfittinglife.recyclerviewselectdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myfittinglife.recyclerviewselectdemo.R


/**
 * @Author LD
 * @Time 2020/11/17 15:24
 * @Describe 多选适配器
 * @Modify
 */
class MutilSelectAdapter(val dataList:MutableList<String>):RecyclerView.Adapter<MutilSelectAdapter.MyViewHolder>() {


    //用来记录已经勾选的位置(set集合是为了防止放入重复数据)
    var mutilSelectedList = mutableSetOf<Int>()

    companion object{
        const val TAG = "ceshi"
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var tvContent: TextView =itemView.findViewById<TextView>(R.id.tvContent)
        var ivSelect: ImageView = itemView.findViewById<ImageView>(R.id.ivSelect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view =LayoutInflater.from(parent.context).inflate(R.layout.item_mutil_select,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvContent.text = dataList[position]
        holder.ivSelect.isSelected = mutilSelectedList.contains(position)
        holder.itemView.setOnClickListener {

            if (mutilSelectedList.contains(position)) {
                mutilSelectedList.remove(position)
                holder.ivSelect.isSelected = false
                Log.i(TAG, "onBindViewHolder: 取消选中")
            } else {
                mutilSelectedList.add(position)
                holder.ivSelect.isSelected = true
                Log.i(TAG, "onBindViewHolder: 选中")
            }
        }
    }

    /**
     * 获取选中的列表
     */
    fun getSelectList(): MutableSet<Int> {
        return mutilSelectedList
    }
}