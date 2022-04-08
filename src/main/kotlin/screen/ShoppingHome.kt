package screen

class ShoppingHome {

    fun start(){

        greeting()

        selectCategory()


    }

    private fun greeting() {
        println("안녕하세요 에이미스토어 입니다.")
        var name =""
        while(name.isBlank()){
            println("쇼핑을 위해 이름을 입력해주세요 :")
            name = readLine().toString()
        }

        println(
            """
        환영합니다. $name 님
        
        """.trimMargin()
        )
    }

    private fun selectCategory() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.selectCategory()
    }



}