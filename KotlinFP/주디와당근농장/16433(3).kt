package baekjoon

import java.util.*
import kotlin.collections.ArrayList

class JodiFarm3 {
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

    private fun initFarm(
        n: Int,
        f: (list: ArrayList<ArrayList<Char>>, r: Int, c: Int, hasCarrot: (Char) -> Boolean) -> ArrayList<ArrayList<Char>>
    ) =
        { r: Int, c: Int, mCarrot: (Char) -> Boolean -> f(n.toArrayList(), r, c, mCarrot) }

    private tailrec fun g(
        list: ArrayList<ArrayList<Char>>,
        r: Int,
        c: Int,
        isCarrot: (Char) -> Boolean
    ): ArrayList<ArrayList<Char>> = when {
        r < 0 || r >= list.size || c < 0 || c >= list.size -> list
        isCarrot(list[r][c]) -> list
        else -> {
            list[r][c] = 'v'
            g(list, r - 1, c - 1, isCarrot)
            g(list, r + 1, c + 1, isCarrot)
            g(list, r - 1, c + 1, isCarrot)
            g(list, r + 1, c - 1, isCarrot)
        }
    }

    private fun solution(n: Int, r: Int, c: Int) {
        val isCarrot: (Char) -> Boolean = { it == 'v' }
        initFarm(n, ::g)(r, c, isCarrot).print()
    }

    private fun input() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val r = nextInt() - 1
        val c = nextInt() - 1

        solution(n, r, c)
    }
}

fun main() {
    JodiFarm3()
}
