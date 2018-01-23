package com.sw.hong.listviewcontrolexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mItem = ArrayList<String>()
    private lateinit var mAdapter : HListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter =  HListAdapter(this,mItem)
        listView.adapter = mAdapter
        //리스트뷰의 선택모드를 다중선택모드로 설정
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        //추가버튼 리스너 등록
        button_add.setOnClickListener {
            mItem.add(editText.text.toString())  // 아이템추가.
            mAdapter.notifyDataSetChanged()      // 어뎁터에 데이터 변경이 있음을 알림.
        }
        //삭제버튼 리스너 등록
        button_del.setOnClickListener {
            val checkedItem = listView.checkedItemPositions

            //for문과 동일
            (mAdapter.count downTo 0)
                    .filter { checkedItem.get(it) }
                    .forEach { mItem.removeAt(it) }

            //선택초기화
            listView.clearChoices()
            //데이터가 변경됬음을 알림
            mAdapter.notifyDataSetChanged()

        }
        //수정버튼 리스너 등록
        button_modified.setOnClickListener {
            val checkedItem = listView.checkedItemPositions
            //for문과 동일
            (mAdapter.count downTo 0)
                    .filter { checkedItem.get(it) }
                    .forEach { mItem[it] = editText.text.toString() }

            mAdapter.notifyDataSetChanged()
        }
    }
}
