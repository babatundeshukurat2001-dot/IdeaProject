import java.time.LocalDate;

public class MenstrualCycle {

    public LocalDate calculateNextPeriodDate(
            LocalDate lastPeriodStartDate,
            int cycleLength) {

        return lastPeriodStartDate.plusDays(cycleLength);
    }
}
