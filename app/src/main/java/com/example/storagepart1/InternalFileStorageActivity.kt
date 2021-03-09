package com.example.storagepart1

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.internal_file_storage.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

class InternalFileStorageActivity:AppCompatActivity() {
    companion object{
        const val FILE_NAME = "File 1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.internal_file_storage)

// Writing in File
        writeFileStorageBtn.setOnClickListener {
            saveFile()
        }

// Reading from File
        readFileStorageBtn.setOnClickListener {
            loadFile()
        }

    }
    private fun saveFile() {

        var data = dataFileStorageET.text.toString()
        try {
            val fOut: FileOutputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND)
            if (!data.isBlank()) {
                dataFileStorageET.text.clear()
                fOut.write(data.toByteArray())
                fOut.close()
                this.showToast("File Saved Successfully")
            }else this.showToast("Please enter text in required Field")
        }catch (e:Exception){
            e.printStackTrace()
        }
    }


    private fun loadFile() {

        try {
            val fIn: FileInputStream = openFileInput(FILE_NAME)
            var c: Int
            var temp = ""
            while (fIn.read().also { c = it } != -1) {
                temp += c.toChar().toString()
            }
            if (temp.isBlank()){
                this.showToast("Please enter text in the required Field")
            }else{
                dataFileStorageET.setText(temp)
                this.showToast("File Loaded")
            }
            fIn.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}