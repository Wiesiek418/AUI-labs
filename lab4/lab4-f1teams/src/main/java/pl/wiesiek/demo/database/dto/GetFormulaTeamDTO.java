package pl.wiesiek.demo.database.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetFormulaTeamDTO {
    private UUID id;
    private String formulaTeamName;
    private String formulaTeamNationality;
    private Integer formulaTeamWCCTitles;
    private Integer formulaTeamYearFounded;
}
