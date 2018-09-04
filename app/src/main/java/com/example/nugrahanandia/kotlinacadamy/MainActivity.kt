package com.example.nugrahanandia.kotlinacadamy

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.item_list.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items){
            items : Item -> itemClicked(items)
        }
    }

    private fun itemClicked(items: Item) {
        Toast.makeText(this, "Clicked: ${items.name}", Toast.LENGTH_SHORT).show()

        val detailActivity = Intent(this, DetailActivity::class.java)
        detailActivity.putExtra("name", items.name)
        detailActivity.putExtra("image", items.image)
        detailActivity.putExtra("detail", items.desc)
        startActivity(detailActivity)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.detail_name)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),
                    detail[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
