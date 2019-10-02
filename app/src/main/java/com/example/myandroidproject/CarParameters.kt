package com.example.myandroidproject

class CarParameters(carID: Int, carOwner: String, carType: CarTypes, carColor: String = "default") {
    //    constructor(carID: Int, carOwner: String, carType: CarTypes, carColor: String = "default") : this() {
//    }
    var car_ID:Int = carID
    var car_Owner:String = carOwner
    var car_Type: CarTypes = carType
    var car_Color:String = carColor

    var carID: Int = 0
        get() = field
        set(value) {
            field = value
        }

    var carOwner:String = "null"
        get() = field
        set(value){
            field = value
        }

    var carType: CarTypes = CarTypes.NULL
        get() = field
        set(value){
            field = value
        }

    var carColor:String = "default"
        get() = field
        set(value){
            field = value
        }

    override fun toString(): String {
        return "CarParameters(car_ID=$car_ID, car_Owner='$car_Owner', car_Type=$car_Type, car_Color='$car_Color')"
    }


}