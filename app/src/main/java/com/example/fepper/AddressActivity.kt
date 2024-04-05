package com.example.fepper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AddressActivity : AppCompatActivity() {
    lateinit var backBtn:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        backBtn=findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}