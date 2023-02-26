package baekjoon.barkingdog

class Solution_13414 {

    private lateinit var studentIds: HashMap<String, Int>

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        // 수강 가능 인원: K
        // 수강 대기열 인원: L
        val (K: Int, L: Int) = br.readLine().split(" ").map { it.toInt() }

        studentIds = hashMapOf()
        for (i in 1..L) {
            val inputStr = br.readLine()
            studentIds.put(inputStr, i)
        }
        val keyIterator = studentIds.toSortedMap { o1, o2 ->
            val o1Value = studentIds.getOrDefault(o1, 0)
            val o2Value = studentIds.getOrDefault(o2, 0)
            o1Value.compareTo(o2Value)
        }.keys.iterator()

        var index = 0
        while (keyIterator.hasNext()) {
            if (index == K) break
            bw.write(keyIterator.next() + "\n")
            index++
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_13414()
}