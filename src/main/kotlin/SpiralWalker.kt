import kotlin.math.abs

fun main(args: Array<String>) {
    val spiralWalker = SpiralWalker(Pair(0, 0), 1)
    for (i in 0..15) {
        println("spiralWalker.currentPoint = ${spiralWalker.currentPoint}")
        println("spiralWalker.currentValue = ${spiralWalker.currentValue}\n")
        spiralWalker.writeNextValue()
    }
}

internal class SpiralWalker(initialPoint: Pair<Int, Int>, initialValue: Int) {

    var currentValue = initialValue
        private set

    private val grid = mutableMapOf<Pair<Int, Int>, Int>()

    var currentPoint: Pair<Int, Int> = initialPoint // todo make private after debugging
        private set

    init {
        grid.put(initialPoint, initialValue)
    }

    fun writeNextValue() {
        currentPoint = nextPointInSpiralAfter(currentPoint)
        currentValue = getSumOfAdjacentPoints(currentPoint)
        grid[currentPoint] = currentValue
    }

    private fun nextPointInSpiralAfter(currentPoint: Pair<Int, Int>) = when {
        nextPointIsRight(currentPoint) -> Pair(currentPoint.first + 1, currentPoint.second)
        nextPointIsUp(currentPoint) -> Pair(currentPoint.first, currentPoint.second + 1)
        nextPointIsLeft(currentPoint) -> Pair(currentPoint.first - 1, currentPoint.second)
        else -> Pair(currentPoint.first, currentPoint.second - 1)
    }

    private fun nextPointIsRight(currentPoint: Pair<Int, Int>): Boolean {
        return currentPoint == Pair(0, 0) ||
                (currentPoint.second < 0 &&
                        currentPoint.first < abs(currentPoint.second))
    }

    private fun nextPointIsUp(currentPoint: Pair<Int, Int>): Boolean {
        return currentPoint.first > 0 &&
                currentPoint.first > abs(currentPoint.second)
    }

    private fun nextPointIsLeft(currentPoint: Pair<Int, Int>): Boolean {
        return currentPoint.second > 0 &&
                (currentPoint.first * -1) != currentPoint.second
    }

    private fun getSumOfAdjacentPoints(point: Pair<Int, Int>) = getAdjacentPoints(point)
            .filter { grid.containsKey(it) }
            .sumBy { grid[it]!! }

    private fun getAdjacentPoints(point: Pair<Int, Int>) = listOf(
            Pair(point.first, point.second + 1),
            Pair(point.first + 1, point.second + 1),
            Pair(point.first + 1, point.second),
            Pair(point.first + 1, point.second - 1),
            Pair(point.first, point.second - 1),
            Pair(point.first - 1, point.second - 1),
            Pair(point.first - 1, point.second),
            Pair(point.first - 1, point.second + 1)
    )
}