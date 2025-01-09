package pl.wiesiek.demo.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wiesiek.demo.database.entities.FormulaTeam;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormulaTeamRepository extends JpaRepository<FormulaTeam, UUID> {
    FormulaTeam findByFormulaTeamName(String formulaTeamName);
    List<FormulaTeam> findByFormulaTeamNationality(String formulaTeamNationality);
    List<FormulaTeam> findByFormulaTeamYearFounded(int formulaTeamYearFounded);
    List<FormulaTeam> findByFormulaTeamWCCTitles(int formulaTeamWCCTitles);

}
