object Day06 {
    internal fun redistributionCyclesToDuplicateConfiguration(input: String)
            = input.stepsToDuplicateConfiguration().stepsToArrive

    internal fun redistributionCyclesInInfiniteLoop(input: String)
            = input.stepsToDuplicateConfiguration().configuration.stepsToDuplicateConfiguration().stepsToArrive

    private fun String.stepsToDuplicateConfiguration() = splitIntoListOfIntegers().stepsToDuplicateConfiguration()

    private fun List<Int>.stepsToDuplicateConfiguration(): StepsToConfigurationWrapper {
        val seenConfigurations = mutableListOf<List<Int>>()
        var currentConfiguration = toMutableList()
        var steps = 0
        while (!seenConfigurations.contains(currentConfiguration)) {
            seenConfigurations.add(currentConfiguration.toList())
            currentConfiguration = currentConfiguration.redistribute()
            steps++
        }
        return StepsToConfigurationWrapper(steps, currentConfiguration)
    }

    private fun MutableList<Int>.redistribute() = apply {
        var index = indexOf(max())
        var numBlocksInBank = this[index]
        this[index] = 0
        while (numBlocksInBank > 0) {
            index++
            if (index >= size) {
                index = 0
            }
            this[index]++
            numBlocksInBank--
        }
    }

    private data class StepsToConfigurationWrapper(
            val stepsToArrive: Int,
            val configuration: List<Int>
    )
}