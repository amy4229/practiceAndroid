package screen

import data.Product

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
            val productsSize = categoryProducts.size
            for(index in 0 until productsSize) {
                println("${index}. ${categoryProducts[index].name}")
            }
        }else{
            showErrorMessage(selectedCategory)

        }
    }

    private fun showErrorMessage(selectedCategory: String) {
        println("선택하신 [$selectedCategory] 카테고리에는 등록된 상품이 존재하지 않습니다.")
    }
}