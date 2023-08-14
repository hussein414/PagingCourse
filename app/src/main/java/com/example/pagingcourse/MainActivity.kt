package com.example.pagingcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagingcourse.databinding.ActivityMainBinding
import com.example.pagingcourse.ui.adapter.RickAndMortyAdapter
import com.example.pagingcourse.ui.viewmodel.RickAndMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RickAndMortyViewModel by viewModels()
    private lateinit var rickAndMortyAdapter: RickAndMortyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        rickAndMortyAdapter = RickAndMortyAdapter()
        loadingData()
        binding.recyclerView.apply {
            adapter = rickAndMortyAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                rickAndMortyAdapter.submitData(pagingData)
            }
        }
    }
}