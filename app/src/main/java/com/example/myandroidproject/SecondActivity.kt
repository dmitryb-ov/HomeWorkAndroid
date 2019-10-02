package com.example.myandroidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var logoutButton:Button? = null
        var createRegistry:Button? = null

        logoutButton = findViewById<Button>(R.id.logout)
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val carRegImpl = CarRegistryImpl()

        carRegImpl.add(1,"Dima", CarTypes.MIDDLE_TYPE,"Red")
        carRegImpl.add(2,"Sergey", CarTypes.LUXURY_TYPE,"blue")
        carRegImpl.add(3,"Alexey", CarTypes.HIGHT_TYPE, "")
        carRegImpl.add(4,"Nikita", CarTypes.SIMPLY_TYPE,"pink")

        var carRegImplInt:Int = carRegImpl.capasity()
        var carRegImplCarDetails:String = carRegImpl.capasityDetails()
        var carRegImplAllCar:String = carRegImpl.getAll()

        createRegistry = findViewById<Button>(R.id.create_registry)
        createRegistry.setOnClickListener {
            val intent = Intent(this, Registry::class.java)
            intent.putExtra("capacity",carRegImplInt)
            intent.putExtra("capacityDetails",carRegImplCarDetails)
            intent.putExtra("allInfo",carRegImplAllCar)
            startActivity(intent)
        }
    }
}
