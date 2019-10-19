package com.example.myandroidproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val uri = Uri.parse("http:vk.com")

            val openLink = Intent(Intent.ACTION_VIEW, uri)
            if (openLink.resolveActivity(packageManager) != null) {
               // Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                startActivityForResult(openLink,1)
            } else {
                Toast.makeText(this,"Bad request", Toast.LENGTH_LONG).show()
            }

        }

        button2.setOnClickListener {
            val geo:Uri = Uri.parse("geo:55.792170, 49.122234")
            val openGeo = Intent(Intent.ACTION_VIEW, geo)
            startActivityForResult(openGeo,2)
        }

        button3.setOnClickListener {
            val image = Intent()
            image.type = "image/*"
            image.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(image, "Pic"),3)
        }

        button4.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, editText.text.toString())
            intent.type = "text/plain"
            startActivityForResult(intent, 4)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && requestCode == 2 && requestCode == 4) {
            Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
        }
        if(requestCode == 3){
            imageView.setImageResource(R.drawable.img)
        }
    }
}
