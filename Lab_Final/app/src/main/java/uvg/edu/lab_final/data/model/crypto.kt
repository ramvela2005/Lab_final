package uvg.edu.lab_final.data.model

data class Crypto(
    val id: String,
    val name: String,
    val symbol: String,
    val price: String
)
object FakeCrypto {
    val cryptoList = listOf(
        Crypto(id = "1", name = "Bitcoin", symbol = "BTC", price = "50000"),
        Crypto(id = "2", name = "Ethereum", symbol = "ETH", price = "3000"),
        Crypto(id = "3", name = "Cardano", symbol = "ADA", price = "2")
    )
}