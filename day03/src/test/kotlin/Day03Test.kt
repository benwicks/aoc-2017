import org.junit.Test

import org.junit.Assert.*

class Day03Test {

    @Test
    fun `Given square 1 expect 0 steps`() {
        assertEquals(0, shortestDistanceToSpiralSquare(1))
    }

    @Test
    fun `Given square 12 expect 3 steps`() {
        assertEquals(3, shortestDistanceToSpiralSquare(12))
    }

    @Test
    fun `Given square 23 expect 2 steps`() {
        assertEquals(2, shortestDistanceToSpiralSquare(23))
    }

    @Test
    fun `Given square 1024 expect 31 steps`() {
        assertEquals(31, shortestDistanceToSpiralSquare(1024))
    }

    @Test
    fun `Given square 2 expect stress value 1`() {
        assertEquals(1, stressFillSquares(untilSquareNumber = 2))
    }

    @Test
    fun `Given square 3 expect stress value 2`() {
        assertEquals(2, stressFillSquares(untilSquareNumber = 3))
    }

    @Test
    fun `Given square 4 expect stress value 4`() {
        assertEquals(4, stressFillSquares(untilSquareNumber = 4))
    }

    @Test
    fun `Given square 5 expect stress value 5`() {
        assertEquals(5, stressFillSquares(untilSquareNumber = 5))
    }

    private fun stressFillSquares(
            initialPoint: Pair<Int, Int> = Pair(0, 0),
            initialValue: Int = 1,
            untilSquareNumber: Int
    ): Int {
        val spiralWalker = SpiralWalker(initialPoint, initialValue)
        for (i in 2..untilSquareNumber) {
            spiralWalker.writeNextValue()
        }
        return spiralWalker.currentValue
    }
}