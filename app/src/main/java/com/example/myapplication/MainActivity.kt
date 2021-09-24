package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.rv_recycler)
        var data: ArrayList<NewsViewModel> = ArrayList()

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        try{
            val obj=JSONObject(loadJSONFromAsset())
            val rowsArray=obj.getJSONArray("rows")
            for (i in 0 until rowsArray.length()) {
                val rowsDetail = rowsArray.getJSONObject(i)
                data.add(NewsViewModel(rowsDetail.getString("title"),rowsDetail.getString("description"),rowsDetail.getString("imageHref")))

            }

        }catch (e:JSONException){
            e.printStackTrace()
        }
        val adapter = NewsAdapter(data,this)
        recyclerview.adapter = adapter

    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("myJson.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}

