package com.genius.orlasub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genius.orlasub.Data.OrderListData

class OrderMadeListRecyclcerViewAdapter  (val ctx: Context, val orderlist : ArrayList<OrderListData>) :  RecyclerView.Adapter<OrderMadeListRecyclcerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderMadeListRecyclcerViewAdapter.Holder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_order_made_list, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int = orderlist.size

    override fun onBindViewHolder(holder: OrderMadeListRecyclcerViewAdapter.Holder, position: Int) {
       holder.content.text = orderlist[position].content
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val content : TextView = itemView.findViewById(R.id.tv_rv_order_made_list_content) as TextView




    }

}