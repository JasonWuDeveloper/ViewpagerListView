package com.learn.viewpagerlistview.ui.taskList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.learn.viewpagerlistview.adapter.MyFragmentPagerAdapter
import com.learn.viewpagerlistview.databinding.FragmentBlankBinding


class TaskFragment : Fragment() {
    private val listTitle = mutableListOf("預設")
    private lateinit var binding: FragmentBlankBinding
    private lateinit var adapter: MyFragmentPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MyFragmentPagerAdapter(this, listTitle)
        binding.viewpager2.adapter = adapter
        binding.btnBuildNewList.setOnClickListener {
//            changePage(BuildNewListFragment.Instance())
        }


        binding.add.setOnClickListener {
            listTitle.add(listTitle.size.toString())
            adapter?.notifyDataSetChanged()
        }

        binding.delete.setOnClickListener {
            if (listTitle.size > 1) {
                listTitle.removeAt(listTitle.size - 1)
                adapter?.notifyDataSetChanged()
            }
        }

        TabLayoutMediator(binding.tabs, binding.viewpager2) { tab, position ->
            tab.text = position.toString()
        }.attach()

    }
    private fun newInstance(s: String): TaskFragment {
        val fragment = TaskFragment()
        val bundle = Bundle()
        bundle.putString("content", s)
        fragment.arguments = bundle
        return fragment
    }

    companion object {
        fun instance() = TaskFragment()
    }
    }

