package baekjoon.barkingdog


class Solution_8979 {

    private val tmp = Array(1001) { IntArray(1001) }
    private var rankArray: ArrayList<Nation>
    private var ranking = 1

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        rankArray = arrayListOf()
        for (i in 0 until N) {
            val (n, g, s, b) = br.readLine().split(" ").map { it.toInt() }
            rankArray.add(Nation(n, g, s, b))
        }
        rankArray.sort()
        val rate = getRanking(K)
        bw.write("$rate")

        br.close()
        bw.flush()
    }

    private fun getRanking(k: Int): Int {
        if (rankArray.first().num == k) {
            return 1
        }
        var count = 1
        for (i in 1 until rankArray.size) {
            if (rankArray[i - 1] same rankArray[i]) {
                count += 1
            } else {
                ranking += count
                count = 1
            }
            if (rankArray[i].num == k) {
                break
            }
        }
        return ranking
    }
    data class Nation(
        val num: Int,
        val gold: Int,
        val sliver: Int,
        val bronze: Int
    ) : Comparable<Nation> {
        override fun compareTo(o: Nation): Int {
            return if (this.gold == o.gold) {
                if (this.sliver == o.sliver) {
                    o.bronze - this.bronze
                } else {
                    o.sliver - this.sliver
                }
            } else {
                o.gold - this.gold
            }
        }

        override fun toString(): String {
            return "[$num $gold $sliver $bronze]"
        }
    }

    private infix fun Nation.same(o: Nation): Boolean {
        return this.gold == o.gold && this.sliver == o.sliver && this.bronze == o.bronze
    }

}

private fun main() {
    Solution_8979()
}