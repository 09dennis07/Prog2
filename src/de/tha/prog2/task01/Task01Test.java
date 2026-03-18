package de.tha.prog2.task01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Task01Test {

    @Test
    void testCreateChessBoard3x4() {
        String result = Task01.createChessBoard(3, 4);

        String expected = "X O X O\n"+
			              "O X O X\n"+
			              "X O X O\n";

        assertEquals(expected, result);
    }

    @Test
    void testCreateChessBoard0x5() {
        String result = Task01.createChessBoard(0, 5);

        String expected = "";
        
        assertEquals(expected, result);
    }

    @Test
    void testCreateChessBoard1x1() {
        String result = Task01.createChessBoard(1, 1);

        String expected = "X\n";

        assertEquals(expected, result);
    }
}