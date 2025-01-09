package pl.wiesiek.demo.f1teams.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class CreateFormulaTeamDTO {
    private UUID formulaTeamID;
    private String formulaTeamName;
    private String formulaTeamNationality;
    private Integer formulaTeamWCCTitles;
    private Integer formulaTeamYearFounded;
}