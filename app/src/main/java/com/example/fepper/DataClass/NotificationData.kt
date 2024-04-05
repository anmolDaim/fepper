package com.example.fepper.DataClass

data class NotificationData(
    val notification:List<Notification>
) {
    data class Notification(
        val id:Int,
        val imgUrl:String,
        val heading:String,
        val title:String,
        val path:String
    )
}