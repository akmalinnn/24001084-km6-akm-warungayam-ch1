package app

import app.datasource.FoodDataImpl
import app.model.FoodDetail
import app.model.OrderDetail
import app.utils.IOUtils


class App {

    fun run() {
        OrderFood().let {
            it.printMenu()
            it.getSelectedFood()
            it.calculatedOrder()
            it.kindOfOrder()
            it.getSelectedOrderType()
            it.orderTimeProcess()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}

interface Order {
    fun printMenu()
}

class OrderFood : Order {

    private var foodData = FoodDataImpl().getFoodList()
    private var selectFood: FoodDetail? = null
    private var selectOrderType: OrderDetail? = null

    private val orderData = listOf(

        OrderDetail(
            orderType = "Take Away"
        ),
        OrderDetail(
            orderType = "Delivery"
        )
    )

    //show menu
    override fun printMenu() {
        println("===========================")
        println("Selamat Datang di Aplikasi Pemesanan Makanan!")
        println("===========================")
        println("Pilih Makanan")
        foodData.forEachIndexed { index, data ->
            println("${index + 1}.${data.foodName} : Rp ${data.foodPrice},-/porsi")
        }
        println("============================")
    }

    //select food
    fun getSelectedFood() {
        println("Pilih Makanan Anda: ")
        val selectedIndex = IOUtils.getInputInteger()
        selectedIndex?.let {
            if (selectedIndex in 1..foodData.size) {
                selectFood = foodData[selectedIndex - 1]
                println("Kamu memilih : ${selectFood!!.foodName} ")
                println("Harga : Rp ${selectFood!!.foodPrice} ")
            } else {
                println("Pilihan anda salah, Silahkan coba lagi")
                getSelectedFood()
            }
        } ?: run {
            println("Input Anda salah ! coba lagi")
            getSelectedFood()
        }
    }


    //payment condition
    fun calculatedOrder() {
        println("============================")
        println("Masukkan Pembayaran")
        val yourMoney = readln().toInt()
        return if (yourMoney < selectFood!!.foodPrice) {
            println("Maaf, pembayaran Anda gagal!")
            calculatedOrder()
        } else if (yourMoney > selectFood!!.foodPrice) {
            println("Terima kasih, Anda berhasil memesan makanan")
        } else {
            println("Terima kasih, Anda berhasil memesan makanan")
        }
    }

    //show order type
    fun kindOfOrder() {
        println("Pilih Metode Pengiriman: ")
        orderData.forEachIndexed { index, data ->
            println("${index + 1}.${data.orderType}")
        }
    }

    //select order type
    fun getSelectedOrderType() {
        println("Pilih Metode Pengirman Makanan")
        val selectedIndex = IOUtils.getInputInteger()
        selectedIndex?.let {
            if (selectedIndex in 1..orderData.size) {
                selectOrderType = orderData[selectedIndex - 1]
                println("Kamu memilih : ${selectOrderType!!.orderType} ")
            } else {
                println("Pilihan anda salah, Silahkan coba lagi")
                getSelectedOrderType()
            }
        } ?: run {
            println("Input Anda salah ! coba lagi")
            getSelectedOrderType()
        }
    }

    //Display Result order type
    fun orderTimeProcess() {
        if (selectOrderType!!.orderType == "Take Away") {
            println("Makananmu sedang dimasak")
            Thread.sleep(5000)
            println("Makananmu sudah siap! Silakan ambil di resto ya!")
            Thread.sleep(5000)
            println("pesanan selesai")
            Thread.sleep(3000)
        } else {
            println("Makananmu sedang dimasak")
            Thread.sleep(5000)
            println("Makananmu sudah siap! Driver segera menuju tempatmu!")
            Thread.sleep(5000)
            println("Driver sampai! Pesanan selesai!")
            Thread.sleep(3000)
        }
    }

}



