package ru.netology.classes;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReadWriteFileTest {

    @Test
    void testReadString() {
        assertNull(ReadWriteFile.readString("abracadabra.test"));
        assertNotNull(ReadWriteFile.readString("data.json"));
    }

    @Test
    void testReadStringByHamcrest() {
        assertThat(ReadWriteFile.readString("abracadabra.test"), nullValue());
        assertThat(ReadWriteFile.readString("data.json"), notNullValue());
    }
}