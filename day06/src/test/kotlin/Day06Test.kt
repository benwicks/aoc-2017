import Day06.redistributionCyclesToDuplicateConfiguration
import Day06.redistributionCyclesInInfiniteLoop
import org.junit.Assert.*
import org.junit.Test

class Day06Test {

    @Test
    fun `Calculate number of redistribution cycles in example`() =
            assertEquals(5, redistributionCyclesToDuplicateConfiguration("0\t2\t7\t0"))

    @Test
    fun `Calculate number of redistribution cycles in puzzle input`() =
            assertEquals(11137, redistributionCyclesToDuplicateConfiguration(getResourceAsString("puzzle-input.txt")))

    @Test
    fun `Calculate number of steps in infinite loop for example`() =
            assertEquals(4, redistributionCyclesInInfiniteLoop("0\t2\t7\t0"))

    @Test
    fun `Calculate number of steps in infinite loop for puzzle input`() =
            assertEquals(1037, redistributionCyclesInInfiniteLoop(getResourceAsString("puzzle-input.txt")))
}