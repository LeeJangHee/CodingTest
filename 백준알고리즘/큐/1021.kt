class Solution_1021 {

    private val deque: ArrayDeque<Int>
    private var count = 0

    init {
        val br = System.`in`.bufferedReader()

        val (N: Int, M: Int) = br.readLine().split(" ").map { it.toInt() }
        deque = ArrayDeque(N)

        val findElements = br.readLine().split(" ").map { it.toInt() }

        for (i in 1..N) {
            deque.add(i)
        }

        findElements.forEach {
            deque.checkMinCount(it)
        }
        println(count)

        br.close()
    }

    private fun ArrayDeque<Int>.checkMinCount(e: Int) {
        val index = this.indexOf(e)

        if (index <= (this.size / 2)) {
            this.leftCheck(e)
        } else {
            this.rightCheck(e)
        }
    }

    private fun ArrayDeque<Int>.leftCheck(e: Int) {
        while (this.first() != e) {
            val first = this.removeFirst()
            this.addLast(first)
            count++
        }
        this.removeFirst()
    }

    private fun ArrayDeque<Int>.rightCheck(e: Int) {
        while(this.first() != e) {
            val last = this.removeLast()
            this.addFirst(last)
            count++
        }
        this.removeFirst()
    }
}

private fun main() {
    Solution_1021()
}
