fun main() {
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
}