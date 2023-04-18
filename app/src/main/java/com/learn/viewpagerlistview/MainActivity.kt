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
    val list = mutableListOf<String>("預設")
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyFragmentPagerAdapter(this, list)
        binding.viewpager2.adapter = adapter
//       binding.viewpager.adapter = object : FragmentStateAdapter(this) {
//            override fun getItemCount(): Int {
//                return 3
//            }
        binding.add.setOnClickListener {
            list.add("add")
            adapter.notifyDataSetChanged()
        }

        binding.delete.setOnClickListener {
            if (list.size > 1) {
                list.removeAt(list.size - 1)
                adapter.notifyDataSetChanged()
            }
        }
//            override fun createFragment(position: Int): Fragment {
//                return when(position) {
//                    0 -> ScaleFragment()
//
//                    1 -> RotateFragment()
//
//                    else -> TranslateFragment()
//                }

        TabLayoutMediator(binding.tabs, binding.viewpager2) { tab, position ->
            when (position) {
                0 -> tab.text = list[0]

            }
        }.attach()

    }
}


