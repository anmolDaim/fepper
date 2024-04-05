package com.example.fepper

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class PaymentActivity : AppCompatActivity() {
    lateinit var backBtn:ImageView
    lateinit var cashOnDelivery:ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        cashOnDelivery=findViewById(R.id.cashOnDelivery)
        cashOnDelivery.setOnClickListener {
            val intent=Intent(this,BookingFragment::class.java)
            startActivity(intent)
        }

        backBtn=findViewById(R.id.backBtn)
        backBtn.setOnClickListener{
            finish()
        }
    }


}