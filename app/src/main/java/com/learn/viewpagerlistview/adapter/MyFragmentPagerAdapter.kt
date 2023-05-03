package com.learn.viewpagerlistview.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.learn.viewpagerlistview.ui.taskList.MyFragment

class MyFragmentPagerAdapter(fragment: Fragment, private val list: List<String>): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return MyFragment().newInstance(list[position])
    }
}