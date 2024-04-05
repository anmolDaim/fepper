package com.example.fepper.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bannerDataClass
import com.example.fepper.R
import com.example.fepper.VaritiesActivity

class bannerAdapter(private val context: Context, val bannerArr:ArrayList<bannerDataClass>): RecyclerView.Adapter<bannerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val bannerImageView: ImageView =itemView.findViewById(R.id.bannerImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.banner_category,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bannerArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bannerArr[position]
        holder.bannerImageView.setImageResource(bannerArr[position].bannerImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, VaritiesActivity::class.java)
            // Pass item data as extras
            intent.putExtra("ItemImage", item.bannerImage)
            intent.putExtra("ItemName", item.bannerName)
            context.startActivity(intent)
//            (context as AppCompatActivity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }
}