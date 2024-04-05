package com.example.fepper

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fepper.DataClass.bannerDataClass

import com.example.fepper.DataClass.categoryDataClass
import com.example.fepper.DataClass.shpesDataClass
import com.example.fepper.adapter.bannerAdapter
import com.example.fepper.adapter.categoryAdapter
import com.example.fepper.adapter.shopesAdapter


class HomeFragment : Fragment() {
    lateinit var categoryRecyclerView: RecyclerView
    lateinit var bannerRecyclerView: RecyclerView
    lateinit var shopesRecyclerView: RecyclerView
    lateinit var searchBtn: ConstraintLayout
    lateinit var locationTextView:TextView
    lateinit var imageSlider:ImageSlider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView)
        bannerRecyclerView=view.findViewById(R.id.bannerRecycerView)
        shopesRecyclerView=view.findViewById(R.id.shopesRecyclerView)
        locationTextView=view.findViewById(R.id.locationTextView)
        imageSlider=view.findViewById(R.id.imageSlider)
        val sliderArr=ArrayList<SlideModel>()
        sliderArr.add(SlideModel(R.drawable.food3,ScaleTypes.CENTER_CROP))
        sliderArr.add(SlideModel(R.drawable.food2,ScaleTypes.CENTER_CROP))
        sliderArr.add(SlideModel(R.drawable.food5,ScaleTypes.CENTER_CROP))
        sliderArr.add(SlideModel(R.drawable.food7,ScaleTypes.CENTER_CROP))
        imageSlider.setImageList(sliderArr,ScaleTypes.CENTER_CROP)

        searchBtn=view.findViewById(R.id.searchBtn)

        searchBtn.setOnClickListener {
            val intent=Intent(requireContext(),SearchActivity::class.java)
            startActivity(intent)
        }


        locationTextView.setOnClickListener{
            val intent=Intent(requireContext(),AddressActivity::class.java)
            startActivity(intent)
        }


        // Set up click listener for locationTextView
        locationTextView.setOnClickListener {
            val intent = Intent(requireContext(), AddressActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


// Create sample data

        val arr = ArrayList<categoryDataClass>()
        arr.add(categoryDataClass("Offer",R.drawable.category1 ))
        arr.add(categoryDataClass("Grill",R.drawable.category1 ))
        arr.add(categoryDataClass("Biryani",R.drawable.category1))
        arr.add(categoryDataClass("Noodle",R.drawable.category1))
        arr.add(categoryDataClass("Pizza",R.drawable.category1))
        arr.add(categoryDataClass("Maggie",R.drawable.category1))

        // Set up RecyclerView
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = layoutManager
        val adapter = categoryAdapter(requireContext(),arr)
        categoryRecyclerView.adapter = adapter



        //Banner images
        val bannerArr=ArrayList<bannerDataClass>()
        bannerArr.add(bannerDataClass(R.drawable.food1,"banner1"))
        bannerArr.add(bannerDataClass(R.drawable.food2,"banner2"))
        bannerArr.add(bannerDataClass(R.drawable.food3,"banner3"))
        bannerArr.add(bannerDataClass(R.drawable.food4,"banner4"))
        bannerArr.add(bannerDataClass(R.drawable.food5,"banner5"))
        val bannerLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        bannerRecyclerView.layoutManager = bannerLayoutManager
        val BannerAdater = bannerAdapter(requireContext(),bannerArr)
        bannerRecyclerView.adapter = BannerAdater

        //shope category
        val shopeArr=ArrayList<shpesDataClass>()
        shopeArr.add(shpesDataClass("Restaurent",R.drawable.grey_restaurent))
                shopeArr.add(shpesDataClass("Bakes",R.drawable.grey_bakes))
                shopeArr.add(shpesDataClass("Pure Veg",R.drawable.grey_pureveg))
                shopeArr.add(shpesDataClass("Ice Cream",R.drawable.grey_icecream))
                shopeArr.add(shpesDataClass("HomeChef",R.drawable.grey_chef))


        val shopeLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        shopesRecyclerView.layoutManager = shopeLayoutManager

// Display initial fragment or perform initial action
        childFragmentManager.beginTransaction().replace(
            R.id.shopesContainer,
            NearbyFragment()
        ).commit()
        // Initialize RecyclerView adapter
        val shopeAdapter = shopesAdapter(shopeArr) { shope,itemView ->

            val fragment = when (shope.shopeName) {
                "Restaurent" -> RestaurentFragment()
                "Bakes" -> BakesFragment()
                "Pure Veg"-> PureVegFregment()
                "Ice Cream"-> IceCreamFragment()
                "HomeChef"-> HomeChefFragment()
                else -> NearbyFragment()
            }

            childFragmentManager.beginTransaction()
                .replace(R.id.shopesContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
        shopesRecyclerView.adapter = shopeAdapter


    }
}