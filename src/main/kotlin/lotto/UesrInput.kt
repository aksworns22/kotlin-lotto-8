package lotto

interface UserInput {
    fun readLine(): String
}

class FakeUserInput(input: List<String>) : UserInput {
    private val iterator = input.iterator()

    override fun readLine(): String {
        return iterator.next()
    }
}

