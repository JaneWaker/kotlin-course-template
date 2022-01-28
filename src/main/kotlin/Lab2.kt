import java.util.*
import kotlin.math.*

class Calculate {
    companion object {
        private val LEVEL_4: List<String> = listOf("^")
        private val LEVEL_3: List<String> = listOf("*", "/")
        private val LEVEL_2: List<String> = listOf("+", "-")
        private val LEVEL_1: List<String> = listOf("(")

        fun operate(operation: String): Boolean {
            if (LEVEL_4.contains(operation)) return true
            if (LEVEL_3.contains(operation)) return true
            if (LEVEL_2.contains(operation)) return true
            if (LEVEL_1.contains(operation)) return true
            return false
        }

        fun priority(operation: String): Int {
            if (LEVEL_4.contains(operation)) return 4
            if (LEVEL_3.contains(operation)) return 3
            if (LEVEL_2.contains(operation)) return 2
            if (LEVEL_1.contains(operation)) return 1
            return -1
        }
    }
}

fun reversePolishNotation(expression: String): String {
    var postfix = ""
    val inputArray = expression.filter { !it.isWhitespace() }.toCharArray()
    val operStack: Stack<String> = Stack()
    var function = ""
    var unary = true
    var i = 0
    while (i < inputArray.size) {
        if (inputArray[0] == ')' || inputArray[0] == '*' || inputArray[0] == '/' || inputArray[0] == '^') {
            throw Exception()
        }
        if (i != 0 && inputArray[i].isDigit() && postfix.isNotEmpty()) {
            postfix += " "
        }
        while (inputArray[i].isDigit()) {
            postfix += inputArray[i];
            i++;
            if (i == inputArray.size) break
        }
        if (i == inputArray.size) break
        if (inputArray[i] == '(') {
            operStack.push(inputArray[i].toString());
            ++i;
            continue
        } else if (inputArray[i] == ')') {
            val operList = operStack.reversed()
            for (operation in operList) {
                if (operation == "(") {
                    operStack.pop()
                    break
                } else postfix += " " + operStack.pop()
            }
        } else {
            if (operStack.isNotEmpty() && Calculate.operate(inputArray[i].toString())) {
                val operList = operStack.reversed()
                for (operation in operList) {
                    if (Calculate.priority(operation) >= Calculate.priority(
                            inputArray[i].toString()
                        )
                    ) {
                        postfix += " " + operStack.pop()
                    } else {
                        operStack.push(inputArray[i].toString())
                        break
                    }
                    if (operStack.empty()) {
                        operStack.push(inputArray[i].toString())
                        break
                    }
                }
            } else {
                if (Calculate.operate(inputArray[i].toString())) operStack.push(inputArray[i].toString())
            }
        }
        ++i
    }
    if (!operStack.empty()) operStack.withIndex().reversed()
        .forEach { operation ->
            postfix += " " + operation.value; operStack.pop()
        }
    if (postfix.contains("(") || postfix.contains(")")) {
        throw Exception()
    }
    return postfix
}

fun calculate(input: String?): Float {
    val result: Stack<String> = Stack()
    if (input == null) {
        throw Exception()
    }
    val parts = input.split(" ")
    var leftOper = 0f
    var rightOper: Float
    var operResul = 0f
    for (part in parts) {
        if (part.toIntOrNull() != null) {
            result.push(part)
        } else {
            rightOper = result.pop().toFloat()
            leftOper = result.pop().toFloat()
            when (part) {
                "+" -> operResul = leftOper + rightOper
                "-" -> operResul = leftOper - rightOper
                "*" -> operResul = leftOper * rightOper
                "/" -> operResul = leftOper / rightOper
                "^" -> operResul = leftOper.pow(rightOper)
            }
            result.push(operResul.toString())
        }
    }
    return result.pop().toFloat()
}