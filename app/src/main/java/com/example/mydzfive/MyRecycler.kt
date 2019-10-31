package com.example.mydzfive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzfive.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

class MyRecycler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerAdapter(generateCities())
    }

    private fun generateCities(): List<CitiesClass> {
        val values = mutableListOf<CitiesClass>()
        val ci1 = CitiesClass(
            "Москва",
            R.drawable.moscow,
            "Москва – столица России, многонациональный город на Москве-реке в западной части страны. В его историческом центре находится средневековая крепость Кремль – резиденция российского президента"
        )
        val ci2 = CitiesClass("Казань", R.drawable.kazan, "Я тут живу")
        val ci3 = CitiesClass(
            "Находка",
            R.drawable.naxodka,
            "Нахо́дка — город в Приморском крае России. Административно входит в Находкинский городской округ. Население — 147 468 чел.,"
        )
        val ci4 = CitiesClass(
            "Уфа",
            R.drawable.ufa,
            "Уфа́ — один из крупнейших городов России, столица Республики Башкортостан, административный центр Уфимского района, в состав которого не входит."
        )
        val ci5 = CitiesClass(
            "Нижнекамск",
            R.drawable.nijnekamsk,
            "Нижнека́мск — город в Республике Татарстан, Россия. Административный центр Нижнекамского района, образует городское поселение город Нижнекамск"
        )
        val ci6 = CitiesClass(
            "Ржев",
            R.drawable.rjev,
            "Ржев — город в России, административный центр Ржевского района Тверской области. Образует городской округ город Ржев. Город воинской славы России"
        )
        val ci7 = CitiesClass("Оймякон", R.drawable.ojmjakon, "Там холодно")
        val ci8 = CitiesClass(
            "Чебоксары",
            R.drawable.chebi,
            "Чебокса́ры — город в России, столица Чувашской Республики, крупный порт на правом берегу реки Волги, при впадении в неё реки Чебоксарки"
        )
        val ci9 = CitiesClass(
            "Арск",
            R.drawable.arsk,
            "Арск — город в Республике Татарстан России. Административный центр Арского района, образует муниципальное образование «город Арск», наделённое статусом городского поселения."
        )
        val ci10 = CitiesClass(
            "Нурлат",
            R.drawable.nurlat,
            "Нурла́т, ранее Нурлат-Октябрьский — город в Республике Татарстан Российской Федерации, административный центр Нурлатского района"
        )
        values.add(ci1)
        values.add(ci2)
        values.add(ci3)
        values.add(ci4)
        values.add(ci5)
        values.add(ci6)
        values.add(ci7)
        values.add(ci8)
        values.add(ci9)
        values.add(ci10)
        return values
    }
}
