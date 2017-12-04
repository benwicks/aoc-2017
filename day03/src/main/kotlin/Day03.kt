import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.sqrt

internal const val PUZZLE_INPUT = 347991

internal fun main(args: Array<String>) {
    println("Day 03 Pt. One Answer:\t" + shortestDistanceToSpiralSquare(PUZZLE_INPUT))
    println("Day 03 Pt. Two Answer:\t" + getFirstValueWrittenLargerThan(PUZZLE_INPUT))
}

internal fun shortestDistanceToSpiralSquare(square: Int) = getCoordinates(square).let {
    it.first.absoluteValue + it.second.absoluteValue
}

internal fun getCoordinates(square: Int): Pair<Int, Int> {
    val layer = spiralLayer(square)
    val bottomRightSquare = bottomRightSquareInLayer(layer)
    val bottomRightCoordinates = bottomRightCoordinatesForLayer(layer)
    val layerMaxMinusInputSquare = bottomRightSquare - square
    val stepsPerSide = stepsPerSide(bottomRightSquare)

    val bottomRightX = bottomRightCoordinates.first
    val bottomRightY = bottomRightCoordinates.second

    return when {
        layerMaxMinusInputSquare == 0 -> bottomRightCoordinates
        layerMaxMinusInputSquare <= stepsPerSide -> Pair(
                bottomRightX - layerMaxMinusInputSquare,
                bottomRightY
        )
        layerMaxMinusInputSquare <= (stepsPerSide * 2) -> Pair(
                bottomRightX - stepsPerSide,
                bottomRightY + layerMaxMinusInputSquare - stepsPerSide
        )
        layerMaxMinusInputSquare <= (stepsPerSide * 3) -> Pair(
                bottomRightX - abs(layerMaxMinusInputSquare - (stepsPerSide * 3)),
                bottomRightY + stepsPerSide
        )
        else -> Pair(
                bottomRightX,
                bottomRightY + squaresInLayer(layer) - layerMaxMinusInputSquare
        )
    }
}

internal fun spiralLayer(square: Int): Int {
    var squareRootOfInputSquare = ceil(sqrt(square.toDouble())).toInt()
    if (squareRootOfInputSquare % 2 == 0) {
        squareRootOfInputSquare++
    }
    return squareRootOfInputSquare / 2
}

internal fun squaresInLayer(layer: Int) = bottomRightSquareInLayer(layer) - bottomRightSquareInLayer(layer - 1)

internal fun bottomRightCoordinatesForLayer(layer: Int) = layer.let { Pair(it, -1 * it) }

internal fun stepsPerSide(bottomRightSquare: Int) = sqrt(bottomRightSquare.toDouble()).toInt() - 1

internal fun bottomRightSquareInLayer(layer: Int) = pow((2.0 * layer) + 1, 2.0).toInt()

internal fun getFirstValueWrittenLargerThan(input: Int): Int {
    val spiralWalker = SpiralWalker(Pair(0, 0), 1)
    while (spiralWalker.currentValue <= input) {
        spiralWalker.writeNextValue()
    }
    return spiralWalker.currentValue
}

