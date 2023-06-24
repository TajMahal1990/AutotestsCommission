fun main() {

    println(text)
    print(amountFee(10_000, 75_000, "Maestro"))
    print(" рублей составит коммисия")
}
val errorDay = -1 // Лимит в день
val errorMon = -2 // Лимит в месяц
val text = "Приложение подчета коммисии"
fun amountFee(
    amount: Int,
    amountMonth: Int = 0,
    tCards: String = "VK Pay"
): Int = when {
    tCards == "VK Pay" && amount > 15_000 -> errorDay // Сначала считает вк пэй в лимите
    tCards == "VK Pay" && amountMonth > (40_000 - amount) -> errorMon
    tCards != "VK Pay" && amount > 150_000 -> errorDay
    tCards != "VK Pay" && amountMonth > (600_000 - amount) -> errorMon
    else -> when { // потом уже переходим на мастеркард, визу и маэстро
        (tCards == "Mastercard" || tCards == "Maestro") && amountMonth > (75000 - amount) -> amount * 6 / 10 / 100 + 20
        (tCards == "Visa" || tCards == "МИР") && (amount * 75 / 100 / 100) >= 35 -> amount * 75 / 100 / 100
        (tCards == "Visa" || tCards == "МИР") && (amount * 75 / 100 / 100) <= 35 -> 35
        else -> 0
    }
}