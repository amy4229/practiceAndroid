package screen

import constant.LINE_DIVIDER
import data.CartItems
import extension.getNotEmptyString

class ShoppingCart :Screen(){
    private val products = CartItems.products

    fun showCartItems(){
        ScreenHistory.push(this)
        if(products.isNotEmpty()){
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        *********장바구니 상품목록**********
                        
                    """.trimIndent()
                ) {product -> "카테고리 [${product.categoryLabel}] | 상품명 [${product.name}] | 수량 [${products[product]}]"
                }
            )
        }else{
            showErrorEmptyCart()
        }

        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption() {
        println("""
            $LINE_DIVIDER
            이전페이지로 이동하시겠습니까?(y/n)
            $LINE_DIVIDER
        """.trimIndent())
       when(readLine().getNotEmptyString()){
           "y" -> {
               moveToPreviousScreen()
           }
           "n" ->{
               showCartItems()
           }
           else ->{
               println("잘못 누르셨습니다.")
               showPreviousScreenOption()
           }
       }
    }

    private fun moveToPreviousScreen() {
        ScreenHistory.pop()
        when(val previousScreen = ScreenHistory.peek()){
            is ShoppingCategory -> previousScreen.selectCategory()
            is ShoppingProductList -> previousScreen.showCategoryProducts()
        }
    }

    private fun showErrorEmptyCart() {
        println(
            """
                   $LINE_DIVIDER
                    장바구니에 담긴 상품이 없네요~~
                   $LINE_DIVIDER
                """.trimIndent()
        )
    }

}