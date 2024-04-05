package com.example.fepper

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.adapter.bookingAdapter

class CartFragment : Fragment(), bookingAdapter.OnQuantityChangeListener  {
    lateinit var cartRecyclerView: RecyclerView
    lateinit var cartTitle: TextView
    lateinit var cartText: TextView
    lateinit var cartBtn: AppCompatButton
    lateinit var cartImage: ImageView
    private val addedProducts = ArrayList<bookingDataClass>()
    lateinit var nestedScrollView: NestedScrollView
    lateinit var visibiltyBtn: ConstraintLayout
    lateinit var varietyImageView: ImageView
    lateinit var varietyTextView: TextView
    lateinit var checkoutBtn: AppCompatButton
    lateinit var itemTotal: TextView
    lateinit var clearCartBtn:TextView
    lateinit var anyRupees:ConstraintLayout
    lateinit var otherTip:ConstraintLayout
    lateinit var tenReupees:ConstraintLayout
    lateinit var twentyReupees:ConstraintLayout
    lateinit var thirtyReupees:ConstraintLayout
    lateinit var fortyReupees:ConstraintLayout
    lateinit var deliveryTip:TextView
    lateinit var tipPrice:TextView
    lateinit var tipAmt:EditText
    lateinit var buyPrice:TextView

    companion object {
        fun newInstance(bookingItem: bookingDataClass): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            args.putSerializable("bookingItem", bookingItem)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView)
        cartBtn=view.findViewById(R.id.cartBtn)
        cartTitle=view.findViewById(R.id.cartTitle)
        cartText = view.findViewById(R.id.cartText)
        cartImage = view.findViewById(R.id.cartImage)
        nestedScrollView=view.findViewById(R.id.nestedScrollView)
        visibiltyBtn = view.findViewById(R.id.visibiltyBtn)
        varietyImageView = view.findViewById(R.id.varietyImageView)
        varietyTextView = view.findViewById(R.id.varietyTextView)
        checkoutBtn = view.findViewById(R.id.checkoutBtn)
        itemTotal=view.findViewById(R.id.itemTotal)
        clearCartBtn=view.findViewById(R.id.clearCartBtn)
        anyRupees=view.findViewById(R.id.anyRupees)
        otherTip=view.findViewById(R.id.otherTip)
        tenReupees=view.findViewById(R.id.tenRupees)
        twentyReupees=view.findViewById(R.id.twentyRupees)
        thirtyReupees=view.findViewById(R.id.thirtyRupees)
        fortyReupees=view.findViewById(R.id.fortyRupees)
        tipPrice=view.findViewById(R.id.tipPrice)
        deliveryTip=view.findViewById(R.id.deliveryTip)
        tipAmt=view.findViewById(R.id.tipAmt)
        buyPrice=view.findViewById(R.id.buyPrice)




        checkoutBtn.setOnClickListener {

           val intent=Intent(requireContext(),PaymentActivity::class.java)
//            if (addedProducts.isNotEmpty()) {
//                // Prepare data to be sent to PaymentActivity
//                val totalPrice = buyPrice.text.toString()
//                val Heading = varietyTextView.text.toString()
//
//
//                // Create an Intent to start PaymentActivity
//                val intent = Intent(requireContext(), PaymentActivity::class.java)
//                intent.putExtra("totalPrice", totalPrice)
//                intent.putExtra("Heading", Heading)
//
//                startActivity(intent)
//            } else {
//                Toast.makeText(requireContext(), "Your cart is empty", Toast.LENGTH_SHORT).show()
//            }
            startActivity(intent)
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getSerializable("bookingItem")?.let { bookingItem ->
            if (bookingItem is bookingDataClass) {
                addedProducts.add(bookingItem)
                varietyImageView.setImageResource(bookingItem.varietyImage ?: R.drawable.food1)
                varietyTextView.text = bookingItem.varietyName ?: ""
                //Log.d("CartFragment", "Items added: ${addedProducts.size}")
                val layoutManager = LinearLayoutManager(context)
                cartRecyclerView.layoutManager = layoutManager
                val adapter = bookingAdapter(addedProducts)
                cartRecyclerView.adapter = adapter
                updateVisibility()
                cartRecyclerView.adapter?.notifyDataSetChanged()
            }
        }
        clearCartBtn.setOnClickListener {
            clearCart()
        }
        anyRupees.setOnClickListener {
            TipVisibility()
        }
        tipAmt.setOnClickListener {
            val tipAmount = tipAmt.text.toString()
            showTipItem(tipAmount)
        }
        tenReupees.setOnClickListener {
            showTipItem("10")
        }

        twentyReupees.setOnClickListener {
            showTipItem("20")
        }

        thirtyReupees.setOnClickListener {
            showTipItem("30")
        }

        fortyReupees.setOnClickListener {
            showTipItem("40")
        }
        cartBtn.setOnClickListener {
            val fragment = HomeFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
        updateVisibility()

        (cartRecyclerView.adapter as? bookingAdapter)?.setOnQuantityChangeListener(this)

    }
    private fun showTipItem(tipAmount: String) {
        deliveryTip.visibility = View.VISIBLE
        tipPrice.visibility=View.VISIBLE
        otherTip.visibility=View.GONE
        tipPrice.text = tipAmount
        updateBuyPrice()
    }

    private fun TipVisibility(){
        otherTip.visibility=View.VISIBLE
    }
    private fun clearCart() {
        addedProducts.clear()
        updateVisibility()
        cartRecyclerView.adapter?.notifyDataSetChanged()
    }
    override fun onQuantityChanged() {
        Log.d("CartFragment", "Quantity changed, updating total price")
        updateTotalPrice()
        updateBuyPrice()
        updateVisibility()
    }
    private fun updateBuyPrice() {
        val itemTotalPrice = itemTotal.text.toString().toDoubleOrNull() ?: 0.0
        val tipAmount = tipPrice.text.toString().toDoubleOrNull() ?: 0.0
        val fixedAmount = 24.0
        val buyPriceValue = itemTotalPrice + tipAmount + fixedAmount
        buyPrice.text = buyPriceValue.toString()
    }

    private fun updateTotalPrice() {
        var totalPrice = 0.0
        addedProducts.forEach { product ->
            val pricePerUnit = product.cartPrice.toDoubleOrNull() ?: 0.0
            totalPrice += pricePerUnit * product.quantity
        }
        itemTotal.text = totalPrice.toString()
    }

    private fun updateVisibility() {
        if (addedProducts.isEmpty()) {
            cartImage.visibility = View.VISIBLE
            cartText.visibility = View.VISIBLE
            cartTitle.visibility = View.VISIBLE
            cartBtn.visibility = View.VISIBLE
            nestedScrollView.visibility = View.GONE
            visibiltyBtn.visibility=View.GONE

        } else {
            cartImage.visibility = View.GONE
            cartText.visibility = View.GONE
            cartTitle.visibility = View.GONE
            cartBtn.visibility = View.GONE
            nestedScrollView.visibility = View.VISIBLE
            visibiltyBtn.visibility=View.VISIBLE

            cartRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

}