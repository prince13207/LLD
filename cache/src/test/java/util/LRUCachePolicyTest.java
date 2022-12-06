package test.java.util;

import main.java.util.LRUCachePolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCachePolicyTest {

    LRUCachePolicy policy;


    @BeforeEach
    void setUp() {
        policy = new LRUCachePolicy();
    }

    @Test
    void touch() {
        policy.touch("4","10");
        assertEquals("4",policy.lastNode().getKey());
        policy.touch("5","11");
        assertEquals("5",policy.lastNode().getKey());
        policy.touch("4","11");
        assertEquals("4",policy.lastNode().getKey());
        assertEquals("11",policy.lastNode().getValue());
    }

    @Test
    void evict() {
        policy.touch("4","10");
        policy.touch("5","11");
        policy.touch("6","12");

        assertEquals("4",policy.evict());
        assertEquals("5",policy.firstNode().getKey());

        policy.touch("5","13");

       assertEquals("6",policy.evict());
    }
}