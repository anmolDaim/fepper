package com.example.fepper.DataClass

data class CartData(
    val cartHeading:List<CartHeading>,
    val cartItem:List<CartItem>
) {
    data class CartHeading(
        val id:Int,
        val title:String,
        val imgUrl:String
    )
    data class CartItem(
        val id:Int,
        val itemName:String,
        val itemPrice:String
    )
}