internal fun String.readDigitAtIndex(index: Int) = this[index].toDigit()

/**
 * @throws IllegalArgumentException if this is not a valid digit.
 */
internal fun Char.toDigit() = (toInt() - 48).apply {
    require((0..9).contains(this)) { "Not a digit: ${this@toDigit}" }
}
