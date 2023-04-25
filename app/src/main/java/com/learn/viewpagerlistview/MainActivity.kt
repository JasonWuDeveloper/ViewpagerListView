package com.learn.viewpagerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.learn.viewpagerlistview.adapter.MyFragmentPagerAdapter
import com.learn.viewpagerlistview.ui.task.buildNewList.BuildNewListFragment
import com.learn.viewpagerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private val listTitle = mutableListOf("預設")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyFragmentPagerAdapter(this, listTitle)
        binding.viewpager2.adapter = adapter
        binding.btnBuildNewList.setOnClickListener {
            changePage(BuildNewListFragment.Instance())
        }
        binding.add.setOnClickListener {
            listTitle.add(listTitle.size.toString())
            adapter.notifyDataSetChanged()
        }

        binding.delete.setOnClickListener {
            if (listTitle.size > 1) {
                listTitle.removeAt(listTitle.size - 1)
                adapter.notifyDataSetChanged()
            }
        }

        TabLayoutMediator(binding.tabs, binding.viewpager2) { tab, position ->
            tab.text = position.toString()
        }.attach()

    }

    fun changePage(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(com.google.android.material.R.id.container, fragment, fragment::class.simpleName)
            .addToBackStack(fragment::class.simpleName)
            .commit()
    }
}


