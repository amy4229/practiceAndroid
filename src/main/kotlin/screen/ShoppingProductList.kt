package screen

import data.CartItems
import data.Product
import extension.getNotEmptyInt
import extension.getNotEmptyString

class ShoppingProductList {
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

    fun showCategoryProducts(selectedCategory: String){
        val categoryProducts = categries[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                -------------------------------------------
                선택하신 [$selectedCategory] 카테고리 상푸밉니다.
                ---------------------------------------------
            """.trimIndent())
            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            addCartItem(categoryProducts,selectedCategory)
        }else{
            showErrorMessage(selectedCategory)

        }
    }

    private fun addCartItem(categoryProducts: List<Product>, selectedCategory: String) {
        println("""
            ***************************************
            장바구니에 담을 상품 번호를 선택해 주세요 
            ***************************************
        """.trimIndent())

        val selectedProductNo = readLine()?.getNotEmptyInt()!!
        categoryProducts.getOrNull(selectedProductNo)?.let{
            product -> CartItems.addProduct(product)
            selectAfterAddCart(product,selectedCategory)
        } ?: run{
            println("존재하지 않는 상품번호입니다.")
            this.showCategoryProducts(selectedCategory)
        }
    }

    private fun selectAfterAddCart(product: Product,selectedCategory:String) {
        println("장바구니로 이동하시려면 #을 눌러주세요, 그렇지 않으면 *를 눌러주세요")
        val answer = readLine().getNotEmptyString()
        if (answer == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else if (answer == "*") {
            showCategoryProducts(selectedCategory)
        } else{
            println("잘못 누르셨습니다")
            selectAfterAddCart(product,selectedCategory)
        }
    }

    private fun showErrorMessage(selectedCategory: String) {
        println("선택하신 [$selectedCategory] 카테고리에는 등록된 상품이 존재하지 않습니다.")
    }
}