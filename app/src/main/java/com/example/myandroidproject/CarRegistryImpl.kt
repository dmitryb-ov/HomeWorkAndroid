package com.example.myandroidproject

import android.content.ContentValues.TAG
import android.util.Log
import java.util.ArrayList

class CarRegistryImpl() : CarRegistryInterface {
    private var listOfCarRegistry: ArrayList<CarParameters> = ArrayList()
    private var carParameters: CarParameters? = null
    private var maxCapacityCars: Int = 100

//    fun CarRegistryImpl(){
//        listOfCarRegistry = ArrayList()
//    }

    override fun add(carID: Int, ownerName: String, carType: CarTypes, carColor: String) {
        carParameters = CarParameters(carID, ownerName, carType, carColor)
        listOfCarRegistry.add(carParameters!!)
        maxCapacityCars--
        Log.i(TAG, "Добавлено")
    }

//    override fun remove(carID: Int) {
//        listOfCarRegistry.removeAt(listOfCarRegistry.indexOf(carParameters.carID))
//    }

    override fun capasity(): Int {
        Log.i(TAG, "Просмотрена длина")
        return listOfCarRegistry.size
    }

    fun capasityDetails(): String {
        var value: String
        value = "Cars at the moment: " + listOfCarRegistry.size + "\n" +
                "Cars can be: " + maxCapacityCars
        return value
    }

    fun getAll(): String {
        return carParameters.toString()
    }
//    override fun getOwner(id: Int): String {
//
//    }
//
//    override fun getID(ownerName: String): Int {
//
//    }
}