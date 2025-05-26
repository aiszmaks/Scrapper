
import org.jsoup.Jsoup

fun main() {
    val url = "https://www.douglas.pl/pl/c/perfumy/perfumy-meskie/perfumy/010205"

        try {
            val document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36")
                .header(
                    "Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
                )
                .header("Accept-Language", "pl-PL,pl;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cookie", "")
                .get()

            val product = document.select("div.product-tile")
                .first { it.select("div.text.brand-line").text() == "Emporio Armani" }

            // Zbieranie danych
            val brand = product.select("div.text.top-brand").text()  // Marka
            val brandLine = product.select("div.text.brand-line").text()  // Marka (Emporio Armani)
            val productName = product.select("div.text.name").text()  // Nazwa produktu
            val category = product.select("div.text.category").text()  // Kategoria
            val price = product.select("span.product-price__price").first()?.text()
            val reducePrice = product.select("span.product-price__price")[1]?.text()

            // Wyświetlanie zebranych danych
            println("Marka: $brand")
            println("Marka (Emporio Armani): $brandLine")
            println("Nazwa produktu: $productName")
            println("Kategoria: $category")
            println("Cena detaliczna: $price")
            println("Cena po rabacie: $reducePrice")

            val product2 = document.select("div.product-tile")
                .first { it.select("div.text.brand-line").text() == "Invictus" }

            val brand2 = product2.select("div.text.top-brand").text()  // Marka
            val brandLine2 = product2.select("div.text.brand-line").text()  // Marka (Emporio Armani)
            val productName2 = product2.select("div.text.name").text()  // Nazwa produktu
            val category2 = product2.select("div.text.category").text()  // Kategoria
            val price2 = product2.select("span.product-price__price").first()?.text()
            val reducePrice2 = product2.select("span.product-price__price")[1]?.text()

            println("Marka: $brand2")
            println("Marka (Emporio Armani): $brandLine2")
            println("Nazwa produktu: $productName2")
            println("Kategoria: $category2")
            println("Cena detaliczna: $price2")
            println("Cena po rabacie: $reducePrice2")

        } catch (e: Exception) {
            println("Wystąpił błąd: ${e.message}")
        }
}
