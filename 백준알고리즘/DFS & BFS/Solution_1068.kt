class Solution_1068 {

    private var count = 0
    private var nodes: Array<Node>

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        // 0 <= N <= 50
        val N = br.readLine().toInt()
        val parent = br.readLine().split(" ").map { it.toInt() }
        nodes = Array<Node>(N + 1) { Node(it) }
        val removeIndex = br.readLine().toInt()

        var root = 0
        for (i in 0 until N) {
            if (parent[i] == -1) {
                // root node
                root = i
                continue
            }
            nodes[parent[i]].children.add(nodes[i])
        }

        if (removeIndex != root) {
            deleteAt(root, removeIndex)
            dfs(root)
        }
        bw.write("$count")

        br.close()
        bw.flush()
    }

    private fun deleteAt(idx: Int, removeIdx: Int) {
        for (child in nodes[idx].children) {
            if (child.index == removeIdx) {
                nodes[idx].children.remove(child)
                return
            }
            deleteAt(child.index, removeIdx)
        }
    }

    private fun dfs(idx: Int) {
        if (nodes[idx].children.size == 0) {
            count += 1
            return
        }

        for (child in nodes[idx].children) {
            dfs(child.index)
        }
    }

    private data class Node(
        val index: Int,
        var children: ArrayList<Node> = arrayListOf()
    )


}

private fun main() {
    Solution_1068()
}