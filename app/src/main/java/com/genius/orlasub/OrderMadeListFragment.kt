package com.genius.orlasub


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.orlasub.Data.OrderListData
import kotlinx.android.synthetic.main.fragment_order_list.*
import kotlinx.android.synthetic.main.fragment_order_made_list.*

/**
 * A simple [Fragment] subclass.
 */
class OrderMadeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_made_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var orderlist : ArrayList<OrderListData> = ArrayList()
        orderlist.add(OrderListData("이상윤님,친환경 사과 주스 x1","제조완료"))
        orderlist.add(OrderListData("배선영님, 해커톤 샌드위치 x1","제조완료"))
        orderlist.add(OrderListData("이소희님, 오렌지 샐러드x1","제조완료"))
        orderlist.add(OrderListData("최다예님, 친환경 사과 주스 x1","제조완료"))
        orderlist.add(OrderListData("하승완님, 해커톤 샌드위치 x1","제조완료"))


        var orderMadeListRecyclcerViewAdapter= OrderMadeListRecyclcerViewAdapter (context!!,orderlist)
        rv_fg_order_made_list.adapter = orderMadeListRecyclcerViewAdapter
        rv_fg_order_made_list.layoutManager =  LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)



    }




}
