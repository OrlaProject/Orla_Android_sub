package com.genius.orlasub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genius.orlasub.Data.MaterialListData

class OrderMaterialModifyRecyclcerViewAdapter  (val ctx: Context, val materiallist : ArrayList<MaterialListData>) :  RecyclerView.Adapter<OrderMaterialModifyRecyclcerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderMaterialModifyRecyclcerViewAdapter.Holder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_material_modify_list, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int = materiallist.size

    override fun onBindViewHolder(holder: OrderMaterialModifyRecyclcerViewAdapter.Holder, position: Int) {
       holder.num.text = materiallist[position].num
       holder.name.text = materiallist[position].name
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val name : TextView = itemView.findViewById(R.id.tv_rv_material_modify_name) as TextView
        val num : TextView = itemView.findViewById(R.id.tv_rv_material_modify_num) as TextView




    }

}