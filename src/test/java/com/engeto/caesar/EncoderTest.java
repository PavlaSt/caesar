package com.engeto.caesar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EncoderTest {

    //InterfaceEncoder encoder = new Encoder();
    InterfaceEncoder encoder = new StreamEncoder();


    @Test
    void codePositiveShift() {

        assertThat(encoder.code(" ABCDEFGH", 2)).isEqualTo("BCDEFGHIJ");
    }

    @Test
    void codeNegativeShift() {

        assertThat(encoder.code("BCDEFGHIJ", -2)).isEqualTo(" ABCDEFGH");


    }

    @Test
    void codePositiveShiftGreaterThenAbcLenght() {

        assertThat(encoder.code(" ABCDEFGH", 29)).isEqualTo("BCDEFGHIJ");

    }

    @Test
    void codeNegativeShiftGreaterThenAbcLenght() {

        assertThat(encoder.code("BCDEFGHIJ", -29)).isEqualTo(" ABCDEFGH");

    }
}