import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;

public class MenstrualCycleTest {

    @Test
    public void shouldCalculateNextPeriodDate() {


        LocalDate lastPeriod =
                LocalDate.of(2026, 11, 1);

        int cycleLength = 28;


        MenstrualCycle menstrualCycle = new MenstrualCycle();

        LocalDate result = menstrualCycle.calculateNextPeriodDate(lastPeriod, cycleLength);


        assertEquals(LocalDate.of(2026, 11, 29), result
        );
    }

}
