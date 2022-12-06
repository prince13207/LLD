package test.java.domain;

import main.java.domain.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    Storage data;

    @BeforeEach
    void setUp() {
        data = new Storage(5);
    }

    @Test
    void get() {
        data.add("4","test");
        assertEquals("test",data.get("4"));
    }

    @Test
    void add() {
        assertDoesNotThrow(()->data.add("key","value"));
    }

    @Test
    void remove() {
        assertDoesNotThrow(()->data.remove("test"));
    }

    @Test
    void isFull() {
        data.add("1","1");
        data.add("2","1");
        data.add("3","1");
        data.add("4","1");
        data.add("5","1");
        data.add("6","1");
        assertTrue(data.isCapacityBreached());
    }
}