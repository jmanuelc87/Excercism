object Bob {
    fun hey(input: String): String {

        if (input.isQuestion()) {
            return "Sure."
        }

        if (input.isYelling()) {
            return "Whoa, chill out!"
        }

        if (input.isYelling() && input.isQuestion()) {
            return "Calm down, I know what I'm doing!"
        }

        if (input.isSilence()) {
            return "Fine. Be that way!"
        }

        return "Whatever."
    }
}

fun String.isQuestion(): Boolean {
    val regex = "\\?$".toRegex()
    return this.trim().contains(regex)
}

fun String.isYelling(): Boolean {
    val regex = "^(?=.*[A-Z])[0-9 ,!?]+$".toRegex()
    val remove = "[^a-zA-Z0-9 ,!?]".toRegex()
    val clean = this.replace(remove, "")
    return clean.trim().contains(regex) || clean.contains("^[A-Z]+$".toRegex())
}

fun String.isSilence(): Boolean {
    val regex = "^\\s*$".toRegex()
    return this.contains(regex)
}
