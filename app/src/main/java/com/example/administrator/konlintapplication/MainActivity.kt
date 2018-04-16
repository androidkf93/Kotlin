package com.example.administrator.konlintapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.konlitapp.Test
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content.text = "Hello_Kotlin"
        val list : MutableList<Test> = ArrayList()
        for (i in 1..30){
            list.add(Test("ff_" + i, "ff_hh_" + i))
        }
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(this, list)
        adapter.setItemListener({position, t ->
            Toast.makeText(content.context,
                    "position = " + position + "\nt.name" + t.n,
                    Toast.LENGTH_SHORT).show()})
        recycler.adapter = adapter
    }
}
