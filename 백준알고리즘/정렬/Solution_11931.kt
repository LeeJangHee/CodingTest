package baekjoon.barkingdog

class Solution_11931 {

    companion object {
        private const val TEMP_SIZE = 1000001
    }

    private var arr: IntArray
    private var tmpArr: IntArray = IntArray(TEMP_SIZE)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val N = br.readLine().toInt()
        arr = IntArray(N)
        for (i in arr.indices) {
            arr[i] = br.readLine().toInt()
        }

        mergeSort(0, N)
        for (i in 0 until N) {
            bw.write("${arr[arr.lastIndex - i]}\n")
        }

        br.close()
        bw.flush()
    }

    private fun merge(start: Int, end: Int) {
        val mid = (start + end) / 2
        var leftIndex = start   // arr[start:mid]에서 값을  보기 위해 사용하는 index
        var rightIndex = mid    // arr[mid:end]에서 값을 보기 위해 사용하는 index

        for (i in start until end) {
            when {
                rightIndex == end -> tmpArr[i] = arr[leftIndex++]
                leftIndex == mid -> tmpArr[i] = arr[rightIndex++]
                arr[leftIndex] <= arr[rightIndex] -> tmpArr[i] = arr[leftIndex++]
                else -> tmpArr[i] = arr[rightIndex++]
            }
        }

        // tmpArr 에 임시로 저장된 값을 arr 로 옮김
        for (i in start until end) {
            arr[i] = tmpArr[i]
        }

    }

    private fun mergeSort(start: Int, end: Int) {
        if (end == start + 1) return // 길이가 1인 경우
        val mid = (start + end) / 2
        mergeSort(start, mid)   // start to mid-1 을 정렬한다.
        mergeSort(mid, end)     // mid to end-1 을 정렬한다.
        merge(start, end)
    }

}

private fun main() {
    Solution_11931()
}