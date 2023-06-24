fun main() {

    println(text)
    print(amountFee(10_000, 75_000, "Maestro"))
    print(" ������ �������� ��������")
}
val errorDay = -1 // ����� � ����
val errorMon = -2 // ����� � �����
val text = "���������� ������� ��������"
fun amountFee(
    amount: Int,
    amountMonth: Int = 0,
    tCards: String = "VK Pay"
): Int = when {
    tCards == "VK Pay" && amount > 15_000 -> errorDay // ������� ������� �� ��� � ������
    tCards == "VK Pay" && amountMonth > (40_000 - amount) -> errorMon
    tCards != "VK Pay" && amount > 150_000 -> errorDay
    tCards != "VK Pay" && amountMonth > (600_000 - amount) -> errorMon
    else -> when { // ����� ��� ��������� �� ����������, ���� � �������
        (tCards == "Mastercard" || tCards == "Maestro") && amountMonth > (75000 - amount) -> amount * 6 / 10 / 100 + 20
        (tCards == "Visa" || tCards == "���") && (amount * 75 / 100 / 100) >= 35 -> amount * 75 / 100 / 100
        (tCards == "Visa" || tCards == "���") && (amount * 75 / 100 / 100) <= 35 -> 35
        else -> 0
    }
}