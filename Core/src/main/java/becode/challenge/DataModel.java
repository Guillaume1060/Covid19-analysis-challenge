package becode.challenge;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
@Data
@AllArgsConstructor
@ToString
public class DataModel {
    @Getter private final String direction;
    @Getter private final Year year;
    @Getter private final LocalDate date;
    @Getter private final DayOfWeek weekDay;
    @Getter private final String country;
    @Getter private final String commodity;
    @Getter private final String transportMode;
    @Getter @Setter private String measure;
    @Getter @Setter private Long value;
    @Getter @Setter private Long cumulative;
}
