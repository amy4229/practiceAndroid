package screen

import constant.LINE_DIVIDER
import data.CartItems

class ShoppingCart {
    private val products = CartItems.products

    fun showCartItems(){
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