package screen

import constant.LINE_DIVIDER
import data.CartItems
import data.Product
import extension.getNotEmptyInt
import extension.getNotEmptyString

class ShoppingProductList(private val selectedCategory: String):Screen() {
    private val products = arrayOf(
        Product("패션","겨울패딩")
        ,Product("패션","겨울바지")
        ,Product("패션","여름바지")
        ,Product("전자기기","갤럭시")
        ,Product("전자기기","아이폰")
        ,Product("전자기기","아이패드")
        ,Product("전자기기","갤탭")
        ,Product("식음료","커피")
        ,Product("식음료","우유")
    )

    private val categries:Map<String, List<Product>> = products.groupBy { product -> product.categoryLabel }

    fun showCategoryProducts(){
        ScreenHistory.push(this)
        val categoryProducts = categries[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
                $LINE_DIVIDER
            """.trimIndent())
            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            addCartItem(categoryProducts)
        }else{
            showErrorMessage()

        }
    }

    private fun addCartItem(categoryProducts: List<Product>) {
        println("""
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해 주세요 
            $LINE_DIVIDER
        """.trimIndent())

        val selectedProductNo = readLine()?.getNotEmptyInt()!!
        categoryProducts.getOrNull(selectedProductNo)?.let{
            product -> CartItems.addProduct(product)
            selectAfterAddCart(product)
        } ?: run{
            println("존재하지 않는 상품번호입니다.")
            this.showCategoryProducts()
        }
    }

    private fun selectAfterAddCart(product: Product) {
        println("장바구니로 이동하시려면 #을 눌러주세요, 그렇지 않으면 *를 눌러주세요")
        val answer = readLine().getNotEmptyString()
        if (answer == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else if (answer == "*") {
            showCategoryProducts()
        } else{
            println("잘못 누르셨습니다")
            selectAfterAddCart(product)
        }
    }

    private fun showErrorMessage() {
        println("선택하신 [$selectedCategory] 카테고리에는 등록된 상품이 존재하지 않습니다.")
    }
}