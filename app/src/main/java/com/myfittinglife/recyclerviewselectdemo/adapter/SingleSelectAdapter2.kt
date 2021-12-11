package com.myfittinglife.recyclerviewselectdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myfittinglife.recyclerviewselectdemo.R


/**
@Author LD
@Time 2021/12/11 9:40
@Describe 单选适配器(可以不选择)
@Modify
 */
class SingleSelectAdapter2(var mDataList: MutableList<String>) :
    RecyclerView.Adapter<SingleSelectAdapter2.MyViewHolder>() {

    companion object {
        const val TAG = "ceshi"
    }

    private var mItemClickListener: MyItemClickListener?=null


    //选择的位置(-1则代表默认没有选中，0代表默认选中第一个)
    private var selPosition = -1

    //临时记录上次选择的位置
    private var temp = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SingleSelectAdapter2.MyViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_single_select, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: SingleSelectAdapter2.MyViewHolder, position: Int) {
        holder.date.text = mDataList[position]

        holder.itemView.isSelected = holder.layoutPosition == selPosition

        holder.itemView.setOnClickListener {

            if (it.isSelected) {
                it.isSelected = false
                notifyItemChanged(selPosition)
                selPosition = -1
                //更新旧位置
                mItemClickListener?.onClick(holder.layoutPosition,false)
            }else{
                holder.itemView.isSelected = true
                //将旧的位置保存下来，用于后面把旧的位置颜色变回来
                temp = selPosition
                //设置新的位置
                selPosition = holder.layoutPosition
                //更新旧位置
                notifyItemChanged(temp)
                mItemClickListener?.onClick(holder.layoutPosition,true)
            }
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //日期
        var date = itemView.findViewById<TextView>(R.id.tvDate)
    }

    interface MyItemClickListener{
        fun onClick(position:Int,isSelect:Boolean)
    }

    fun setOnMyItemClickListener(listener:MyItemClickListener){
        this.mItemClickListener = listener
    }


}