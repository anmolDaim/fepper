package com.example.fepper.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.R

class bookingAdapter(val bookingArr:ArrayList<bookingDataClass>):RecyclerView.Adapter<bookingAdapter.ViewHolder>() {
    private var quantityChangeListener: OnQuantityChangeListener? = null

    fun setOnQuantityChangeListener(listener: OnQuantityChangeListener) {
        this.quantityChangeListener = listener
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cartName: TextView =itemView.findViewById(R.id.cartNameTextView)
        val cartPrice: TextView =itemView.findViewById(R.id.cartPriceTextView)
        val plusIcon:ImageView=itemView.findViewById(R.id.plusIcon)
        val deleteIcon:ImageView=itemView.findViewById(R.id.deleteIcon)
        val minusIcon:ImageView=itemView.findViewById(R.id.minusIcon)
        val quantityNum:TextView=itemView.findViewById(R.id.quantityNum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookingArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookingItem = bookingArr[position]
        holder.cartName.setText(bookingArr[position].cartName)
        holder.cartPrice.setText(bookingArr[position].cartPrice)
        holder.quantityNum.text = bookingItem.quantity.toString()

        val totalPrice = calculateTotalPrice(bookingItem.quantity, bookingItem.cartPrice).toString()
        Log.d("bookingAdapter", "Total Price: $totalPrice")
        holder.cartPrice.text = totalPrice

        if (bookingItem.quantity <= 0) {
            holder.minusIcon.visibility = View.GONE
            holder.deleteIcon.visibility = View.VISIBLE
        } else {
            holder.minusIcon.visibility = View.VISIBLE
            holder.deleteIcon.visibility = View.GONE
        }
        holder.plusIcon.setOnClickListener {
            increaseQuantity(position, holder)
            quantityChangeListener?.onQuantityChanged()
        }

        holder.minusIcon.setOnClickListener {
            decreaseQuantity(position, holder)
            quantityChangeListener?.onQuantityChanged()
        }
        holder.deleteIcon.setOnClickListener {
            deleteItem(position)
        }
    }
    private fun deleteItem(position: Int) {
        bookingArr.removeAt(position)
        notifyItemRemoved(position)
        if (bookingArr.isEmpty()) {
            quantityChangeListener?.onQuantityChanged()
        }
    }


    private fun decreaseQuantity(position: Int, holder: ViewHolder) {
        val bookingItem = bookingArr[position]
        if (bookingItem.quantity > 0) {
            bookingItem.quantity--
            holder.quantityNum.text = bookingItem.quantity.toString()
            // Notify the adapter that the item has changed
            notifyItemChanged(position)
        }
    }

    private fun increaseQuantity(position: Int, holder: ViewHolder) {
        val bookingItem = bookingArr[position]
        bookingItem.quantity++
        holder.quantityNum.text = bookingItem.quantity.toString()
        // Notify the adapter that the item has changed
        notifyItemChanged(position)
    }
    private fun calculateTotalPrice(quantity: Int, unitPrice: String): Double {
        val pricePerUnit = unitPrice.toDouble()
        return quantity * pricePerUnit
    }
    interface OnQuantityChangeListener {

        fun onQuantityChanged()
    }


}