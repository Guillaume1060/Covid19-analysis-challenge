package becode.challenge;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
@Getter
@Data
@AllArgsConstructor
@ToString
public class DataModel {
    private final String direction;
    private final Year year;
    private final LocalDate date;
    private final DayOfWeek weekDay;
    private final String country;
    private final String commodity;
    private final String transportMode;
    @Setter private String measure;
    @Setter private Long value;
    @Setter private Long cumulative;
}
