package com.example.fepper.DataClass

class varietyData(
    val header:List<Header>,
    val bestSeller:List<BestSeller>,
    val offersCombos:List<OffersCombos>
) {
    data class Header(
        val id:Int,
        val title:String,
        val imgUrl: String,
        val timer:String
    )
    data class BestSeller(
        val id: Int,
        val imgUrl:String,
        val name:String,
        val price:Int
    )
    data class OffersCombos(
        val id: Int,
        val foodTypeImgUrl:String,
        val name:String,
        val title:String,
        val price:Int
    )
}