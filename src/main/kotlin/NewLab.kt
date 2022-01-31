fun occurrenceFrequency(text: String): Map<Char, Int> {
    val mapOfChar = mutableMapOf<Char, Int>()
    if (text.isBlank()) return mapOfChar
    for (char in text) {
        if (!mapOfChar.contains(char)) {
            mapOfChar[char] = 1
        } else {
            mapOfChar.replace(char, ((mapOfChar[char]!!) + 1))
        }
    }
    return mapOfChar
}

fun characterSearch(text: String): Char? {
    var topChar: Char? = null
    val mapOfChar = occurrenceFrequency(text)
    var maxCount = -1
    mapOfChar.forEach { (Char, Int) ->
        if (Int > maxCount) {
            maxCount = Int
            topChar = Char
        } else
            if (Int == maxCount) {
                if (Char.code < topChar!!.code) {
                    maxCount = Int
                    topChar = Char
                }
            }
    }
    return topChar
}

fun wordSearch(text: String): String? {
    val mapOfString = mutableMapOf<String, Int>()
    val newtextone = text.replace("[^A-z]".toRegex(), " ")
    val newtext = newtextone.replace("\\s+".toRegex(), " ")
    val words = newtext.split(' ').toMutableList()
    for (word in words) {
        if (!mapOfString.contains(word)) {
            mapOfString[word] = 1
        } else {
            mapOfString.replace(word, ((mapOfString[word]!!) + 1))
        }
    }
    var topWord: String? = null
    var maxCount = -1
    mapOfString.forEach { (String, Int) ->
        if (Int > maxCount) {
            maxCount = Int
            topWord = String
        } else
            if (Int == maxCount) {
                if (String.compareTo(topWord!!) < 0) {
                    maxCount = Int
                    topWord = String
                }
            }
    }
    return topWord
}