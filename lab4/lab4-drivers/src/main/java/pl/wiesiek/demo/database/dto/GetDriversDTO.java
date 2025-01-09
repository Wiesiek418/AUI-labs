package pl.wiesiek.demo.database.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDriversDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Driver
    {
        private UUID driverID;
        private String driverName;
        private String driverSurname;
        private UUID fomulaTeamID;
    }

    @Singular
    private List<Driver> drivers;
}
