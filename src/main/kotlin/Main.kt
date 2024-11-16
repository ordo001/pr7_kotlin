import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val pizzaPeter =  PizzaPeter(
        neapolitanPizzaPrice = 175.0, romanPizzaPrice = 241.5,
        sicilianPizzaPrice = 167.5, tyroleanPizzaPrice = 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        neapolitanPizzaPrice = 215.0, romanPizzaPrice = 250.5,
        sicilianPizzaPrice = 180.5, tyroleanPizzaPrice = 240.0
    )
    var currentPizzaCity:PizzaCity
    while(true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "0" -> break
            else -> {
                println("ERROR")
                exitProcess(1)
            }
        }
        println("Выберите пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Показать статистику")
        val pizza = readln()
        when (pizza) {
            "1" -> {
                currentPizzaCity.neapolitanPizzaSale()
            }
            "2" -> currentPizzaCity.romanPizzaSale()
            "3" -> currentPizzaCity.sicilianPizzaSale()
            "4" -> currentPizzaCity.tyroleanPizzaSale()
            "0" -> currentPizzaCity.showStatustics()
            else -> {
                println("ERROR")
                exitProcess(1)
            }
        }
        when (currentPizzaCity) {
            is CheckPhoto -> currentPizzaCity.showCheckPhoto()
            is Drink -> currentPizzaCity.drinkSale()
        }
    }
}