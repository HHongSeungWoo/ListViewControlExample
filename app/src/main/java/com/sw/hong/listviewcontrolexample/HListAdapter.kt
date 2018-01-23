package com.sw.hong.listviewcontrolexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.TextView

/**
* Created by hong on 18. 1. 23.
*/

class HListAdapter(context: Context,item : ArrayList<String>) : BaseAdapter() {


    private val mContext = context
    private val mItem = item
    private val mInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        lateinit var viewHolder : ViewHolder
        //뷰가 캐싱되지 않았을 경우 뷰를 만들고 뷰 홀더에 등록.
        if(view == null){
            viewHolder = ViewHolder()
            view = mInflater.inflate(R.layout.listview_item,parent, false)
            viewHolder.textView = view.findViewById(R.id.textView)
            viewHolder.checkBox = view.findViewById(R.id.checkBox)
            view.tag = viewHolder
            viewHolder.textView.text = mItem[position]
            return view
        }else{
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.textView.text = mItem[position]
        return view
    }
    override fun getItem(position: Int) = mItem[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = mItem.size

    //내부클래스로 뷰홀더 생성
    inner class ViewHolder {
        lateinit var textView: TextView
        lateinit var checkBox: CheckBox
    }
}