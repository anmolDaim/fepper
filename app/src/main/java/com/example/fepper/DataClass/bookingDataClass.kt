package com.example.fepper.DataClass

import java.io.Serializable

class bookingDataClass(
    var cartName:String,
    var cartPrice:String,
    val varietyName: String?=null,
    val varietyImage: Int?=null,
    var quantity: Int=1
): Serializable {
}