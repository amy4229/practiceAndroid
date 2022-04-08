package screen

import constant.LINE_DIVIDER
import extension.getNotEmptyString

class ShoppingHome :Screen(){

    fun start(){

        greeting()

        selectCategory()


    }

    private fun greeting() {
        ScreenHistory.push(this)
        println("안녕하세요 에이미스토어 입니다.")
        println("쇼핑을 위해 이름을 입력해주세요 :")
        val name = readLine().toString().getNotEmptyString()


        println(
        """
            $LINE_DIVIDER
            환영합니다. $name 님
            $LINE_DIVIDER
        """.trimMargin()
        )
    }

    private fun selectCategory() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.selectCategory()
    }



}