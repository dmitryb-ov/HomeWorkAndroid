package com.example.myandroidproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class CardFragment : Fragment() {
    private lateinit var adapter: Adapter
    private lateinit var listComp: ArrayList<CardViewComponents>
    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.card_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listComp = ArrayList()
        listComp.add(CardViewComponents("Казань", R.drawable.kazan, R.drawable.kazan, "Казань – город на юго-западе России, расположенный на берегах Волги и Казанки. В столице полуавтономной Республики Татарстан находится древний кремль – крепость, известная своими музеями и святыми местами. Башня Сююмбике, синие и золотые купола Благовещенского собора и яркая джума-мечеть Кул-Шариф – одни из самых интересных достопримечательностей кремля"))
        listComp.add(CardViewComponents("Чебоксары", R.drawable.chebi, R.drawable.chebi, "Чебокса́ры — город в России, столица Чувашской Республики, крупный порт на правом берегу реки Волги, при впадении в неё реки Чебоксарки. Один из крупнейших религиозных, экономических, политических, научных, образовательных, культурных и спортивных центров Поволжья. Образует городской округ город Чебоксары"))
        listComp.add(CardViewComponents("Москва", R.drawable.moscow, R.drawable.moscow, "Москва – столица России, многонациональный город на Москве-реке в западной части страны. В его историческом центре находится средневековая крепость Кремль – резиденция российского президента. "))


        viewPager = view.findViewById(R.id.viewPager)
        adapter = Adapter(listComp, view.context)
        viewPager.adapter = adapter
    }
}