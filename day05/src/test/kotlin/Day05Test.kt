import Day05.alwaysIncreaseByOne
import Day05.calculateStepsToExit
import Day05.increaseByOneOrDecreaseByOne
import org.junit.Assert.*
import org.junit.Test

class Day05Test {

    @Test
    fun `verify example input for part 1`() {
        assertEquals(5, calculateStepsToExit("0\n3\n0\n1\n-3", alwaysIncreaseByOne))
    }

    @Test
    fun `verify puzzle input for part 1`() {
        assertEquals(351282, calculateStepsToExit(getResourceAsString("puzzle-input.txt"), alwaysIncreaseByOne))
    }

    @Test
    fun `verify example input for part 2`() {
        assertEquals(10, calculateStepsToExit("0\n3\n0\n1\n-3", increaseByOneOrDecreaseByOne))
    }

    @Test
    fun `verify puzzle input for part 2`() {
        assertEquals(24568703, calculateStepsToExit(getResourceAsString("puzzle-input.txt"), increaseByOneOrDecreaseByOne))
    }
}