package com.genius.orlasub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class OrderCategoryTabAdapter (fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment? {

        when(position){
            0 -> return OrderListFragment()
            1 -> return OrderMadeListFragment()
            2 -> return OrderFinishListFragment()
            3 -> return OrderListFragment()
            else -> return null
        }

    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }


}