package com.learn.viewpagerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.learn.viewpagerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = mutableListOf("預設")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyFragmentPagerAdapter(this, list)
        binding.viewpager2.adapter = adapter

        binding.add.setOnClickListener {
            list.add(list.size.toString())
            adapter.notifyDataSetChanged()
        }

        binding.delete.setOnClickListener {
            if (list.size > 1) {
                list.removeAt(list.size - 1)
                adapter.notifyDataSetChanged()
            }
        }

        TabLayoutMediator(binding.tabs, binding.viewpager2) { tab, position ->
            tab.text = position.toString()
        }.attach()

    }
}


