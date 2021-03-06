package gameoflife;

import gameoflife.builders.CellBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void cell_with_2_neighbours_and_is_dead_returns_isAlive_false() {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(2);
        cell.checkCellLife();
        assertFalse(cell.isAlive());
    }

    @Test
    void cell_with_3_neighbours_returns_isAlive_true() {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(3);
        cell.checkCellLife();
        assertTrue(cell.isAlive());
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3})
    void cell_with_2_or_3_neighbours_and_is_not_dead_returns_isAlive_true(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .isAlive(true)
                .createCell();

        cell.neighbours(neighbours);
        cell.checkCellLife();
        assertTrue(cell.isAlive());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void cell_with_less_than_2_neighbours_returns_isAlive_false(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(neighbours);
        cell.checkCellLife();
        assertFalse(cell.isAlive());
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    void cell_with_more_than_3_neighbours_returns_isAlive_false(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(neighbours);
        cell.checkCellLife();
        assertFalse(cell.isAlive());
    }
}
