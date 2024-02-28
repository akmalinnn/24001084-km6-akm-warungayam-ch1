package app.datasource
import app.model.FoodDetail


interface FoodData {
    fun getFoodList() : List<FoodDetail>
}

class FoodDataImpl() : FoodData{
    override fun getFoodList() : List<FoodDetail>{
        return listOf(
            FoodDetail(
                foodName = "Ayam Bakar",
                foodPrice = 50000,
            ),
            FoodDetail(
                foodName = "Ayam Goreng",
                foodPrice = 40000,
            ),
            FoodDetail(
                foodName = "Ayam Geprek",
                foodPrice = 40000,
            ),
            FoodDetail(
                foodName = "Kulit Ayam Crispy",
                foodPrice = 15000,
            ),
            FoodDetail(
                foodName = "Sate Usus Ayam",
                foodPrice = 5000,
            ),
        )
    }
}