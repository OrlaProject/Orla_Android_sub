package com.genius.orlasub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genius.orlasub.Data.OrderListData

class OrderListRecyclcerViewAdapter  (val ctx: Context, val orderlist : ArrayList<OrderListData>) :  RecyclerView.Adapter<OrderListRecyclcerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderListRecyclcerViewAdapter.Holder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_order_list, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int = orderlist.size

    override fun onBindViewHolder(holder: OrderListRecyclcerViewAdapter.Holder, position: Int) {
       holder.content.text = orderlist[position].content
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val content : TextView = itemView.findViewById(R.id.tv_rv_order_list_content) as TextView




    }

}