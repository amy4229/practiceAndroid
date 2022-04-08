package screen

import constant.LINE_DIVIDER
import extension.getNotEmptyString

class ShoppingCategory :Screen() {
    fun selectCategory(){
        ScreenHistory.push(this)
        println(
            """ 
            $LINE_DIVIDER     
                원하시는 카테고리를 입력해주세요
            $LINE_DIVIDER
            """.trimMargin()
        )
        val categories = arrayOf("패션", "전자기기", "식음료")
        for (category in categories) {
            println(category)
        }

        println("장바구니로 돌아가시려면 #을 눌러주세요 ")

        val selectedCategory = readLine().getNotEmptyString()

        if(selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        }else {

            if (!categories.contains(selectedCategory)) {
                showErrorMessage(selectedCategory)
                selectCategory()
            }else{
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showCategoryProducts()
            }

        }
    }

        private fun showErrorMessage(selectedCategory: String?) {
            println("[$selectedCategory] 존재하지 않는 카테고리 입니다. 다시 입력해주세요")

        }

}