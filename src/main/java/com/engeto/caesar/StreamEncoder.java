package com.engeto.caesar;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamEncoder implements InterfaceEncoder {
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    Map<Integer, Character> mapIntToAbc = abc.chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.toMap(c -> abc.indexOf(c), c -> c));

    Map<Character, Integer> mapAbcToInt = abc.chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.toMap(c -> c, c -> abc.indexOf(c)));


    @Override
    public String code(String text, int shift) {

        int newShift = shift % abc.length();

        return text.toUpperCase().chars()
                .mapToObj(c -> (char) c)
                .mapToInt(letter -> mapAbcToInt.get(letter))
                .mapToObj(i -> i + newShift)
                .mapToInt(i -> i < 0 ? i + mapIntToAbc.size() : i % mapIntToAbc.size())
                .mapToObj(i -> mapIntToAbc.get(i))
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
