import Day07.getBottomProgramName
import org.junit.Test

import org.junit.Assert.*

class Day07Test {

    @Test
    fun getRootProgramNameForExampleInput() {
        assertEquals("tknk", getBottomProgramName(getResourceAsString("example-input.txt")))
    }

    @Test
    fun getRootProgramNameForPuzzleInput() {
        assertEquals("mwzaxaj", getBottomProgramName(getResourceAsString("puzzle-input.txt")))
    }
}