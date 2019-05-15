package com.cmr.faa.pojo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    private Engine standardEngine, testEngine, differentEngine;


    @BeforeEach
    void setUp() {
        standardEngine = new Engine()
                .withManufacturer("Lycomming")
                .withModel("A1D")
                .withSerialNumber("5654R432-3");
        testEngine = new Engine()
                .withManufacturer("Lycomming")
                .withModel("A1D")
                .withSerialNumber("5654R432-3");
        differentEngine = new Engine()
                .withManufacturer("Lycomming")
                .withModel("A1D")
                .withSerialNumber("5654R432-3");
    }

    @AfterEach
    void tearDown() {
        standardEngine = testEngine = differentEngine = null;
    }

    @Test
    void hashCode1() {
        assertEquals(testEngine.hashCode(), standardEngine.hashCode());
    }

    @Test
    void hashCodeTestSerialNumberisNull() {
        testEngine.setSerialNumber(null);
        assertNotEquals(testEngine.hashCode(), standardEngine.hashCode());
    }

    @Test
    void equalsWithSameAircraft() {
        assertNotSame(testEngine, standardEngine);
        assertTrue(testEngine.equals(standardEngine));
    }

    @Test
    void equalsFailsWithDifferentModel() {
        differentEngine.setModel("M20F");
        assertFalse(differentEngine.equals(standardEngine));
        assertFalse(differentEngine.getModel().equals(standardEngine.getModel()));
    }

    @Test
    void equalsFailsWithDifferentManufacturer() {
        differentEngine.setManufacturer("CESSNA");
        assertFalse(differentEngine.equals(standardEngine));
        assertFalse(differentEngine.getManufacturer().equals(standardEngine.getManufacturer()));
    }

    @Test
    void equalsFailsWithDifferentSerialNumber() {
        differentEngine.setSerialNumber("666");
        assertTrue(testEngine.equals(standardEngine));
        assertFalse(differentEngine.getSerialNumber().equals(standardEngine.getSerialNumber()));
    }

}