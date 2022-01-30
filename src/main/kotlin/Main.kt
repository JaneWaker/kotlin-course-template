//LAB 3
/*fun main() {
    //val ShapeFactoryRandom = ShapeFactoryImpl()
   val SizeShapes = listOf(
        Circle(18.0),
        Square(120.0),
        Rectangle(136.0, 165.0),
        Triangle(8.0, 10.0, 13.0)
    )

    println("The total area of all shapes is ${SizeShapes.sumOf { it.calcArea() }}")
    println("The total perimeter of all shapes is ${SizeShapes.sumOf { it.calcPerimeter() }}")
    println("The figure with the largest area is ${SizeShapes.maxByOrNull { it.calcArea() }}")
    println("The figure with the largest perimeter is ${SizeShapes.maxByOrNull { it.calcPerimeter() }}")
}*/

//LAB 1
/*fun main() {
    println("Left alignment:")
    var resul = alignText(
        "Kaedehara Kazuha is a samurai from Inazuma who found shelter in the Southern Cross fleet at Li Yue. This kind and carefree young man has experienced a lot in the past." +
                "Kazuha lives in wanderings, overcoming the path during the day, and at night falling asleep on the ground under a blanket of sky and stars. Neither wealth nor fame attracts him. For him, it is only important to live in harmony with the world. Although he often sleeps in the open, whether it be summer or winter, he is not at all disturbed by the impending bad weather. Yes, and the rain with the wind seems to avoid it and always bypass it. ", 13, Alignment.LEFT
    )
    println(resul)
    println("\n")
    println("\nRight alignment:")
    resul = alignText(
        "Kaedehara Kazuha is a samurai from Inazuma who found shelter in the Southern Cross fleet at Li Yue. This kind and carefree young man has experienced a lot in the past." +
                "Kazuha lives in wanderings, overcoming the path during the day, and at night falling asleep on the ground under a blanket of sky and stars. Neither wealth nor fame attracts him. For him, it is only important to live in harmony with the world. Although he often sleeps in the open, whether it be summer or winter, he is not at all disturbed by the impending bad weather. Yes, and the rain with the wind seems to avoid it and always bypass it." , 27, Alignment.RIGHT
    )
    println(resul)
    println("\n")
    println("\nCenter alignment:")
    resul = alignText(
        "Kaedehara Kazuha is a samurai from Inazuma who found shelter in the Southern Cross fleet at Li Yue. This kind and carefree young man has experienced a lot in the past." +
                "Kazuha lives in wanderings, overcoming the path during the day, and at night falling asleep on the ground under a blanket of sky and stars. Neither wealth nor fame attracts him. For him, it is only important to live in harmony with the world. Although he often sleeps in the open, whether it be summer or winter, he is not at all disturbed by the impending bad weather. Yes, and the rain with the wind seems to avoid it and always bypass it. ", 18, Alignment.CENTER
    )
    println(resul)
    /*println("\n")
    println("\nJustify alignment:")
    resul = alignText(
        "Kaedehara Kazuha is a samurai from Inazuma who found shelter in the Southern Cross fleet at Li Yue. This kind and carefree young man has experienced a lot in the past." +
                "Kazuha lives in wanderings, overcoming the path during the day, and at night falling asleep on the ground under a blanket of sky and stars. Neither wealth nor fame attracts him. For him, it is only important to live in harmony with the world. Although he often sleeps in the open, whether it be summer or winter, he is not at all disturbed by the impending bad weather. Yes, and the rain with the wind seems to avoid it and always bypass it. ", 25, Alignment.JUSTIFY
    )
    println(resul)*/
}*/

//LAB 2
fun main() {
    val input = "(((47-15)*28    -36+19-84+71+54))"
    val output = reversePolishNotation(input)
    print("Calculation result : ${calculation(output)}")
}

