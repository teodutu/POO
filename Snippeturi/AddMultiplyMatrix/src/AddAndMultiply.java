import java.util.HashMap;
import java.util.Scanner;

public class AddAndMultiply {
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

    class Matrix {
        int length;
        Integer[][] values;
        //use this constructor to create a Matrix object which contains
        //a bi-dimensional integer initialized with 0 on all it's elements
        Matrix (int length){
            this.length = length;
            this.values = new Integer[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    this.values[i][j] = 0;
                }
            }
        }
        //use this constructor to create a Matrix object based on a String
        Matrix (String matrixBuilder) {
            String[] splitMatrixBuilder = matrixBuilder.split(";");
            this.length = splitMatrixBuilder.length;
            this.values = new Integer[splitMatrixBuilder.length][splitMatrixBuilder.length];
            for (int i = 0; i < splitMatrixBuilder.length; i++) {
                String[] rowSplitMatrix = splitMatrixBuilder[i].split(",");
                for (int j = 0; j < splitMatrixBuilder.length; j++) {
                    this.values[i][j] = Integer.parseInt(rowSplitMatrix[j]);
                }
            }

        }
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    result.append(values[i][j].toString() + "  ");
                }
                if (i+1 < length) {
                    result.append("\n");
                }
            }
            return result.toString();
        }
    }

    public Add getNumberAdder(){
        //WRITE YOUR CODE HERE
        return new Add() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                return new Integer((Integer)firstElement + (Integer)secondElement);
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Integer(stringRepresentation);
            }
        };
    }
    public Add getMatrixAdder(){
        //WRITE YOUR CODE HERE
        return new Add() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                int len = ((Matrix)firstElement).length;
                Matrix res = new Matrix(len);

                for (int i = 0; i < len; ++i) {
                    for (int j = 0; j < len; ++j) {
                        res.values[i][j] = ((Matrix)firstElement).values[i][j]
                                + ((Matrix)secondElement).values[i][j];
                    }
                }

                return res;
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Matrix(stringRepresentation);
            }
        };
    }
    public Multiply getNumberMultiplier(){
        //WRITE YOUR CODE HERE
        return new Multiply() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                return new Integer((Integer)firstElement * (Integer)secondElement);
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Integer(stringRepresentation);
            }
        };
    }
    public Multiply getMatrixMultiplier(){
        //WRITE YOUR CODE HERE
        return new Multiply() {
            @Override
            public Object perform(Object firstElement, Object secondElement) {
                int len = ((Matrix)firstElement).length;
                Matrix res = new Matrix(len);

                for (int i = 0; i < len; ++i) {
                    for (int j = 0; j < len; ++j) {
                        for (int k = 0; k < len; ++k) {
                            res.values[i][j] += ((Matrix)firstElement).values[i][k]
                                    * ((Matrix)secondElement).values[k][j];
                        }
                    }
                }

                return res;
            }

            @Override
            public Object readElement(String stringRepresentation) {
                return new Matrix(stringRepresentation);
            }
        };
    }

    //DO NOT MODIFY MAIN
    public static void main(String[] args) {
        AddAndMultiply addAndMultiply = new AddAndMultiply();
        HashMap<String, Operation> operationHashMap = new HashMap<>();
        operationHashMap.put("add numbers", addAndMultiply.getNumberAdder());
        operationHashMap.put("add matrix", addAndMultiply.getMatrixAdder());
        operationHashMap.put("multiply numbers", addAndMultiply.getNumberMultiplier());
        operationHashMap.put("multiply matrix", addAndMultiply.getMatrixMultiplier());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Operation operation = operationHashMap.get(scanner.nextLine());
            Object firstElement = operation.readElement(scanner.nextLine());
            Object secondElement = operation.readElement(scanner.nextLine());
            operation.printOperation(firstElement, secondElement);
        }
    }
}