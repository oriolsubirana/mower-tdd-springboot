package com.oriol.mower;

import com.oriol.mower.domain.model.Direction;
import com.oriol.mower.domain.model.Mower;
import com.oriol.mower.domain.model.Position;
import com.oriol.mower.domain.service.MowerService;
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

    @Before
    public void setUp() {
        mowerService = new MowerService();
        position = new Position(0, 0, Direction.NORTH);
        mower = new Mower(position);
    }

    @Test
    @Parameters({
            "R, 0 0 E",
            "RR, 0 0 S",
            "RRR, 0 0 W",
            "RRRR, 0 0 N"
    })
    public void mowerSpinClockwise(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "L, 0 0 W",
            "LL, 0 0 S",
            "LLL, 0 0 E",
            "LLLL, 0 0 N"
    })
    public void mowerSpinAntiClockwise(String input, String output) throws Exception {
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
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
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
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
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "LM, 5 0 W",
            "LMM, 4 0 W",
            "LMMM, 3 0 W",
            "LMMMM, 2 0 W",
            "LMMMMM, 1 0 W",
    })
    public void mowerMoveWest(String input, String output) throws Exception {
        Position position = new Position(6, 0, Direction.NORTH);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
    }

    @Test
    @Parameters({
            "LLM, 0 5 S",
            "LLMM, 0 4 S",
            "LLMMM, 0 3 S",
            "LLMMMM, 0 2 S",
            "LLMMMMM, 0 1 S",
    })
    public void mowerMoveSouth(String input, String output) throws Exception {
        Position position = new Position(0, 6, Direction.NORTH);
        Mower mower = new Mower(position);
        assertThat(mowerService.process(input, mower)).isEqualTo(output);
    }

}
