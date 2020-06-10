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

}
