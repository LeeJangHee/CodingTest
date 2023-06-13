package kr.baekjoon

import java.util.*

object BOJ21276 {

    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var rootNameTable = arrayListOf<String>()
    private var familyGroup = hashMapOf<String, ArrayList<String>>()

    fun solve() {
        val N = br.readLine().toInt()
        val nameTable = br.readLine().split(" ")
        /*
            key : person name
            value : indegree count
         */
        val indeg = IntArray(N)
        val arr = Array(N) { arrayListOf<Int>() }
        val M = br.readLine().toInt()
        for (i in 0 until M) {
            val (child, parent) = br.readLine().split(" ")

            val childIdx = nameTable.indexOf(child)
            val parentIdx = nameTable.indexOf(parent)

            arr[parentIdx].add(childIdx)
            indeg[childIdx] += 1
        }

        for (i in indeg.indices) {
            if (indeg[i] == 0) {
                rootNameTable.add(nameTable[i])
            }
        }

        // family group count
        // root name
        rootNameTable.sort()
        bw.appendLine("${rootNameTable.size}")
            .appendLine(rootNameTable.joinToString(" "))

        fun topologySort() {
            val q = LinkedList<Int>()

            for (i in indeg.indices) {
                if (indeg[i] == 0) {
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val now = q.poll()
                val member = familyGroup.getOrDefault(nameTable[now], arrayListOf())

                for (a in arr[now]) {
                    indeg[a] -= 1
                    if (indeg[a] == 0) {
                        member.add(nameTable[a])
                        q.offer(a)
                    }
                }
                familyGroup.put(nameTable[now], member)
            }
        }

        // execute
        topologySort()

        // print family group
        for (name in nameTable.sorted()) {
            val member = familyGroup.getOrDefault(name, arrayListOf())
            bw.append("$name ")
                .append("${member.size} ")
                .appendLine(member.sorted().joinToString(" "))
        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ21276.solve()
}