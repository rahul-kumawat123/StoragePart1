package com.example.storagepart1

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.shared_pref.*

class SharedPrefActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shared_pref)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)

// Submitting Data in Shared Preferences
        submitSharedPrefBtn.setOnClickListener {

            val editor = sharedPref.edit()
            val text :String? = dataSharedPrefET.text.toString()

            if(text.isNullOrBlank()){
                this.showToast("Please enter Text in the required Field")
            }else{
                dataSharedPrefET.text.clear()
                editor.putString("Shared Preference Text", text)
                editor.apply()
                this.showToast("Data Submitted Sucessfully")
            }
        }

// Retrieving Data from Shared Preferences
        retrieveSharedPrefBtn.setOnClickListener {
            val retrievedData = sharedPref.getString("Shared Preference Text", "")

            if(retrievedData.isNullOrBlank()){
                this.showToast("Please enter Text in the required Field")
            }else{
                dataSharedPrefET.setText(retrievedData)
                showToast("Data is Visible Now")
            }
        }
    }
}