package com.genius.orlasub

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_material_add.*
import kotlinx.android.synthetic.main.activity_material_add.view.*
import kotlinx.android.synthetic.main.activity_order_material_modify.*

class MaterialAddActivity : AppCompatActivity() {

    var num : String = ""
    var kind : String = ""
    var person : String = ""
    var address : String = ""
    var building : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_add)




        setOnClickListenr()
        setColorButton()
    }

    private fun setColorButton() {




        if(et_material_add_num.text.toString() == ""){

            btn_ckeck_num.setBackgroundColor(Color.parseColor("#9b9b9b"))

        }


        else{

            btn_ckeck_num.setBackgroundColor(Color.parseColor("#3468ff"))

        }
    }

    private fun setOnClickListenr() {



        btn_ckeck_num.setOnClickListener {

            num =  et_material_add_num.text.toString()!!
            tv_ac_material_add_num.text = num

            kind = "무농약 농산물"
            tv_ac_material_add_kind.text = kind

            person = "정인호"
            tv_ac_material_add_person.text = person


            address = "경기도 파주시 파평면"
            tv_ac_material_add_address.text = address


            building = "주식회사 에코리더스인증원"
            tv_ac_material_add_bulid.text = building


        }



    }
}
