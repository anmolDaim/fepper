package com.example.fepper.DataClass

data class ProfileEditData(
    val editDetails:List<EditDetails>,
) {
    data class EditDetails(
        val username:String,
        val email:String,
        val mobileNum:Int
    )
}