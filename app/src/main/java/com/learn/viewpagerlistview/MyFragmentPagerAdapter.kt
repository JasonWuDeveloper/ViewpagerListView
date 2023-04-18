package com.learn.viewpagerlistview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentPagerAdapter(fm: FragmentActivity, private val list: List<String>): FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return MyFragment().newInstance(list[position])
    }
}