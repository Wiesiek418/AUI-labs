package pl.wiesiek.demo.database.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;
import pl.wiesiek.demo.database.services.DriverService;
import pl.wiesiek.demo.f1teams.services.FormulaTeamService;

import java.util.UUID;

@Component
public class DataComponentInitializer{

    private final DriverService driverService;
    private final FormulaTeamService formulaTeamService;
    private final ConsoleMenu consoleMenu;
    @Autowired
    public DataComponentInitializer(DriverService driverService, FormulaTeamService formulaTeamService, ConsoleMenu consoleMenu)
    {
        this.driverService = driverService;
        this.formulaTeamService = formulaTeamService;
        this.consoleMenu = consoleMenu;
    }

    @PostConstruct
    public void init()
    {
        FormulaTeam rb= FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("0ae94084-5da3-4e97-8a0b-8cdc5c7662fa"))
                .formulaTeamName("Red Bull Racing")
                .formulaTeamNationality("Austria")
                .formulaTeamWCCTitles(6)
                .formulaTeamYearFounded(2005)
                .build();

        formulaTeamService.save(rb);

        FormulaTeam ferrari= FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("2b78b0f5-d1c2-45d5-91d2-8616ff5969a3"))
                .formulaTeamName("Scuderia Ferrari")
                .formulaTeamNationality("Italy")
                .formulaTeamWCCTitles(16)
                .formulaTeamYearFounded(1950)
                .build();

        formulaTeamService.save(ferrari);

        FormulaTeam mclaren= FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("5b78b0f5-abcd-45d5-90d2-8616ff5969a3"))
                .formulaTeamName("McLaren Formula 1 Team")
                .formulaTeamNationality("United Kingdom")
                .formulaTeamWCCTitles(8)
                .formulaTeamYearFounded(1966)
                .build();

        formulaTeamService.save(mclaren);

        Driver lando = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Lando")
                .driverSurname("Norris")
                .driverWDCTitles(0)
                .driverNationality("British")
                .formulaTeam(mclaren)
                .build();

        driverService.save(lando);

        Driver piastri = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Oscar")
                .driverSurname("Piastri")
                .driverNationality("Australian")
                .driverWDCTitles(0)
                .formulaTeam(mclaren)
                .build();

        driverService.save(piastri);

        Driver verstappen = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Max")
                .driverSurname("Verstappen")
                .driverNationality("Dutch")
                .driverWDCTitles(3)
                .formulaTeam(rb)
                .build();
        driverService.save(verstappen);

        Driver perez = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Sergio")
                .driverSurname("Perez")
                .driverNationality("Mexican")
                .driverWDCTitles(0)
                .formulaTeam(rb)
                .build();
        driverService.save(perez);

        Driver leclerc = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Charles")
                .driverSurname("Leclerc")
                .driverNationality("Monegasque")
                .driverWDCTitles(0)
                .formulaTeam(ferrari)
                .build();
        driverService.save(leclerc);

        Driver sainz = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName("Carlos")
                .driverSurname("Sainz")
                .driverNationality("Spanish")
                .driverWDCTitles(0)
                .formulaTeam(ferrari)
                .build();
        driverService.save(sainz);

        System.out.println("Initialize is done");

        //consoleMenu.runMenuConsole();
    }
}
