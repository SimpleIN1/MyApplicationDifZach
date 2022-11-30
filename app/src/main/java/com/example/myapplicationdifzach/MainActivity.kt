package com.example.myapplicationdifzach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private fun fib(n:Int): Int{
        if (n == 0)
            return 0
        if (n == 1)
            return 1
        return fib(n-1) + fib(n-2)
    }

    lateinit var adapter: RecyclerAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listString = mutableListOf<String>()

//        val textView = findViewById<TextView>(R.id.TextView)
        var i=0

        adapter = RecyclerAdapter(listString)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        lifecycleScope.launch(Dispatchers.Default) {
            while(true) {
                delay(1000)
                listString.add(fib(i).toString())

                withContext(Dispatchers.Main) {
                    adapter.notifyItemInserted(listString.lastIndex)
                }
                ++i
            }
        }
    }
}