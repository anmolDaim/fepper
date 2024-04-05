package com.example.fepper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.adapter.comboAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomNavigationView=findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener ( navListener )

        // Display initial fragment or perform initial action
        supportFragmentManager.beginTransaction().replace(
            R.id.container,
            HomeFragment()
        ).commit()
        // Check if there is data passed from VaritiesActivity
        val bookingItem = intent.getSerializableExtra("bookingItem") as? bookingDataClass
        val changeIconColor = intent.getBooleanExtra("changeIconColor", false)
        if (bookingItem != null) {
            // Handle the booking item data
            // For example, you can pass it to the cart fragment
            val cartFragment = CartFragment.newInstance(bookingItem)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, cartFragment)
                .addToBackStack(null)
                .commit()
            if (changeIconColor) {
                bottomNavigationView.menu.findItem(R.id.navigation_cart)?.setIcon(R.drawable.cart_icon_green)
            }
        }

    }
    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> selectedFragment = HomeFragment()
            R.id.navigation_booking -> selectedFragment = BookingFragment()
            R.id.navigation_cart -> selectedFragment = CartFragment()
            R.id.navigation_notification -> selectedFragment = NotificationFragment()
            R.id.navigation_profile -> selectedFragment = ProfileFragment()
        }
        // Replace the current fragment with the selected one
        if (selectedFragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment)
                .commit()
            return@OnNavigationItemSelectedListener true
        }
        false
    }




}