package com.example.fepper.adapter


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.DataClass.combosDataClass
import com.example.fepper.MainActivity
import com.example.fepper.R

class comboAdapter(var comboArr:ArrayList<combosDataClass>,private val addToCartClickListener: OnAddToCartClickListener):RecyclerView.Adapter<comboAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var headCombo:TextView=itemView.findViewById(R.id.headCombo)
        var titleCombo:TextView=itemView.findViewById(R.id.titleCombo)
        var priceCombo:TextView=itemView.findViewById(R.id.priceCombo)
        var vegCombo:ImageView=itemView.findViewById(R.id.vegCombo)
        var addToCartBtn: AppCompatButton = itemView.findViewById(R.id.comboAddToCartBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.combos_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return comboArr.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = comboArr[position]
holder.headCombo.setText(comboArr[position].head)
        holder.titleCombo.setText(comboArr[position].title)
        holder.priceCombo.setText(comboArr[position].price)
        holder.vegCombo.setImageResource(comboArr[position].image)
        holder.addToCartBtn.setOnClickListener {

            val itemName = currentItem.head
            val itemPrice = currentItem.price
            addToCartClickListener.onAddToCartClicked(itemName, itemPrice)
        }
    }
    interface OnAddToCartClickListener {
        fun onAddToCartClicked(itemName: String, itemPrice: String)
    }


}