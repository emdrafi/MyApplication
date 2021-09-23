package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.rv_recycler)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<NewsViewModel>()
        data.add(NewsViewModel("Beavers","Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony","https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg"))
        data.add(NewsViewModel("Beavers","Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony","http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png"))

        data.add(NewsViewModel("Beavers","Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony","http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg"))

        data.add(NewsViewModel("Beavers","Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony","http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

        data.add(NewsViewModel("Beavers","Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony","http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

        // This will pass the ArrayList to our Adapter
        val adapter = NewsAdapter(data,this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}