package cs.csmath.complexnumber;

public class ComplexNumber {
    public ComplexNumber(){
        super();
    }

    public ComplexNumber(double real, double imag){
        this.setRealPart(real);
        this.setImagPart(imag);
    }

    public ComplexNumber(ComplexNumber cn)
    {
        this.realPart = cn.getRealPart();
        this.imagPart = cn.getImagPart();
    }

    private double realPart;
    public double getRealPart() {
        return realPart;
    }
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    private double imagPart;
    public double getImagPart() {
        return imagPart;
    }
    public void setImagPart(double imagPart) {
        this.imagPart = imagPart;
    }

    public void add(ComplexNumber otherCN){
        double newRealPart= this.getRealPart()+ otherCN.getRealPart();
        double newImagPart= this.getImagPart()+ otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public void sub(ComplexNumber otherCN){
        double newRealPart= this.getRealPart()- otherCN.getRealPart();
        double newImagPart= this.getImagPart()- otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public void mult(ComplexNumber otherCN){
        double newRealPart= this.getRealPart()* otherCN.getRealPart()
                - this.getImagPart()* otherCN.getImagPart();
        double newImagPart= this.getImagPart()* otherCN.getRealPart()
                + this.getRealPart()* otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public void div(ComplexNumber otherCN) throws ArithmeticException
    {

        double a = this.getRealPart();
        double b = this.getImagPart();
        double c = otherCN.getRealPart();
        double d = otherCN.getImagPart();

        double denominator = c * c + d * d;
        if (java.lang.Math.abs(denominator) < 0.0000000001)
        {
            throw new ArithmeticException();
        }
        double newRealPart = (a * c + b * d) / denominator;
        double newImagPart = (b * c - a * d) / denominator;
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public ComplexNumber conj(){
        double newImagPart = this.getImagPart()*(-1);
        this.setImagPart(newImagPart);
        return this;
    }

    public double abs(){
        double a = this.getRealPart();
        double b = this.getImagPart();
        double magnitude = java.lang.Math.sqrt(a*a + b*b);
        return magnitude;
    }

    @Override
    public String toString() {
        return getRealPart() + "+" + getImagPart() + "i";
    }

    public static ComplexNumber add(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.add(secondCN);
        return firstCN;
    }

    public static ComplexNumber sub(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.sub(secondCN);
        return firstCN;
    }

    public static ComplexNumber mult(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.mult(secondCN);
        return firstCN;
    }

    public static ComplexNumber div(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.div(secondCN);
        return firstCN;
    }

}

