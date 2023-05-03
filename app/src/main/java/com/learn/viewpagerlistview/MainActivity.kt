package com.learn.viewpagerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.CreationExtras
import com.learn.viewpagerlistview.databinding.ActivityMainBinding
import com.learn.viewpagerlistview.ui.taskList.TaskFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TaskFragment.instance())
            .commit()
    }
}


