fun main(args: Array<String>) {

    println("안녕하세요 에이미스토어 입니다.")
    println("쇼핑을 위해 이름을 입력해주세요 :")
    val name = readLine()
    println("""
    환영합니다. $name 님
    원하시는 카테고리를 입력해주세요
    *****=================================*****
    """.trimMargin())

    val categories = arrayOf("패션","전자기기","식음료")
    for (category in categories){
        println(category)
    }

    println("장바구니로 돌아가시려면 #을 눌러주세요 ")

    var selectedCategory = readLine()
    while(selectedCategory.isNullOrBlank() || (selectedCategory !="#" && !categories.contains(selectedCategory))){
        println("출력된 카테고리 중 원하시는 카테고리를 입력해주세요")
        selectedCategory = readLine()
    }
    
    if(selectedCategory == "#") {
        // TODO 장바구니 이동
    }else {
        // TODO 카테고리 상품 출력
    }


}