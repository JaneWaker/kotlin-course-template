import kotlin.math.*

enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
    /*JUSTIFY,*/
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    return when (alignment) {
        Alignment.LEFT -> toText(alignLeft(text, lineWidth))
        Alignment.RIGHT -> toText(alignRight(text, lineWidth))
        Alignment.CENTER -> toText(alignCenter(text, lineWidth))
        /*Alignment.JUSTIFY -> toText(alignJustify(text, lineWidth))*/
    }
}

private fun toText(listOfText: MutableList<String>): String {
    var textFromString = ""
    for (string in listOfText) {
        textFromString += string + "\n"
    }


    return textFromString
}

private fun alignLeft(text: String, lineWidth: Int): MutableList<String> {
    val editedText: MutableList<String> = mutableListOf()
    val word = text.split(' ').toMutableList()
    var charStr = ""
    var i = 0
    while (i <= word.lastIndex) {
        if ((1 + charStr.length + word[i].length) <= lineWidth) {
            charStr += word[i++] + ' '
        } else if ((charStr.length + word[i].length) == lineWidth) {
            charStr += word[i++]
            editedText.add(charStr)
            charStr = ""
        } else if ((1 + charStr.length + word[i].length) > lineWidth) {
            editedText.add(charStr)
            charStr = ""
        } else if (charStr.isEmpty() and (word[i].length >= lineWidth)) {
            var greaterStringLength = word[i]
            while (lineWidth < greaterStringLength.length) {
                editedText.add(greaterStringLength.substring(0, lineWidth))
                greaterStringLength = greaterStringLength.substring(lineWidth)
            }
            if (lineWidth > greaterStringLength.length) {
                word[i] = greaterStringLength
            }
        }
    }
    for (j in 0 until editedText.size) {
        if (editedText[j].last() == ' ') {
            editedText[j] = editedText[j].substring(0, editedText[j].length - 1)
        }
    }


    return editedText
}


private fun alignRight(text: String, lineWidth: Int): MutableList<String> {
    val alignLeftT = alignLeft(text, lineWidth)
    val editedText: MutableList<String> = mutableListOf()
    for (string in alignLeftT) {
        editedText.add(
            "".padStart(
                abs(lineWidth - string.length),
                ' '
            ) + string
        )
    }


    return editedText
}


private fun alignCenter(text: String, lineWidth: Int): MutableList<String> {
    val alignLeftT = alignLeft(text, lineWidth)
    val editedText: MutableList<String> = mutableListOf()
    for (string in alignLeftT) {
        editedText.add(
            "".padStart(
                abs(lineWidth - string.length) / 2,
                ' '
            ) + string + "".padStart(
                abs(lineWidth - string.length) / 2,
                ' '
            )
        )
    }


    return editedText
}

/*private fun alignJustify(text: String, lineWidth: Int): MutableList<String> {

}*/