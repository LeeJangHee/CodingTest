package baekjoon

import java.util.*
import kotlin.collections.ArrayList

class JodiFarm2 {
    init {
        input()
    }

    private fun ArrayList<ArrayList<Char>>.print() = onEach {
            it.forEach { ch -> print(ch) }
            println()
    }

    private fun Int.toArrayList() = run {
        val farmList = ArrayList<ArrayList<Char>>(this)
        for (i in 0 until this) {
            val s = ArrayList<Char>()
            for (j in 0 until this) {
                s.add('.')
            }
            farmList.add(s)
        }
        farmList
    }

    private fun initFarm(n: Int, f: (list: ArrayList<ArrayList<Char>>, r: Int, c: Int) -> ArrayList<ArrayList<Char>>) =
        { r: Int, c: Int -> f(n.toArrayList(), r, c) }

    private fun growingFarm(list: ArrayList<ArrayList<Char>>, r: Int, c: Int): ArrayList<ArrayList<Char>> {
        val isCarrot: (Char) -> Boolean = { it == '.' }

        when {
            r < 0 || r >= list.size || c < 0 || c >= list.size -> return list

            isCarrot(list[r][c]) -> {
                list[r][c] = 'v'
                growingFarm(list, r - 1, c - 1)
                growingFarm(list, r + 1, c + 1)
                growingFarm(list, r - 1, c + 1)
                growingFarm(list, r + 1, c - 1)
            }
        }

        return list
    }

    private fun solution(n: Int, r: Int, c: Int) {
        initFarm(n, ::growingFarm)(r, c).print()
    }

    private fun input() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val r = nextInt() - 1
        val c = nextInt() - 1

        solution(n, r, c)
    }
}

fun main() {
    JodiFarm2()
}
