import Day04.calculateNumberValidPassphrases
import Day04.isValidPassphrase
import Day04.selectorAllowAnagrams
import Day04.selectorDoNotAllowAnagrams
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day04Test {

    @Test
    fun `"aa bb cc dd ee" should be valid`() {
        assertTrue { isValidPassphrase("aa bb cc dd ee", selectorAllowAnagrams) }
    }

    @Test
    fun `"aa bb cc dd aa" should be invalid`() {
        assertFalse { isValidPassphrase("aa bb cc dd aa", selectorAllowAnagrams) }
    }

    @Test
    fun `"aa bb cc dd aaa" should be valid`() {
        assertTrue { isValidPassphrase("aa bb cc dd aaa", selectorAllowAnagrams) }
    }

    @Test
    fun calculateNumberValidPassphrasesInSystem() {
        assertEquals(325,
                calculateNumberValidPassphrases(getResourceAsString("system-passphrases.txt"), selectorAllowAnagrams))
    }

    @Test
    fun `"abcde fghij" is valid passphrase without anagrams`() {
        assertTrue { isValidPassphrase("abcde fghij", selectorDoNotAllowAnagrams) }
    }

    @Test
    fun `"abcde xyz ecdab" is invalid passphrase without anagrams`() {
        assertFalse { isValidPassphrase("abcde xyz ecdab", selectorDoNotAllowAnagrams) }
    }

    @Test
    fun `"a ab abc abd abf abj" is valid passphrase without anagrams`() {
        assertTrue { isValidPassphrase("a ab abc abd abf abj", selectorDoNotAllowAnagrams) }
    }

    @Test
    fun `"iiii oiii ooii oooi oooo" is valid passphrase without anagrams`() {
        assertTrue { isValidPassphrase("iiii oiii ooii oooi oooo", selectorDoNotAllowAnagrams) }
    }

    @Test
    fun `"oiii ioii iioi iiio" is invalid passphrase without anagrams`() {
        assertFalse { isValidPassphrase("oiii ioii iioi iiio", selectorDoNotAllowAnagrams) }
    }

    @Test
    fun calculateNumberValidPassphrasesWithoutAnagramsInSystem() {
        assertEquals(119, calculateNumberValidPassphrases(
                getResourceAsString("system-passphrases.txt"),
                selectorDoNotAllowAnagrams
        ))
    }
}