package app.model

import app.DeliveryType

data class FoodDetail(
    var foodName : String,
    var foodPrice : Int,
    )

data class OrderDetail(
    var orderType: DeliveryType
)

