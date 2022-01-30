import java.util.*

class Expression {
    companion object {
        private val DegreeOf: List<String> = listOf(element = "^")
        private val MultAndDivis: List<String> = listOf("*", "/")
        private val AddAndDiff: List<String> = listOf("+", "-")
        private val Bracket: List<String> = listOf(element = "(")

        fun priority(operator: String): Int {
            return when (operator) {
                "^" -> 4
                "*" -> 3
                "/" -> 3
                "+" -> 2
                "-" -> 2
                "(" -> 1
                ")" -> 1
                else -> -1
            }
        }

        fun operatedTF(operation: String): Boolean {
            return (DegreeOf.contains(operation)) or (MultAndDivis.contains(operation)) or (AddAndDiff.contains(
                operation
            )) or (Bracket.contains(
                operation
            ))
        }
    }
}

fun reversePolishNotation(expression: String): String {
    val inputExpression = expression.filter {
        it != ' '
    }.toCharArray()
    val stack: Stack<String> = Stack()
    var afterSym = ""
    var i = 0
    while (i < inputExpression.size) {
        if (i > 0) {
            if (afterSym.isNotEmpty()) {
                if (inputExpression[i].isDigit()) {
                    afterSym += " "
                }
            }
        }
        while (inputExpression[i].isDigit()) {
            afterSym += inputExpression[i]
            i++
        }

        if (inputExpression[i] == '(') {
            stack.push(inputExpression[i].toString())
            i++
            continue
        } else if (inputExpression[i] == ')') {
            val list = stack.reversed()
            for (j in list) {
                if (j == "(") {
                    stack.pop()
                    break
                } else {
                    afterSym += " " + stack.pop()
                }
            }
        } else if (stack.isNotEmpty()) {
            if (Expression.operatedTF(inputExpression[i].toString())) {
                val list = stack.reversed()
                for (j in list) {
                    if (Expression.priority(inputExpression[i].toString()) <= Expression.priority(j)) {
                        afterSym += " " + stack.pop()
                    } else {
                        stack.push(inputExpression[i].toString())
                        break
                    }
                }
            }
        }
        i++
    }
    if (stack.isNotEmpty()) {
        stack.withIndex().reversed().forEach { operation ->
            afterSym += " " + operation.value
        }
    }


    return afterSym
}


fun calculation(input: String?): String? {
    val resultExpression: Stack<String> = Stack()
    var firstOperand: Float
    var secondOperand: Float
    var resultInOperation = 0F
    val values = input?.split(' ')
    if (values != null) {
        for (numeric in values) {
            if (numeric.toUIntOrNull() != null) {
                resultExpression.push(numeric)
            } else {
                secondOperand = resultExpression.pop().toFloat()
                firstOperand = resultExpression.pop().toFloat()
                when (numeric) {
                    "+" -> {
                        resultInOperation = firstOperand + secondOperand
                    }
                    "-" -> {
                        resultInOperation = firstOperand - secondOperand
                    }
                    "*" -> {
                        resultInOperation = firstOperand * secondOperand
                    }
                    "/" -> {
                        resultInOperation = firstOperand / secondOperand
                    }
                    "^" -> {
                        for (i: Int in 0 until secondOperand.toInt()) {
                            resultInOperation *= firstOperand
                        }
                    }
                }
                resultInOperation.toString()
                resultExpression.push(resultInOperation.toString())
            }
        }
    }


    return resultExpression.pop()
}

