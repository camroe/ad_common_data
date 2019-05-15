package com.cmr.faa.pojo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftTest {

    private Aircraft standardAircraft;
    private Aircraft testAircraft;
    private Aircraft differentTestAircraft;

    @BeforeEach
    void setUp() {
        standardAircraft = new Aircraft()
                .withSerialNumber("690011")
                .withModel("M20G")
                .withManufacturer("Mooney")
                .withNnumber("N9145V");
        testAircraft = new Aircraft()
                .withSerialNumber("690011")
                .withModel("M20G")
                .withManufacturer("Mooney")
                .withNnumber("N9145V");
        differentTestAircraft = new Aircraft()
                .withSerialNumber("690011")
                .withModel("M20G")
                .withManufacturer("Mooney")
                .withNnumber("N9145V");
    }

    @AfterEach
    void tearDown() {
        standardAircraft = differentTestAircraft = testAircraft = null;

    }

    @Test
    void hashCode1() {

        assertEquals(testAircraft.hashCode(), standardAircraft.hashCode());
    }

    @Test
    void hashCodeTestSerialNumberisNull() {
        testAircraft.setSerialNumber(null);
        assertNotEquals(testAircraft.hashCode(), standardAircraft.hashCode());
    }

    @Test
    void equalsWithSameAircraft() {
        assertNotSame(testAircraft, standardAircraft);
        assertTrue(testAircraft.equals(standardAircraft));
    }

    @Test
    void equalsFailsWithDifferentModel() {
        differentTestAircraft.setModel("M20F");
        assertFalse(differentTestAircraft.equals(standardAircraft));
        assertFalse(differentTestAircraft.getModel().equals(standardAircraft.getModel()));
    }

    @Test
    void equalsFailsWithDifferentManufacturer() {
        differentTestAircraft.setManufacturer("CESSNA");
        assertFalse(differentTestAircraft.equals(standardAircraft));
        assertFalse(differentTestAircraft.getManufacturer().equals(standardAircraft.getManufacturer()));
    }

    @Test
    void equalsFailsWithDifferentSerialNumber() {
        differentTestAircraft.setSerialNumber("666");
        assertTrue(testAircraft.equals(standardAircraft));
        assertFalse(differentTestAircraft.getSerialNumber().equals(standardAircraft.getSerialNumber()));
    }

}