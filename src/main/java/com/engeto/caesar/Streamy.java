package com.engeto.caesar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streamy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> listOfStrings = Arrays.asList(input.split(""));


        Streamy numbers = new Streamy(1, 2, 3);

        for (Integer n : numbers.compute(n -> n + 1)) {
            System.out.println(n);
        }
    }

    private final List<Integer> numbers;

    public Streamy(Integer... numbers) {  /// kolikchceme parametrů ...
        this.numbers = Arrays.asList(numbers);
    }

    public List<Integer> even() {
        return numbers.stream()
                .filter(this::isEven) //method reference(místo this může být Numbers) = (n -> n%2 == 0) = Numbers.isEven(n)
                .collect(Collectors.toList());
    }

    public boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public List<Integer> compute(Function<Integer, Integer> operator) {
        return numbers.stream()
                .map(operator)
                .collect(Collectors.toList());
    }

    public Integer sum() {
        return numbers.stream()
                .reduce(0, (a, n) -> a + n);
    }

    public Integer maxEvan() {
        return numbers.stream()
                .filter(this::isEven)
                .reduce(Integer.MIN_VALUE, (a, n) -> n > a ? n : a);
    }


}
