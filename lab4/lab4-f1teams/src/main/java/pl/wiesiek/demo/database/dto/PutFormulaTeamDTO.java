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

public class PutFormulaTeamDTO {
    private String formulaTeamName;
    private String formulaTeamNationality;
    private Integer formulaTeamWCCTitles;
    private Integer formulaTeamYearFounded;
}