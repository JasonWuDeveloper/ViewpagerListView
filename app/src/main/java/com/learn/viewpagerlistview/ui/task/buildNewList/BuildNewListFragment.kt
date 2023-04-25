package com.learn.viewpagerlistview.ui.task.buildNewList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.viewpagerlistview.databinding.FragmentBuildNewListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BuildNewListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuildNewListFragment : Fragment() {
    private lateinit var binding: FragmentBuildNewListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBuildNewListBinding.inflate(layoutInflater)
        return binding.root

        binding.tvComplete.setOnClickListener{

        }
    }

    fun newInstance(s: String): BuildNewListFragment {
        val fragment = BuildNewListFragment()
        val bundle = Bundle()
        bundle.putString("content", s)
        fragment.arguments = bundle
        return fragment
    }
    fun sendOutMsg(c: Class<*>,params: String = ""): Boolean {
        return sendOutMsg(c, "")
    }
    companion object {
        fun Instance() = BuildNewListFragment()
    }
}