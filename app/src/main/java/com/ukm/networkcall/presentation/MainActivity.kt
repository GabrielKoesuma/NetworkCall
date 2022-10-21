package com.ukm.networkcall.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ukm.networkcall.data.DogFactsApiClient
import com.ukm.networkcall.databinding.ActivityMainBinding
import com.ukm.networkcall.models.DogFactsData
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity () {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TestingAdapter
    private val api by inject<DogFactsApiClient> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)
        adapter = TestingAdapter()
        binding.rvContent.adapter = adapter
        binding.buttonChange.setOnClickListener {
            api.getFacts().enqueue(object: Callback<DogFactsData> {
                override fun onResponse(call: Call<DogFactsData>, response: Response<DogFactsData>) {
                    adapter.setNewInstance(response.body()?.facts?.filterNotNull()?.toMutableList())
                }

                override fun onFailure(call: Call<DogFactsData>, t: Throwable) {
                    // Do Nothing
                }
            })
        }
    }
}

