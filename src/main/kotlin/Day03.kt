import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.sqrt

const val PUZZLE_INPUT = 347991

fun main(args: Array<String>) {
    println("Day 03 Pt. One Answer:\t" + shortestDistanceToSpiralNumber(PUZZLE_INPUT))
    println("Day 03 Pt. Two Answer:\t" + getFirstValueWrittenLargerThan(PUZZLE_INPUT))
}

fun shortestDistanceToSpiralNumber(number: Int) = getCoordinates(number).let {
    it.first.absoluteValue + it.second.absoluteValue
}

fun getCoordinates(number: Int): Pair<Int, Int> {
    val layer = spiralLayer(number)
    val bottomRightNumber = bottomRightNumberInLayer(layer)
    val bottomRightCoordinates = bottomRightCoordinatesForLayer(layer)
    val layerMaxMinusNumber = bottomRightNumber - number
    val stepsPerSide = stepsPerSide(bottomRightNumber)

    val bottomRightX = bottomRightCoordinates.first
    val bottomRightY = bottomRightCoordinates.second

    return when {
        layerMaxMinusNumber == 0 -> bottomRightCoordinates
        layerMaxMinusNumber <= stepsPerSide -> Pair(
                bottomRightX - layerMaxMinusNumber,
                bottomRightY
        )
        layerMaxMinusNumber <= (stepsPerSide * 2) -> Pair(
                bottomRightX - stepsPerSide,
                bottomRightY + layerMaxMinusNumber - stepsPerSide
        )
        layerMaxMinusNumber <= (stepsPerSide * 3) -> Pair(
                bottomRightX - abs(layerMaxMinusNumber - (stepsPerSide * 3)),
                bottomRightY + stepsPerSide
        )
        else -> Pair(
                bottomRightX,
                bottomRightY + numbersInLayer(layer) - layerMaxMinusNumber
        )
    }
}

fun spiralLayer(number: Int): Int {
    var squareRootOfNumber = ceil(sqrt(number.toDouble())).toInt()
    if (squareRootOfNumber % 2 == 0) {
        squareRootOfNumber++
    }
    return squareRootOfNumber / 2
}

fun numbersInLayer(layer: Int) = bottomRightNumberInLayer(layer) - bottomRightNumberInLayer(layer - 1)

fun bottomRightCoordinatesForLayer(layer: Int) = layer.let { Pair(it, -1 * it) }

fun stepsPerSide(bottomRightNumber: Int) = sqrt(bottomRightNumber.toDouble()).toInt() - 1

fun bottomRightNumberInLayer(layer: Int) = pow((2.0 * layer) + 1, 2.0).toInt()

fun getFirstValueWrittenLargerThan(input: Int): Int {
    val spiralWalker = SpiralWalker(Pair(0, 0), 1)
    if (spiralWalker.currentValue <= input) {
        spiralWalker.writeNextValue()
    }
    return spiralWalker.currentValue
}

