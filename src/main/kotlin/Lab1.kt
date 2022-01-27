enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    if (lineWidth < 1)
        throw IllegalArgumentException("Error with line width")
    return when (alignment) {
        Alignment.LEFT -> toText(alignLeft(text, lineWidth))
        Alignment.RIGHT -> toText(alignRight(text, lineWidth))
        Alignment.CENTER -> toText(alignCenter(text, lineWidth))
    }
}

private fun toText(listOfText: MutableList<String>): String {
    var text = ""
    for (string in listOfText) {
        text += "$string\n"
    }
    return text
}

private fun alignLeft(text: String, lineWidth: Int): MutableList<String> {
    val word = text.split(" ").toMutableList()
    val newText: MutableList<String> = mutableListOf()
    var characterStr = ""
    var i = 0
    while (i <= word.lastIndex) {
        if ((1 + characterStr.length + word[i].length) <= lineWidth) {
            characterStr += word[i++] + ' '
        } else if ((characterStr.length + word[i].length) == lineWidth) {
            characterStr += word[i++]
            newText.add(characterStr)
            characterStr = ""
        } else if (characterStr.isEmpty() and (word[i].length >= lineWidth)) {
            var greaterStringLength = word[i]
            while ((greaterStringLength.length >= lineWidth) and greaterStringLength.isNotBlank()) {
                newText.add(greaterStringLength.substring(0, lineWidth))
                greaterStringLength = greaterStringLength.substring(lineWidth)
            }
            if (greaterStringLength.length <= lineWidth) {
                word[i] = greaterStringLength
            }
        } else
            if ((1 + characterStr.length + word[i].length) > lineWidth) {
                newText.add(characterStr)
                characterStr = ""
            }
    }
    if (characterStr.isNotEmpty()) newText.add(characterStr)
    for (j in 0 until newText.size) {
        if (newText[j].last() == ' ')
            newText[j] = newText[j].substring(0, newText[j].length - 1)
    }

    return newText
}

private fun alignRight(text: String, lineWidth: Int): MutableList<String> {
    val alignLeftText = alignLeft(text, lineWidth)
    val newText: MutableList<String> = mutableListOf()
    for (string in alignLeftText) {
        newText.add(
            "".padStart(
                lineWidth - string.length,
                ' '
            ) + string)
    }
    return newText
}

private fun alignCenter(text: String, lineWidth: Int): MutableList<String> {
    val alignLeftText = alignLeft(text, lineWidth)
    val newText: MutableList<String> = mutableListOf()
    for (string in alignLeftText) {
        newText.add(
            "".padStart(
                (lineWidth - string.length) / 2,
                ' '
            ) + string + "".padStart(
                (lineWidth - string.length) / 2,
                ' ')
        )
    }
    return newText
}

