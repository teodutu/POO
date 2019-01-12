import java.util.HashMap;
import java.util.Scanner;

class AddAndMultiply {
    //DO NOT MODIFY THIS CLASS
    public abstract class Operation{
        public abstract Object perform(Object firstElement, Object secondElement);
        public abstract Object readElement(String stringRepresentation);
        public abstract void printOperation(Object firstElement, Object secondElement);
    }
    //DO NOT MODIFY THIS CLASS
    abstract class Add extends Operation{
        public void printOperation(Object firstElement, Object secondElement){
            System.out.println(firstElement.toString() + "\n+\n" + secondElement.toString() + "\n=");
            System.out.println(perform(firstElement,secondElement).toString() + "\n");
        }
    }
    //DO NOT MODIFY THIS CLASS
    abstract class Multiply extends Operation{
        public void printOperation(Object firstElement, Object secondElement){
            System.out.println(firstElement.toString() + "\n*\n" + secondElement.toString() + "\n=");
            System.out.println(perform(firstElement,secondElement).toString() + "\n");
        }
    }

    class ComplexNumber {
        int re;
        int im;

        public int getRe() {
            return re;
        }

        public int getIm() {
            return im;
        }

        public void setRe(int re) {
            this.re = re;
        }

        public void setIm(int im) {
            this.im = im;
        }

        ComplexNumber () {

        }

        //DO NOT MODIFY THIS CONSTRUCTOR
        //use this constructor to create a ComplexNumber
        ComplexNumber (String stringRepresentation) {
            String[] splittedRepresentation = stringRepresentation.split(",");
            re = Integer.parseInt(splittedRepresentation[0]);
            im = Integer.parseInt(splittedRepresentation[1]);
        }
        @Override
        public String toString() {
            String result = re + "";
            if (im >= 0) {
                result = result + "+" + im + "i";
            }
            else {
                result = result + im + "i";
            }
            return result;
        }
    }

    public Add getComplexNumberAdder() {
        return new Add() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                int real = ((ComplexNumber)firstElement).getRe() + ((ComplexNumber)secondElement).getRe();

                int imag = ((ComplexNumber)firstElement).getIm() + ((ComplexNumber)secondElement).getIm();

                return new ComplexNumber(String.valueOf(real)+ "," + String.valueOf(imag));
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new ComplexNumber(stringRepresentation);
            }
        };
    }
    public Add getNumberAdder() {
        //WRITE YOUR CODE HERE
        return new Add() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                return new Double(Double.valueOf(firstElement.toString()) + Double.valueOf(secondElement.toString()));
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Double(stringRepresentation);
            }
        };
    }
    public Multiply getNumberMultiplier(){
        //WRITE YOUR CODE HERE
        return new Multiply() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                return new Double(Double.valueOf(firstElement.toString()) * Double.valueOf(secondElement.toString()));
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Double(stringRepresentation);
            }
        };
    }
    public Multiply getComplexNumberMultiplier(){
        //WRITE YOUR CODE HERE
        return new Multiply() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                int real = ((ComplexNumber)firstElement).getRe() * ((ComplexNumber)secondElement).getRe()
                        -((ComplexNumber)firstElement).getIm() * ((ComplexNumber)secondElement).getIm();

                int imag = ((ComplexNumber)firstElement).getRe() * ((ComplexNumber)secondElement).getIm()
                        +((ComplexNumber)firstElement).getIm() * ((ComplexNumber)secondElement).getRe();

                return new ComplexNumber(String.valueOf(real)+ "," + String.valueOf(imag));
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new ComplexNumber(stringRepresentation);
            }
        };
    }

    //DO NOT MODIFY MAIN
    public static void main(String[] args) {
        AddAndMultiply addAndMultiply = new AddAndMultiply();
        HashMap<String, Operation> operationHashMap = new HashMap<>();
        operationHashMap.put("add complex numbers", addAndMultiply.getComplexNumberAdder());
        operationHashMap.put("add numbers", addAndMultiply.getNumberAdder());
        operationHashMap.put("multiply complex numbers", addAndMultiply.getComplexNumberMultiplier());
        operationHashMap.put("multiply numbers", addAndMultiply.getNumberMultiplier());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Operation operation = operationHashMap.get(scanner.nextLine());
            Object firstElement = operation.readElement(scanner.nextLine());
            Object secondElement = operation.readElement(scanner.nextLine());
            operation.printOperation(firstElement, secondElement);
        }
    }
}