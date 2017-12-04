internal class SpiralWalker(initialPoint: Pair<Int, Int>, initialValue: Int) {

    var currentDirection: Direction = Direction.Down
    var currentValue = initialValue
        private set

    private val grid = mutableMapOf<Pair<Int, Int>, Int>()

    private var currentPoint: Pair<Int, Int> = initialPoint

    init {
        grid.put(initialPoint, initialValue)
    }

    fun writeNextValue() {
        currentPoint = nextPointInSpiralAfter(currentPoint)
        currentValue = getSumOfAdjacentPoints(currentPoint)
        grid[currentPoint] = currentValue
    }

    private fun nextPointInSpiralAfter(currentPoint: Pair<Int, Int>) = currentPoint.step(currentDirection.turn).let {
        if (it in grid) {
            currentPoint.step(currentDirection)
        } else {
            currentDirection = currentDirection.turn
            it
        }
    }

    private fun Pair<Int, Int>.step(direction: Direction) = when (direction) {
        is Direction.Right -> Pair(first + 1, second)
        is Direction.Up -> Pair(first, second + 1)
        is Direction.Left -> Pair(first - 1, second)
        is Direction.Down -> Pair(first, second - 1)
    }

    private fun getSumOfAdjacentPoints(point: Pair<Int, Int>) = getAdjacentPoints(point)
            .filter { it in grid }
            .sumBy { grid[it]!! }

    private fun getAdjacentPoints(point: Pair<Int, Int>) = listOf(
            point.step(Direction.Up),
            Pair(point.first + 1, point.second + 1),
            point.step(Direction.Right),
            Pair(point.first + 1, point.second - 1),
            point.step(Direction.Down),
            Pair(point.first - 1, point.second - 1),
            point.step(Direction.Left),
            Pair(point.first - 1, point.second + 1)
    )

    internal sealed class Direction {
        abstract val turn: Direction

        object Right : Direction() {
            override val turn = Up
        }

        object Up : Direction() {
            override val turn = Left
        }

        object Left : Direction() {
            override val turn = Down
        }

        object Down : Direction() {
            override val turn = Right
        }
    }
}