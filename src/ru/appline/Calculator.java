package ru.appline;

public class Calculator {

    public double calculate(double firstVal, String operand, double secVal) {
        double result = 0;
        switch (operand) {
            case "+":
                result = firstVal + secVal;
                break;
            case "-":
                result = firstVal - secVal;
                break;
            case "*":
                result = firstVal * secVal;
                break;
            case "/":
                if (secVal != 0) {
                    result = firstVal / secVal;
                } else {
                    System.out.println("Ошибка: деление на ноль.");
                }
                break;
            default:
                System.out.println("Ошибка: Неподдерживаемая арифметическая операция.");
        }
        return result;
    }
}
