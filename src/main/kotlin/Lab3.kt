import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.random.Random

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(val radius: Double) : Shape {
    override fun calcArea(): Double = PI * radius * radius

    override fun calcPerimeter(): Double = 2 * PI * radius

    init {
        if (radius < 0) {
            throw IllegalArgumentException("Size error")
        }
    }
}


class Square(val edge: Double) : Shape {
    override fun calcArea(): Double = edge * edge

    override fun calcPerimeter(): Double = 4 * edge

    init {
        if (edge < 0) {
            throw IllegalArgumentException("Size error")
        }
    }
}

class Rectangle(val firstEdge: Double, val secEdge: Double) : Shape {
    override fun calcArea(): Double = firstEdge * secEdge

    override fun calcPerimeter(): Double = 2 * firstEdge + 2 * secEdge

    init {
        if ((firstEdge < 0) or (secEdge < 0)) {
            throw IllegalArgumentException("Size error")
        }
    }
}

class Triangle(val firstEdge: Double, val secEdge: Double, val thirdEdge: Double) : Shape {
    override fun calcArea(): Double {
        val semiPer = calcPerimeter() * 0.5
        return sqrt(semiPer * (semiPer - firstEdge) * (semiPer - secEdge) * (semiPer - thirdEdge))
    }

    override fun calcPerimeter(): Double = firstEdge + secEdge + thirdEdge

    init {
        if ((firstEdge < 0) or (secEdge < 0) or (thirdEdge < 0)) {
            throw IllegalArgumentException("Size error")
        }
        if ((firstEdge + secEdge <= thirdEdge) or (firstEdge + thirdEdge <= secEdge) or (secEdge + thirdEdge <= firstEdge)) {
            throw IllegalArgumentException("Size error")
        }
    }
}

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(edge: Double): Square
    fun createRectangle(firstEdge: Double, SecEdge: Double): Rectangle
    fun createTriangle(firstEdge: Double, SecEdge: Double, ThirdEdge: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle = Circle(radius)

    override fun createSquare(edge: Double): Square = Square(edge)

    override fun createRectangle(firstEdge: Double, secEdge: Double): Rectangle = Rectangle(firstEdge, secEdge)

    override fun createTriangle(firstEdge: Double, secEdge: Double, thirdEdge: Double): Triangle =
        Triangle(firstEdge, secEdge, thirdEdge)

    override fun createRandomCircle(): Circle = createCircle(Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()))

    override fun createRandomSquare(): Square = createSquare(Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()))

    override fun createRandomRectangle(): Rectangle = createRectangle(
        Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()),
        Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
    )

    override fun createRandomTriangle(): Triangle {
        val firstEdge = Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
        val secEdge = Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
        val thirdEdge = Random.nextDouble(
            kotlin.math.max(firstEdge, secEdge) - kotlin.math.min(firstEdge, secEdge),
            firstEdge + secEdge
        )
        return createTriangle(firstEdge, secEdge, thirdEdge)
    }

    override fun createRandomShape(): Shape {
        return when (Random.nextInt(1, 4)) {
            1 -> createRandomCircle()
            2 -> createRandomSquare()
            3 -> createRandomRectangle()
            4 -> createRandomTriangle()
            else -> error("Error")
        }
    }
}

