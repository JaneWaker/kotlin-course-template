import org.testng.Assert
import kotlin.math.PI

class Lab3Test {

    //Circle
    @org.testng.annotations.Test
    fun testValueCircle() {
        Assert.assertThrows {
            Circle(-126.0)
        }
    }

    @org.testng.annotations.Test
    fun testValueCreateCircle() {
        Assert.assertThrows {
            ShapeFactoryImpl().createCircle(-189.0)
        }
    }

    @org.testng.annotations.Test
    fun testCalcAreaCircle() {
        Assert.assertEquals(Circle(18.0).calcArea(), PI * 18.0 * 18.0)
    }

    @org.testng.annotations.Test
    fun testCalcPerimeterCircle() {
        Assert.assertEquals(Circle(18.0).calcPerimeter(), 2 * PI * 18.0)
    }

    //Square
    @org.testng.annotations.Test
    fun testValueSquare() {
        Assert.assertThrows {
            Square(-126.0)
        }
    }

    @org.testng.annotations.Test
    fun testValueCreateSquare() {
        Assert.assertThrows {
            ShapeFactoryImpl().createSquare(-189.0)
        }
    }

    @org.testng.annotations.Test
    fun testCalcAreaSquare() {
        Assert.assertEquals(Square(18.0).calcArea(), 18.0 * 18.0)
    }

    @org.testng.annotations.Test
    fun testCalcPerimeterSquare() {
        Assert.assertEquals(Square(18.0).calcPerimeter(), 4 * 18.0)
    }

    //Rectangle
    @org.testng.annotations.Test
    fun testValueRectangle() {
        Assert.assertThrows {
            Rectangle(-126.0, 45.0)
        }
    }

    @org.testng.annotations.Test
    fun testValueCreateRectangle() {
        Assert.assertThrows {
            ShapeFactoryImpl().createRectangle(-189.0, 48.0)
        }
    }

    @org.testng.annotations.Test
    fun testCalcAreaRectangle() {
        Assert.assertEquals(Rectangle(18.0, 63.0).calcArea(), 18.0 * 63.0)
    }

    @org.testng.annotations.Test
    fun testCalcPerimeterRectangle() {
        Assert.assertEquals(Rectangle(18.0, 63.0).calcPerimeter(), 2 * 18.0 + 2 * 63.0)
    }

    //Triangle
    @org.testng.annotations.Test
    fun testValueTriangle() {
        Assert.assertThrows {
            Triangle(-126.0, 45.0, 52.0)
        }
    }

    @org.testng.annotations.Test
    fun testValueCreateTriangle() {
        Assert.assertThrows {
            ShapeFactoryImpl().createTriangle(-189.0, 48.0, 56.0)
        }
    }

    @org.testng.annotations.Test
    fun testCalcAreaTriangle() {
        Assert.assertEquals(Triangle(6.0, 8.0, 10.0).calcArea(), 24.0)
    }

    @org.testng.annotations.Test
    fun testCalcPerimeterTriangle() {
        Assert.assertEquals(Triangle(18.0, 63.0, 51.0).calcPerimeter(), 18.0 + 63.0 + 51.0)
    }

    @org.testng.annotations.Test
    fun testErrorTriangle() {
        Assert.assertThrows {
            Triangle(126.0, 10.0, 12.0)
        }
    }
}