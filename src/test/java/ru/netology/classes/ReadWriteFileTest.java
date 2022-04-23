package ru.netology.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadWriteFileTest {

    @Test
    void testReadString() {
        Assertions.assertNull(ReadWriteFile.readString("abracadabra.test"));
        Assertions.assertNotNull(ReadWriteFile.readString("data.json"));
    }
}