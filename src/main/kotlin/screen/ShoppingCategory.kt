package screen

class ShoppingCategory {
    fun selectCategory(){
        println(
            """  
                원하시는 카테고리를 입력해주세요
            *****=================================*****
            """.trimMargin()
        )
        val categories = arrayOf("패션", "전자기기", "식음료")
        for (category in categories) {
            println(category)
        }

        println("장바구니로 돌아가시려면 #을 눌러주세요 ")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank() ) {
            println("출력된 카테고리 중 원하시는 카테고리를 입력해주세요")
            selectedCategory = readLine()
        }
        if(selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        }else {

            if (!categories.contains(selectedCategory)) {
                showErrorMessage(selectedCategory)
                selectCategory()
            }else{
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showCategoryProducts(selectedCategory)
            }

        }
    }

        private fun showErrorMessage(selectedCategory: String?) {
            println("[$selectedCategory] 존재하지 않는 카테고리 입니다. 다시 입력해주세요")

        }

}