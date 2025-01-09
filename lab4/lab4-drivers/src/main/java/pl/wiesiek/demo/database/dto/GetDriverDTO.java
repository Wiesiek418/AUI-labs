package pl.wiesiek.demo.database.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDriverDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class FormulaTeam
    {
        private UUID formulaTeamID;
        private String formulaTeamName;
    }

    private String driverName;
    private String driverSurname;
    private String driverNationality;
    private Integer driverWDCTitles;
    private FormulaTeam formulaTeam;
}

