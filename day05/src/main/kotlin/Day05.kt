import Day05.alwaysIncreaseByOne
import Day05.calculateStepsToExit
import Day05.increaseByOneOrDecreaseByOne

fun main(args: Array<String>) {
    val instructions = "0\n3\n0\n1\n-3"
    println("calculateStepsToExitPt1(\"${instructions.replace('\n', ' ')}\"): " +
            "${calculateStepsToExit(instructions, alwaysIncreaseByOne)}")
    println("calculateStepsToExitPt2(\"${instructions.replace('\n', ' ')}\"): " +
            "${calculateStepsToExit(instructions, increaseByOneOrDecreaseByOne)}")
}

internal object Day05 {

    internal val alwaysIncreaseByOne: (Int) -> Int = { input -> input + 1 }
    internal val increaseByOneOrDecreaseByOne: (Int) -> Int = { input -> if (input >= 3) input - 1 else input + 1 }

    internal fun calculateStepsToExit(input: String, stepModificationFunction: (Int) -> Int): Int {
        val instructionList = input.split("\n").map { Integer.parseInt(it) }.toMutableList()
        var index = 0
        var numSteps = 0

        while (index < instructionList.size) {
            val currentInstruction = instructionList[index]
            instructionList[index] = stepModificationFunction(currentInstruction)
            index += currentInstruction
            numSteps++
        }

        return numSteps
    }
}