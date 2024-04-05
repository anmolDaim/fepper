package com.example.fepper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class WalletActivity : AppCompatActivity() {
    lateinit var homeActivity:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        homeActivity=findViewById(R.id.homeActivity)

        homeActivity.setOnClickListener{
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}