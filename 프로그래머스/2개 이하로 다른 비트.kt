package programmers

object AnotherBit {

    fun solution(numbers: LongArray): LongArray {
        val answer = mutableListOf<Long>()

        for (x in numbers) {

            if (x % 2 == 0L) {
                // 1개 수정, 1 -> 0
                answer.add(x + 1)
            } else {
                // 2개 수정, 1 -> 0 + 0 -> 1
                var t = x.toBitString()
                val zeroIdx = t.lastIndexOf("0")
                if (zeroIdx != -1) {
                    t = t.substring(0, zeroIdx) + "10" + t.substring(zeroIdx + 2, t.length)
                } else {
                    t = "10" + t.substring(1, t.length)
                }
                answer.add(t.parseLong())
            }
        }

        return answer.toLongArray()
    }


    private fun Long.toBitString(): String {
        return java.lang.Long.toBinaryString(this)
    }

    private fun String.parseLong(): Long {
        return java.lang.Long.parseLong(this, 2)
    }

}

private fun main() {
    AnotherBit.solution(longArrayOf(2, 7))
}
