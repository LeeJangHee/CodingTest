package baekjoon

import java.util.*
import kotlin.collections.ArrayList

typealias MakeFarm = (Int, Int, Int) -> Unit
typealias Growing = (Int, Int) -> Unit

class JodiFarm_16433 {
    init {
        input()
    }

    var f = ArrayList<ArrayList<Char>>()
    fun farmPrint() = { list: ArrayList<ArrayList<Char>> ->
        list.forEach { l ->
            l.forEach { c ->
                print(c)
            }
            println()
        }
    }
    fun carrotDone(f: (Int, Int, Int, MakeFarm) -> Unit, makeFarm: MakeFarm) =
        { n: Int, r: Int, c: Int ->
            f(n, r, c, makeFarm)
        }

    fun makeCarrot(n: Int, r: Int, c: Int, makeFarm: MakeFarm) = makeFarm(n, r, c)

    fun initFarm(n: Int, r: Int, c: Int) {
        val farm = ArrayList<ArrayList<Char>>(n)
        for (i in 0 until n) {
            val s = arrayListOf<Char>()
            for (j in 0 until n) {
                s.add('.')
            }
            farm.add(s)
        }
        f = farm
        growingCarrot(::isGrowing)(r, c)
    }

    fun isCarrot() = { c: Char -> c == '.' }

    fun growingCarrot(growing: Growing) = { r: Int, c: Int ->
        growing(r, c)
    }

    fun isGrowing(r: Int, c: Int) {
        when {
            r < 0 || r >= f.size || c < 0 || c >= f.size -> { return }
            else -> {
                if (isCarrot()(f[r][c])) {
                    f[r][c] = 'v'
                    isGrowing(r - 1, c - 1)
                    isGrowing(r + 1, c + 1)
                    isGrowing(r - 1, c + 1)
                    isGrowing(r + 1, c - 1)
                }
            }
        }
    }

    fun solution(n: Int, r: Int, c: Int) {
        carrotDone(::makeCarrot, ::initFarm)(n, r, c)
        farmPrint()(f)
    }


    fun input() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val r = nextInt() - 1
        val c = nextInt() - 1

        solution(n, r, c)
    }
}

fun main() {
    JodiFarm_16433()
}
