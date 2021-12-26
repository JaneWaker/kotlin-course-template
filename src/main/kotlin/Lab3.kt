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

class Rectangle(val FirstEdge: Double, val SecEdge: Double) : Shape {
    override fun calcArea(): Double = FirstEdge * SecEdge

    override fun calcPerimeter(): Double = 2 * FirstEdge + 2 * SecEdge

    init {
        if ((FirstEdge < 0) or (SecEdge < 0)) {
            throw IllegalArgumentException("Size error")
        }
    }
}

class Triangle(val FirstEdge: Double, val SecEdge: Double, val ThirdEdge: Double) : Shape {
    override fun calcArea(): Double {
        val SemiPer = calcPerimeter() * 0.5
        return sqrt(SemiPer * (SemiPer - FirstEdge) * (SemiPer - SecEdge) * (SemiPer - ThirdEdge))
    }

    override fun calcPerimeter(): Double = FirstEdge + SecEdge + ThirdEdge

    init {
        if ((FirstEdge < 0) or (SecEdge < 0) or (ThirdEdge < 0)) {
            throw IllegalArgumentException("Size error")
        }
        if ((FirstEdge + SecEdge <= ThirdEdge) or (FirstEdge + ThirdEdge <= SecEdge) or (SecEdge + ThirdEdge <= FirstEdge)) {
            throw IllegalArgumentException("Size error")
        }
    }
}

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(edge: Double): Square
    fun createRectangle(FirstEdge: Double, SecEdge: Double): Rectangle
    fun createTriangle(FirstEdge: Double, SecEdge: Double, ThirdEdge: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle = Circle(radius)

    override fun createSquare(edge: Double): Square = Square(edge)

    override fun createRectangle(FirstEdge: Double, SecEdge: Double): Rectangle = Rectangle(FirstEdge, SecEdge)

    override fun createTriangle(FirstEdge: Double, SecEdge: Double, ThirdEdge: Double): Triangle =
        Triangle(FirstEdge, SecEdge, ThirdEdge)

    override fun createRandomCircle(): Circle = createCircle(Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()))

    override fun createRandomSquare(): Square = createSquare(Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()))

    override fun createRandomRectangle(): Rectangle = createRectangle(
        Random.nextDouble(0.0, Int.MAX_VALUE.toDouble()),
        Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
    )

    override fun createRandomTriangle(): Triangle {
        val FirstEdge = Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
        val SecEdge = Random.nextDouble(0.0, Int.MAX_VALUE.toDouble())
        val ThirdEdge = Random.nextDouble(
            kotlin.math.max(FirstEdge, SecEdge) - kotlin.math.min(FirstEdge, SecEdge),
            FirstEdge + SecEdge
        )
        return createTriangle(FirstEdge, SecEdge, ThirdEdge)
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

