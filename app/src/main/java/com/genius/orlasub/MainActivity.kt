package com.genius.orlasub

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {

        btn_ac_main_order_go.setOnClickListener {

            startActivity<OrderActivity>()
        }

        btn_ac_main_material_go.setOnClickListener {
            startActivity<OrderMaterialModifyActivity>()
        }
    }
}
