package com.example.recyclerviewprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewprac.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val list : ArrayList<ItemData> = ArrayList()
        binding.mainRecycler.adapter = RecyclerAdapter(list) { data, pos ->
            list.removeAt(pos)
            Toast.makeText(this, data.itemNumberText, Toast.LENGTH_SHORT).show()
            binding.mainRecycler.adapter?.notifyItemRemoved(pos)
        }
        /* add code */
        binding.btnDo.setOnClickListener {
            val randomInt = Random.nextInt(100) + 1
            list.add(ItemData("현주놈",randomInt.toString()))
            binding.mainRecycler.adapter?.notifyItemInserted(list.size-1)
        }




    }




}