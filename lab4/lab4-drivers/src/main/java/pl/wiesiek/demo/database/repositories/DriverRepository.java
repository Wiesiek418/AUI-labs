package pl.wiesiek.demo.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;

import java.util.List;
import java.util.UUID;

//TODO: Remember methods name must be same as driver methods
@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    List<Driver> findByFormulaTeam(FormulaTeam formulaTeam);
    List<Driver> findByDriverWDCTitles(int driverWDCTitles);
    List<Driver> findByDriverNationality(String driverNationality);
    List<Driver> findByDriverSurname(String driverSurname);
    List<Driver> findByDriverName(String driverName);
    List<Driver> findAllByFormulaTeamFormulaTeamID(UUID formulaTeamID);
}
