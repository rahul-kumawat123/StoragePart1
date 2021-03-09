package com.example.storagepart1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

fun Context.showToast(msg: String){
    Toast.makeText(this, msg , Toast.LENGTH_LONG).show()
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefButton.setOnClickListener(View.OnClickListener{
            val sharedPrefIntent = Intent(this , SharedPrefActivity::class.java)
            startActivity(sharedPrefIntent)
            this.showToast("You Pressed Shared Preferences Button")
        })

        internalFileStorageButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,InternalFileStorageActivity::class.java))
            this.showToast("You Pressed Internal File Storage Button")
        })
    }
}