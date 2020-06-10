package com.oriol.mower.domain.service;

import com.oriol.mower.domain.model.Direction;
import com.oriol.mower.domain.model.Mower;
import com.oriol.mower.domain.model.Plateau;
import com.oriol.mower.domain.model.Position;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class MowerServiceTest implements WithAssertions {

    private MowerService mowerService;
    private Mower mower;
    private Position position;
    private Plateau plateau;

    @Before
    public void setUp() {
        mowerService = new MowerService();
        position = new Position(0, 0, Direction.NORTH);
        mower = new Mower(position);
        plateau = new Plateau(5, 5);
    }

    @Test
    @Parameters({
            "R, 0 0 E",
            "RR, 0 0 S",
            "RRR, 0 0 W",
            "RRRR, 0 0 N"
    })
    public void mowerSpinClockwise(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "L, 0 0 W",
            "LL, 0 0 S",
            "LLL, 0 0 E",
            "LLLL, 0 0 N"
    })
    public void mowerSpinAntiClockwise(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "M, 0 1 N",
            "MM, 0 2 N",
            "MMM, 0 3 N",
            "MMMM, 0 4 N",
            "MMMMM, 0 5 N",
    })
    public void mowerMoveNorth(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "RM, 1 0 E",
            "RMM, 2 0 E",
            "RMMM, 3 0 E",
            "RMMMM, 4 0 E",
            "RMMMMM, 5 0 E",
    })
    public void mowerMoveEast(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "LM, 4 0 W",
            "LMM, 3 0 W",
            "LMMM, 2 0 W",
            "LMMMM, 1 0 W",
    })
    public void mowerMoveWest(String input, String output) throws Exception {
        Position position = new Position(5, 0, Direction.NORTH);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "LLM, 0 4 S",
            "LLMM, 0 3 S",
            "LLMMM, 0 2 S",
            "LLMMMM, 0 1 S",
    })
    public void mowerMoveSouth(String input, String output) throws Exception {
        Position position = new Position(0, 5, Direction.NORTH);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "MMMMMMMMMM, 0 3 N",
            "RMMMMMMMMM, 8 0 E",
            "LM, 0 0 W",
            "LLM, 0 0 S",
    })
    public void mowerNotMoveOutOfBounds(String input, String output) throws Exception {
        Plateau plateau = new Plateau(8, 3);
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "LMLMLMLMM, 1 3 N",
    })
    public void mowerTestCase1(String input, String output) throws Exception {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(1, 2, Direction.NORTH);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "MMRMMRMRRM, 5 1 E",
    })
    public void mowerTestCase2(String input, String output) throws Exception {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(3, 3, Direction.EAST);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower, plateau)).isEqualTo(output);
    }

}
