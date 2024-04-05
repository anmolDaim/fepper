package com.example.fepper.DataClass

data class HomeData(
    val categoryList:List<Category>,
    val sliderList:List<Slider>,
    val bannerList:List<Banner>,
    val shopes:List<Shope>,
    val FoodList:List<Food>,

) {
    data class Category(
        val id:Int,
        val title:String,
        val imgUrl:String
    )
    data class Slider(val id:Int,val imgUrl: String){
    }
    data class Banner(val id:Int,val imgUrl: String){
    }
    data class Shope(val id:Int,val imgUrl: String,val title: String){
    }
    data class Food(val id:Int,val imgUrl: String,val title: String,val rank:String){
    }
}