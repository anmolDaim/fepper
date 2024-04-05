package com.example.fepper

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.fepper.DataClass.bestSellerDataClass
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.DataClass.combosDataClass
import com.example.fepper.adapter.BestSellerAdapter
import com.example.fepper.adapter.bookingAdapter
import com.example.fepper.adapter.comboAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class VaritiesActivity : AppCompatActivity(), comboAdapter.OnAddToCartClickListener{
    lateinit var varietyImage:ImageView
    lateinit var varietyName:TextView
    lateinit var varitiesRecyclerView:RecyclerView
    lateinit var comboRecyclerView:RecyclerView
    lateinit var moreButton:ImageView
    lateinit var viewLessButton:ImageView
    lateinit var backBtn:FloatingActionButton
    lateinit var bottomDialogPrice: TextView
    lateinit var bottomDialogAddToCart: TextView

    private var varietyNameValue: String? = ""
    private var itemImageValue: Int? = -1
    lateinit var bottomFloatingBoxLayout: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        setContentView(R.layout.activity_varities)
        varietyImage=findViewById(R.id.varietyImage)
        varietyName=findViewById(R.id.varietyName)
        moreButton=findViewById(R.id.moreButton)
        viewLessButton=findViewById(R.id.viewLessButton)
        varitiesRecyclerView=findViewById(R.id.varitiesRecyclerView)
        comboRecyclerView=findViewById(R.id.comboRecyclerView)
        bottomDialogPrice = findViewById(R.id.bottomDialogPrice)
        bottomDialogAddToCart = findViewById(R.id.bottomDialogAddToCart)

        bottomFloatingBoxLayout = findViewById(R.id.bottomFloatingBoxLayout)

        backBtn=findViewById(R.id.backBtn)
        backBtn.setOnClickListener{
            finish()
        }

        val itemImage = intent.getIntExtra("ItemImage", R.drawable.food1)
        val itemName = intent.getStringExtra("ItemName")
        varietyImage.setImageResource(itemImage)
        varietyName.text = itemName
        // Properties for varietyName and itemImage
        varietyNameValue = itemName
        itemImageValue = itemImage

        setupRecyclerViewWithLimitedItems()

        // Set up click listener for the "More" button
        moreButton.setOnClickListener {
            expandRecyclerView()
        }

        viewLessButton.setOnClickListener {
            collapseRecyclerView()
        }

        var comboArr=ArrayList<combosDataClass>()
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.nonveg_icon))
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.nonveg_icon))
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.nonveg_icon))
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.veg_icon))
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.veg_icon))
        comboArr.add(combosDataClass("Pocket Saver Combo","Afgan+Chicken chilli +Chicken Tikka","200",R.drawable.veg_icon))
        val layoutManger=LinearLayoutManager(this)
        comboRecyclerView.layoutManager=layoutManger
        val adapter =comboAdapter(comboArr,this)
        comboRecyclerView.adapter = adapter


    }
    private fun setupRecyclerViewWithLimitedItems() {
        // Initialize RecyclerView with limited items
        val bestSellerArr=ArrayList<bestSellerDataClass>()
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food1,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food3,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        val layoutManager = GridLayoutManager(this, 2)
        varitiesRecyclerView.layoutManager = layoutManager
        val adapter = BestSellerAdapter(this,bestSellerArr)
        varitiesRecyclerView.adapter = adapter

        moreButton.visibility = View.VISIBLE
        viewLessButton.visibility = View.GONE
    }
    private fun collapseRecyclerView() {
        // Collapse RecyclerView to show only two rows
        val bestSellerArr=ArrayList<bestSellerDataClass>()
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food1,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food3,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        val layoutManager = GridLayoutManager(this, 2)
        varitiesRecyclerView.layoutManager = layoutManager
        val adapter = BestSellerAdapter(this,bestSellerArr) // Adjust according to how many items you want to show
        varitiesRecyclerView.adapter = adapter
        varitiesRecyclerView.layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT
        // Hide the "View Less" button and show the "More" button
        moreButton.visibility = View.VISIBLE
        viewLessButton.visibility = View.GONE
    }

    private fun expandRecyclerView() {
        // Expand RecyclerView to show all items
        val bestSellerArr=ArrayList<bestSellerDataClass>()
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food1,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food3,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food2,"malai chaap","200"))
        bestSellerArr.add(bestSellerDataClass(R.drawable.veg_icon,R.drawable.food3,"malai chaap","200"))
        val layoutManager = GridLayoutManager(this, 2)
        varitiesRecyclerView.layoutManager = layoutManager
        val adapter = BestSellerAdapter(this,bestSellerArr)
        varitiesRecyclerView.adapter = adapter
        varitiesRecyclerView.layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT
        // Hide the "More" button
        moreButton.visibility = View.GONE
        viewLessButton.visibility=View.VISIBLE
    }
    fun onItemClick(item: bestSellerDataClass) {
        // Show the bottom sheet with the clicked item's data
        showBottomSheet(item)
    }
    override fun onAddToCartClicked(itemName: String, itemPrice: String) {
        // Handle opening the bottomFloatingBoxLayout here
        bottomDialogPrice.text = "$itemPrice"
        bottomFloatingBoxLayout.visibility = View.VISIBLE
        val bookingItem = bookingDataClass(itemName, itemPrice, varietyNameValue, itemImageValue)
        bottomDialogAddToCart.setOnClickListener {
            // Handle moving to the cart fragment here
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("bookingItem", bookingItem)
            startActivity(intent)
        }
    }

    private fun showBottomSheet(item: bestSellerDataClass) {
        val view = layoutInflater.inflate(R.layout.best_seller_bottom_sheet_layout, null)

        // Populate views with item data
        val itemNameTextView = view.findViewById<TextView>(R.id.bestNameTextView)
        val itemPriceTextView = view.findViewById<TextView>(R.id.bestPriceTextView)
        val itemImageView = view.findViewById<ImageView>(R.id.bestImageView)
        val vegImageView = view.findViewById<ImageView>(R.id.vegImageView)
        val cancelbtn = view.findViewById<ImageView>(R.id.cancelBtn)
        val addToCartBtn = view.findViewById<AppCompatButton>(R.id.AddToCartBtn)



        itemNameTextView.text = item.bestName
        itemPriceTextView.text = item.bestPrice
        itemImageView.setImageResource(item.bestImage)
        vegImageView.setImageResource(item.vegImage)

        // Create and show bottom sheet
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()
        cancelbtn.setOnClickListener{
            dialog.dismiss()
        }
        addToCartBtn.setOnClickListener {
            val itemName = itemNameTextView.text.toString()
            val itemPrice = itemPriceTextView.text.toString()

            val bookingItem = bookingDataClass(itemName, itemPrice, varietyNameValue, itemImageValue)

            if (bookingItem != null) {
                val bundle = Bundle()
                bundle.putSerializable("bookingItem", bookingItem)
                // Set price in the bottom floating box
                bottomDialogPrice.text =  "$itemPrice"

                // Show bottom floating box
                bottomFloatingBoxLayout.visibility = View.VISIBLE

                bottomDialogAddToCart.setOnClickListener {
                    if (bookingItem != null) {
                        val itemName = itemNameTextView.text.toString()
                        val itemPrice = itemPriceTextView.text.toString()
                        val bookingItem = bookingDataClass(itemName, itemPrice,varietyNameValue, itemImageValue)
                        val intent = Intent(this@VaritiesActivity, MainActivity::class.java)
                        intent.putExtra("bookingItem", bookingItem)
                        intent.putExtra("changeIconColor", true)
                        startActivity(intent)
                    }
                }
            }
        }
    }




}