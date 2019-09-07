package com.genius.orlasub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.orlasub.Data.MaterialListData
import kotlinx.android.synthetic.main.activity_order_material_modify.*


class OrderMaterialModifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_material_modify)



        var materiallist: ArrayList<MaterialListData> = ArrayList()
        materiallist.add(MaterialListData("사과","등록번호 : 031300001"))
        materiallist.add(MaterialListData("사과","등록번호 : 031300001"))
        materiallist.add(MaterialListData("사과","등록번호 : 031300001"))
        materiallist.add(MaterialListData("사과","등록번호 : 031300001"))




        var materialModifyRecyclcerViewAdapter= OrderMaterialModifyRecyclcerViewAdapter(this,materiallist)
        rv_ac_material_modify_list.adapter = materialModifyRecyclcerViewAdapter
        rv_ac_material_modify_list.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)




    }
}
