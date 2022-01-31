import org.testng.Assert
import org.testng.annotations.Test

import org.testng.Assert.*

class NewLabKtTest {

    @Test
    fun testOccurrenceFrequency() {
        val mapOfChar = occurrenceFrequency("aaaddd")
        assertEquals(
            mapOfChar.size, 2
        )
    }

    @Test
    fun testOccurrenceFrequencyIsEqualA() {
        val mapOfChar = occurrenceFrequency("aaaddd")
        assertEquals(
            mapOfChar['a'], 3
        )
    }

    @Test
    fun testOccurrenceFrequencyIsEqualB() {
        val mapOfChar = occurrenceFrequency("aaaddddd")
        assertEquals(
            mapOfChar['d'], 5
        )
    }

    @Test
    fun testOccurrenceFrequencyIsNull() {
        val mapOfChar = occurrenceFrequency("")
        assertEquals(
            mapOfChar.size, 0
        )
    }

    @Test
    fun testCharacterSearch() {
        assertEquals(
            characterSearch("aaaddddd"), 'd'
        )
    }

    @Test
    fun testCharacterSearchIfEqual() {
        assertEquals(
            characterSearch("aaaddd"), 'a'
        )
    }

    @Test
    fun testCharacterSearchIfNull() {
        assertEquals(
            characterSearch(""), null
        )
    }

    @Test
    fun testWordSearch() {
        assertEquals(
            wordSearch("aaaddd!!!!!!aaaddd@!!!&&&%aaaddd!!!!!!!!dfxthxdrhxzdxrdgzdfncfgn"), "aaaddd"
        )
    }

    @Test
    fun testWordSearchIfEqual() {
        assertEquals(
            wordSearch("aaaddd aaaddd aaaddd cccddd cccddd cccddd dfxthxdrhxzdxrdgzdfncfgn"), "aaaddd"
        )
    }

    @Test
    fun testWordSearchIfNull() {
        assertEquals(
            wordSearch(""), ""
        )
    }

    @Test
    fun testWordSearchIfBlank() {
        assertEquals(
            wordSearch("!!!"), ""
        )
    }
}