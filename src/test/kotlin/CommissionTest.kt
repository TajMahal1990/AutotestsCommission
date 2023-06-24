import org.junit.Test
import kotlin.test.assertEquals

class CommissionTest {

    @Test
    fun VKPayCommissionErrorDay() {
        val amount = 16_000
        val amountMonth = 10_000
        val tCard = "VK Pay"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-1, result)
    }

    @Test
    fun VKPayCommissionErrorMon() {
        val amount = 16_000
        val amountMonth = 80_000
        val tCard = "VK Pay"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-1, result)
    }

    @Test
    fun VKPayCommissionErrorMon_Nom() {
        val amount = 1_000
        val amountMonth = 1_000
        val tCard = "VK Pay"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(0, result)
    }

    @Test
    fun MasterCardPayCommission() {
        val amount = 80_000
        val amountMonth = 5_000
        val tCard = "Mastercard"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(500, result)
    }

    @Test
    fun MaestroPayCommission() {
        val amount = 80_000
        val amountMonth = 5_000
        val tCard = "Maestro"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(500, result)
    }

    @Test
    fun VizaPayCommission() {
        val amount = 80_000
        val amountMonth = 5_000
        val tCard = "Visa"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(600, result)
    }

    @Test
    fun MIPPayCommission() {
        val amount = 80_000
        val amountMonth = 5_000
        val tCard = "Ã»–"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(600, result)
    }

    @Test
    fun VisaPayCommission_MinCom() {
        val amount = 2_500
        val amountMonth = 100
        val tCard = "Visa"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(35, result)
    }

    @Test
    fun MIPPayCommission_MinCom() {
        val amount = 2_500
        val amountMonth = 100
        val tCard = "Ã»–"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(35, result)
    }


 //   @Test
  //  fun OtherCasesCommission() {
    //    val amount = 80_000
  //      val amountMonth = 5_000
   //     val tCard = "ALI PAY"
    //val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)
//
//        assertEquals(0, result)
    //}

    @Test
    fun ErrorMon() {
        val amount = 300_000
        val amountMonth = 0
        val tCard = "Mastercard"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-1, result)
    }
     @Test
    fun ErrorMonVisa() {
        val amount = 300_000
        val amountMonth = 0
        val tCard = "Visa"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-1, result)
    }

    @Test
    fun ErrorMonS() {
        val amount = 1000
        val amountMonth = 750_000
        val tCard = "Mastercard"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-2, result)
    }
    @Test
    fun ErrorMonD() {
        val amount = 1000
        val amountMonth = 750_000
        val tCard = "Visa"

        val result = amountFee(amount = amount, amountMonth = amountMonth, tCards = tCard)

        assertEquals(-2, result)
    }

}