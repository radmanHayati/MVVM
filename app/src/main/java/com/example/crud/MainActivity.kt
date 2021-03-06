package com.example.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.crud.databinding.ActivityMainBinding
import com.example.crud.db.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)  // declaring binding and giving layout to it
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        val subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.myViewModel=subscriberViewModel
        binding.lifecycleOwner=this
        subscriberViewModel.subscribers.observe(this, {
            Log.i("MYTAG",it.toString())
        })
     //   displaySubscribersList()

    }
    /*
    private fun displaySubscribersList(){
        subscriberViewModel.subscribers.observe(this, {
            Log.i("MYTAG",it.toString())
        })
    }

     */
}