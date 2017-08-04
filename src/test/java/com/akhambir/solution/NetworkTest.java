package com.akhambir.solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NetworkTest {

    private Network actualNetwork;
    private final int n = 8;

    @Before
    public void init() {
        this.actualNetwork = new Network(n);
    }

    @Test
    public void verifyThatConnectWillWorkCorrectlyOnRegularCase() {
        String expectedNetwork = "[0, 1, 6, 5, 4, 5, 6, 7, 8]";
        this.actualNetwork.connect(3, 5);
        this.actualNetwork.connect(2, 6);
        assertEquals(expectedNetwork, this.actualNetwork.toString());
    }

    @Test
    public void verifyThatQueryWillWorkCorrectlyOnRegularCase() {
        this.actualNetwork.connect(3, 5);
        this.actualNetwork.connect(2, 6);
        this.actualNetwork.connect(5, 6);
        assertTrue(this.actualNetwork.query(3, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyThatConstructorTrowsExceptionOnWrongArg() {
        int wrongConstructorArg = 1;
        new Network(wrongConstructorArg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyThatValidationWillCatchArgumentSmallerThen_0() {
        int wrongArgument = 0;
        this.actualNetwork.connect(wrongArgument, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyThatValidationWillCatchArgumentBiggerThenGivenSetSize() {
        int wrongArgument = 9;
        this.actualNetwork.connect(3, wrongArgument);
    }
}