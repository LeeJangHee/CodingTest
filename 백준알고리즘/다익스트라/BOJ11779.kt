package baekjoon

import java.util.*

class BOJ11779 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Node(
        val idx: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }

    private val INF = 1e9.toInt()
    private val route: IntArray

    init {
        /*
        n개의 도시
        st -> en m개의 버스가 있음.
        A -> B 버스의 최소화
        비용 + 경로 출력
         */
        val N = br.readLine().toInt()
        val M = br.readLine().toInt()
        val arr = Array(N + 1) { arrayListOf<Node>() }
        for (i in 1..M) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(Node(b, c))
        }
        val (st, en) = br.readLine().split(" ").map { it.toInt() }

        route = IntArray(N + 1)

        solve(N, arr, st, en)

        br.close()
        bw.flush()
    }

    private fun solve(n: Int, arr: Array<ArrayList<Node>>, st: Int, en: Int) {
        val minValue = dijkstra(arr, st, en, IntArray(n + 1) { INF })
        val stack = Stack<Int>()
        var i = en
        stack.push(en)
        var cnt = 1
        while(route[i] != 0) {
            cnt += 1
            stack.push(route[i])
            i = route[i]
        }

        bw.appendLine("$minValue")
            .appendLine("$cnt")
        while(stack.isNotEmpty()) {
            bw.append("${stack.pop()} ")
        }
    }

    private fun dijkstra(arr: Array<ArrayList<Node>>, st: Int, en: Int, d: IntArray): Int {
        val pq = PriorityQueue<Node>()
        pq.offer(Node(st, 0))
        d[st] = 0

        while (pq.isNotEmpty()) {
            val (now, cost) = pq.poll()
            if (d[now] < cost) continue

            for (next in arr[now]) {
                val nCost = d[now] + next.cost
                if (nCost < d[next.idx]) {
                    d[next.idx] = nCost
                    pq.offer(Node(next.idx, nCost))
                    route[next.idx] = now
                }
            }
        }

        return d[en]
    }
}

private fun main() {
    BOJ11779()
}