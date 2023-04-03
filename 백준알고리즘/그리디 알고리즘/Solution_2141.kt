package kr.baekjoon

class Solution_2141 {

    data class Country(
        val village: Long,
        val resident: Long
    )

    private var country = arrayListOf<Country>()

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val N = br.readLine().toInt()

        var people = 0L
        for (i in 0 until N) {
            val (v, r) = br.readLine().split(" ").map { it.toLong() }
            country.add(Country(v, r))
            people += r
        }

        country.sortWith { o1, o2 ->
            when {
                o1.village > o2.village -> 1
                o1.village < o2.village -> -1
                else -> (o1.resident - o2.resident).toInt()
            }
        }

        var sum = 0L
        for (i in 0 until N) {
            sum += country[i].resident
            if (sum >= (people + 1) / 2) {
                bw.write("${country[i].village}\n")
                break
            }
        }


        bw.flush()
        br.close()
    }

}

private fun main() {
    Solution_2141()
}