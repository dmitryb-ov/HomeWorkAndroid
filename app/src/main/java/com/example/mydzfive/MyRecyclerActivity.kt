package com.example.mydzfive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydzfive.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

class MyRecyclerActivity : AppCompatActivity() {
    private var adapter: MyRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        adapter = MyRecyclerAdapter(generateCities()) { city ->
            detail(city)
        }

        recyclerView.adapter = adapter
    }


    private fun detail(city: City) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("cityName", city.name)
        intent.putExtra("img", city.img)
        intent.putExtra("description", city.description)
        startActivity(intent)
    }

    private fun generateCities(): List<City> = arrayListOf(
        City(
            "Москва",
            R.drawable.moscow,
            "Москва – столица России, многонациональный город на Москве-реке в западной части страны. В его историческом центре находится средневековая крепость Кремль – резиденция российского президента"
        ),
        City(
            "Находка",
            R.drawable.naxodka,
            "\"Нахо́дка — город в Приморском крае России. Административно входит в Находкинский городской округ. Население — 147 468 чел.,\""
        ),
        City(
            "Уфа",
            R.drawable.ufa,
            "Уфа́ — один из крупнейших городов России, столица Республики Башкортостан, административный центр Уфимского района"
        ),
        City(
            "Нижнекамск",
            R.drawable.nijnekamsk,
            "Нижнека́мск — город в Республике Татарстан, Россия. Административный центр Нижнекамского района"
        ),
        City(
            "Ржев",
            R.drawable.rjev,
            "Ржев — город в России, административный центр Ржевского района Тверской области"
        )

    )
}
