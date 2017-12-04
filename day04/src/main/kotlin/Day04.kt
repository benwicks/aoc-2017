/**
 * See <a href="https://adventofcode.com/2017/day/4">Day 4</a>
 */
internal object Day04 {
    val selectorAllowAnagrams: (String) -> String = { input -> input }
    val selectorDoNotAllowAnagrams: (String) -> List<Char> = { input -> input.toCharArray().sorted() }

    fun <T> calculateNumberValidPassphrases(passphrases: String, distinctWordSelector: (String) -> T)
            = passphrases.split("\n")
            .filter { isValidPassphrase(it, distinctWordSelector) }
            .size

    fun <T> isValidPassphrase(passphrase: String, distinctWordSelector: (String) -> T)
            = passphrase.split("\\s+".toRegex())
            .let { it.distinctBy(distinctWordSelector).size == it.size }
}