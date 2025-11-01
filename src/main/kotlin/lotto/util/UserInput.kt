package lotto.util

import camp.nextstep.edu.missionutils.Console

interface UserInput {
    fun readLine(): String
}

object ConsoleUserInput : UserInput {
    override fun readLine(): String = Console.readLine()
}

class FakeUserInput(input: List<String>) : UserInput {
    private val iterator = input.iterator()

    override fun readLine(): String {
        return iterator.next()
    }
}

