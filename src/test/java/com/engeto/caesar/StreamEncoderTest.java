package com.engeto.caesar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StreamEncoderTest {

    StreamEncoder streamEncoder = new StreamEncoder();


    @Test
    void codePositiveShift() {

        assertThat(streamEncoder.code(" ABCDEFGH", 2)).isEqualTo("BCDEFGHIJ");
    }

    @Test
    void codeNegativeShift() {

        assertThat(streamEncoder.code("BCDEFGHIJ", -2)).isEqualTo(" ABCDEFGH");


    }

    @Test
    void codePositiveShiftGreaterThenAbcLenght() {

        assertThat(streamEncoder.code(" ABCDEFGH", 29)).isEqualTo("BCDEFGHIJ");

    }

    @Test
    void codeNegativeShiftGreaterThenAbcLenght() {

        assertThat(streamEncoder.code("BCDEFGHIJ", -29)).isEqualTo(" ABCDEFGH");

    }
}
