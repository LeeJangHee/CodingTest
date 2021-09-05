package baekjoon

import java.util.*


class ATM_11399 {

    val sc = Scanner(System.`in`)

    val times = { i: Int ->
        val t = ArrayList<Int>(i)
        for (x in 0 until i) {
            t.add(sc.nextInt())
        }
        t.sort()
        t
    }

    fun time(i: Int, ans: (ArrayList<Int>) -> Unit) = ans(times(i))


    fun printAns(list: ArrayList<Int>) {
        var ans = 0
        list.forEachIndexed { index, time ->
            ans += time * (list.size - index)
        }
        println(ans)
    }

    fun solution(i: Int) {
        time(i) { printAns(it) }
    }

    fun input() = run {
        val people = sc.nextInt()
        solution(people)
    }
}

fun main() {
    ATM_11399().input()
}
