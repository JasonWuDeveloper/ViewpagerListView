package com.learn.viewpagerlistview.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.viewpagerlistview.databinding.FragmentBaseBinding

class MyFragment : Fragment() {
    private lateinit var binding: FragmentBaseBinding
    fun newInstance(s: String): MyFragment {
        val fragment = MyFragment()
        val bundle = Bundle()
        bundle.putString("content", s)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = arguments?.getString("content")
        binding = FragmentBaseBinding.inflate(layoutInflater)
        val tvContent = binding.textView
        tvContent.text = content
        return binding.root

    }
}