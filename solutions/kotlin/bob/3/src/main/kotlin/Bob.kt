object Bob {
    fun hey(st: String): String =

        when {
            st.isQuestion() && st.isYelling() -> "Calm down, I know what I'm doing!"
            st.isQuestion() -> "Sure."
            st.isYelling() -> "Whoa, chill out!"
            st.isSilence() -> "Fine. Be that way!"
            else -> "Whatever."
        }

}

private fun String.isSilence(): Boolean = this.isBlank()
private fun String.isQuestion(): Boolean = this.trim().endsWith("?")
private fun String.isYelling(): Boolean = any(Char::isLetter) && uppercase() == this
