package baekjoon

import java.util.*

typealias ListSum = (ArrayList<Int>) -> Int


class ATM_11399 {

    val sc = Scanner(System.`in`)

    val inputTimes: (Int) -> ArrayList<Int> = { i: Int ->
        val t = ArrayList<Int>(i)
        for (x in 0 until i) {
            t.add(sc.nextInt())
        }
        t.sort()
        t
    }

    val ans = fun(a: Int) { printAns(a) }

    fun arrayRemain(f: ListSum, list: ArrayList<Int>) = f(list)

    fun arrayBind(list: ArrayList<Int>): Int {
        var sum = 0
        for ((i, time) in list.withIndex()) {
            sum += time * (list.size - i)
        }
        return sum
    }


    fun time(i: Int, minTime: (ArrayList<Int>) -> Unit) = minTime(inputTimes(i))

    fun minTime(list: ArrayList<Int>, answer: (Int) -> Unit) {
        var ans = 0
        list.forEachIndexed { index, time ->
            ans += time * (list.size - index)
        }
        answer(ans)
    }

    fun listInt(remain: (ListSum, ArrayList<Int>) -> Int, bind: ListSum) = { list: ArrayList<Int> ->
        remain(bind, list)
    }

    fun printAns(i: Int) {
        println(i)
    }

    fun solution(i: Int) {
//        time(i) { list ->
//            minTime(list, ans)
//        }

        time(i) { inputList ->
            val a = listInt(::arrayRemain, ::arrayBind)
            printAns(a(inputList))
        }

    }

    fun input() = run {
        val people = sc.nextInt()
        solution(people)
    }
}

fun main() {
    ATM_11399().input()
}
