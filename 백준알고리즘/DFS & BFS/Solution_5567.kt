package kr.baekjoon

class Solution_5567 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    // 초대장 보낼 사람 목록
    private var invitation = hashSetOf<Int>()
    // 친구 리스트
    private var relationship: Array<ArrayList<Int>>
    // 초대한 친구인지 확인 하는 flag
    private var visited: BooleanArray
    init {
        val N = br.readLine().toInt()
        val M = br.readLine().toInt()
        visited = BooleanArray(N + 1)
        visited[1] = true
        relationship = Array(N + 1) { arrayListOf() }
        for (i in 1..M) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            relationship[a].add(b)
            relationship[b].add(a)
        }

        findFriend(1, 0)
        bw.appendLine("${visited.count { it } - 1}")
        br.close()
        bw.flush()
    }

    private fun findFriend(start: Int, depth: Int) {
        if (depth == 2) {
            return
        }

        for (i in 0 until relationship[start].size) {
            val next = relationship[start][i]
            visited[next] = true
            findFriend(next, depth + 1)
        }
    }
}

private fun main() {
    Solution_5567()
}