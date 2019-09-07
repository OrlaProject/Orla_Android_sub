package com.genius.orlasub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        configureTopTab()


    }

    private fun configureTopTab() {
        vp_ac_order.adapter = OrderCategoryTabAdapter(supportFragmentManager, 4)
        tl_ac_order_toptab.setupWithViewPager(vp_ac_order)
        val toptab : View = this.layoutInflater.inflate(R.layout.tab_order_category,null,false)

        tl_ac_order_toptab.getTabAt(0)!!.customView = toptab.findViewById(R.id.rl_tab_order_category_order) as RelativeLayout
        tl_ac_order_toptab.getTabAt(1)!!.customView = toptab.findViewById(R.id.rl_tab_order_category_made) as RelativeLayout
        tl_ac_order_toptab.getTabAt(2)!!.customView = toptab.findViewById(R.id.rl_tab_order_category_finish)as RelativeLayout
        tl_ac_order_toptab.getTabAt(3)!!.customView = toptab.findViewById(R.id.rl_tab_order_category_delivery) as RelativeLayout

    }
}
