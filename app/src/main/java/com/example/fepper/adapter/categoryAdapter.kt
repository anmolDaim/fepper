package com.example.fepper.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.categoryDataClass
import com.example.fepper.R
import com.example.fepper.VaritiesActivity

class categoryAdapter(private val context: Context, val categoryList:ArrayList<categoryDataClass>): RecyclerView.Adapter<categoryAdapter.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

        val categoryNameTextView:TextView=itemView.findViewById(R.id.categorieName)
        val categoryImageView:ImageView=itemView.findViewById(R.id.categoryImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.categories_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categoryList[position]

       holder.categoryNameTextView.setText(categoryList[position].catName)
        holder.categoryImageView.setImageResource(categoryList[position].catImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, VaritiesActivity::class.java)
            // Pass item data as extras
            intent.putExtra("ItemImage", item.catImage)
            intent.putExtra("ItemName", item.catName)
            context.startActivity(intent)
//            (context as AppCompatActivity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}