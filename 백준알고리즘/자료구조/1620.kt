package baekjoon.barkingdog

class Solution_1620 {

    private var pokemon: HashMap<String, Int> = hashMapOf()
    private var pokemonToString: MutableList<String> = mutableListOf()

    init {
        val br = System.`in`.bufferedReader()

        val (N: Int, M: Int) = br.readLine().split(" ").map { it.toInt() }

        val question = mutableListOf<Any>()
        // 포캣몬 리스트
        for (i in 0 until N) {
            val inputStr = br.readLine()
            pokemon.put(inputStr, i + 1)
            pokemonToString.add(inputStr)
        }

        // 문제 리스트
        // 이름이면 index 출력
        // index 이면 이름 출력
        for (i in 0 until M) {
            val inputStr = br.readLine()
            try {
                question.add(inputStr.toInt())
            } catch (nfe: NumberFormatException) {
                question.add(inputStr)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        answer(question)

        br.close()
    }

    private fun answer(question: List<Any>) {
        question.forEach {
            if (it is Int) {
                println(pokemonToString[it - 1])
            } else if (it is String) {
                println(pokemon[it])
            }
        }
    }
}

private fun main() {
    Solution_1620()
}
