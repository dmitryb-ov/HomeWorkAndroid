package com.example.myandroidproject

interface CarRegistryInterface {
    //Возвращает кол-во машин в реестре
    fun capasity():Int
    //Возвращает владельца по индексу
//    fun getOwner(id:Int):String
    //Возвращает id авто по имени владельца
//    fun getID(ownerName:String):Int
    //Добавляет авто
    fun add(carID:Int, ownerName: String, carType: CarTypes, carColor:String="default")
    //Удаляет авто
//    fun remove(carID:Int)

}