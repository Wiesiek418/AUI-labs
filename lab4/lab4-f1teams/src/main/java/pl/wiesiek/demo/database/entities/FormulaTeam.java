package pl.wiesiek.demo.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="formula_teams")
public class FormulaTeam {
    @Id
    @Column(name = "formula_team_id", unique = true, nullable = false)
    private UUID formulaTeamID;

    @Column(name = "formula_team_name", nullable = false)
    private String formulaTeamName;

    @Column(name = "formula_team_nationality", nullable = false)
    private String formulaTeamNationality;

    @Column(name = "formula_team_wcc_titles")
    private Integer formulaTeamWCCTitles;

    @Column(name = "formula_team_year_founded")
    private Integer formulaTeamYearFounded;

}
