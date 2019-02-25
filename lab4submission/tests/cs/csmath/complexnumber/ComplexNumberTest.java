package cs.csmath.complexnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    static final double DELTA = 0.0000000001;

    //Tests realPart getter for 1.0+2.0i
    //realPart = 1.0
    @Test
    public void getRealPart() {
        ComplexNumber cn = new ComplexNumber(1.0, 2.0);
        double realPart = cn.getRealPart();
        assertEquals(1.0, realPart, DELTA);
    }

    //Tests realPart setter for 1.0+1.0i
    //newRealPart = 2.0
    @Test
    public void setRealPart() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        cn.setRealPart(2.0);
        assertEquals(2.0, cn.getRealPart(), DELTA);
    }

    //Tests imagPart getter for 2.0+1.0i
    //imagPart = 1.0
    @Test
    public void getImagPart() {
        ComplexNumber cn = new ComplexNumber(2.0, 1.0);
        double imagPart = cn.getImagPart();
        assertEquals(1.0, imagPart, DELTA);
    }

    //Tests imagPart setter for 1.0+1.0i
    //newImagPart = 2.0
    @Test
    public void setImagPart() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        cn.setImagPart(2.0);
        assertEquals(2.0, cn.getImagPart(), DELTA);
    }

    //Tests 1.0+1.0i + 2.0+3.0i = 3.0+4.0i
    @Test
    public void add() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn1 = new ComplexNumber(2.0, 3.0);
        cn.add(cn1);
        assertEquals(3.0, cn.getRealPart(), DELTA);
        assertEquals(4.0, cn.getImagPart(), DELTA);
    }

    //Tests 3.0+4.0i - 1.0+1.0i = 2.0+3.0i
    @Test
    public void sub() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn1 = new ComplexNumber(2.0, 3.0);
        cn1.sub(cn);
        assertEquals(1.0, cn1.getRealPart(), DELTA);
        assertEquals(2.0, cn1.getImagPart(), DELTA);
    }

    //Tests (2.5+3.5i)(6.1+3.9i) = 1.6+31.1i
    @Test
    public void mult() {
        ComplexNumber cn = new ComplexNumber(2.5,3.5);
        ComplexNumber cn1 = new ComplexNumber(6.1,3.9);
        cn.mult(cn1);
        assertEquals(1.6, cn.getRealPart(), DELTA);
        assertEquals(31.1, cn.getImagPart(), DELTA);
    }

    //Tests (3.0+2.0i)(0.0+0.0i) = 0.0+0.0i
    @Test
    public void multByZero() {
        ComplexNumber cn = new ComplexNumber(3.0, 2.0);
        ComplexNumber cn1 = new ComplexNumber(0.0, 0.0);
        cn.mult(cn1);
        assertEquals(0.0, cn.getRealPart(), DELTA);
        assertEquals(0.0, cn.getImagPart(), DELTA);
    }

    //Tests(3.1+2.8i)(-4.5-2.7i) = -6.39-20.97i
    @Test
    public void multByNegative() {
        ComplexNumber cn = new ComplexNumber(3.1, 2.8);
        ComplexNumber cn1 = new ComplexNumber(-4.5, -2.7);
        cn.mult(cn1);
        assertEquals(-6.39, cn.getRealPart(), DELTA);
        assertEquals(-20.97, cn.getImagPart(), DELTA);
    }

    //Tests (3.0+5.0i)/(4.0+2.0i) = 1.1+0.7i
    @Test
    public void div() {
        ComplexNumber cn = new ComplexNumber(3.0, 5.0);
        ComplexNumber cn1 = new ComplexNumber(4.0, 2.0);
        cn.div(cn1);
        assertEquals(1.1, cn.getRealPart(), DELTA);
        assertEquals(0.7, cn.getImagPart(), DELTA);
    }

    //Tests (4.1+6.7i)/(0+0i) throws an error
    @Test
    public void divideByZero() {
        ComplexNumber cn = new ComplexNumber(4.1, 6.7);
        ComplexNumber cn1 = new ComplexNumber(0.0, 0.0);
        try
        {
            cn.div(cn1);
            fail();
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }
    }

    //Tests conjugate(1.0+2.0i) = 1.0-2.0i
    @Test
    public void conj() {
        ComplexNumber cn = new ComplexNumber(1.0, 2.0);
        cn.conj();
        assertEquals(1.0, cn.getRealPart(), DELTA);
        assertEquals(-2.0, cn.getImagPart(), DELTA);
    }

    //Tests magnitude(3.0+4.0i) = 5
    @Test
    public void abs() {
        ComplexNumber cn = new ComplexNumber(3.0, 4.0);
        double magnitude = cn.abs();
        assertEquals(5.0, magnitude, DELTA);
    }

    //@Test
    //public void toString() {
    //ComplexNumber cn = new ComplexNumber();
    //String s = cn.toString();
    //assertEquals("0.0+0.0i", s);
    //}

    //Tests 1.0+1.0i + 2.0+3.0i = 3.0+4.0i
    @Test
    public void add1() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn1 = new ComplexNumber(2.0, 3.0);
        ComplexNumber result =  ComplexNumber.add(cn,cn1);
        assertEquals(3.0, result.getRealPart(), DELTA);
        assertEquals(4.0, result.getImagPart(), DELTA);
    }

    //Tests 5.0+4.0i - 1.0+1.0i = 4.0+3.0i
    @Test
    public void sub1() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        ComplexNumber cn1 = new ComplexNumber(5.0, 4.0);
        ComplexNumber result = ComplexNumber.sub(cn1,cn);
        assertEquals(4.0, result.getRealPart(), DELTA);
        assertEquals(3.0, result.getImagPart(), DELTA);
    }

    //Tests (2.5+3.5i)(6.1+3.9i) = 1.6+31.1i
    @Test
    public void mult1() {
        ComplexNumber cn = new ComplexNumber(2.5,3.5);
        ComplexNumber cn1 = new ComplexNumber(6.1,3.9);
        ComplexNumber result = ComplexNumber.mult(cn,cn1);
        assertEquals(1.6, result.getRealPart(), DELTA);
        assertEquals(31.1, result.getImagPart(), DELTA);
    }

    //Tests (3.0+5.0i)/(4.0+2.0i) = 1.1+0.7i
    @Test
    public void div1() {
        ComplexNumber cn = new ComplexNumber(3.0, 5.0);
        ComplexNumber cn1 = new ComplexNumber(4.0, 2.0);
        ComplexNumber result = ComplexNumber.div(cn,cn1);
        assertEquals(1.1, result.getRealPart(), DELTA);
        assertEquals(0.7, result.getImagPart(), DELTA);
    }

}