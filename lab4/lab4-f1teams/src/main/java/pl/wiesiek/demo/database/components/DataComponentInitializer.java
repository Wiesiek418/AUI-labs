package pl.wiesiek.demo.database.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wiesiek.demo.database.entities.FormulaTeam;
import pl.wiesiek.demo.database.services.FormulaTeamService;

import java.util.UUID;

@Component
public class DataComponentInitializer {

    private final FormulaTeamService formulaTeamService;

    @Autowired
    public DataComponentInitializer(FormulaTeamService formulaTeamService) {
        this.formulaTeamService = formulaTeamService;
    }

    @PostConstruct
    public void init() {
        FormulaTeam rb = FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("0ae94084-5da3-4e97-8a0b-8cdc5c7662fa"))
                .formulaTeamName("Red Bull Racing")
                .formulaTeamNationality("Austria")
                .formulaTeamWCCTitles(6)
                .formulaTeamYearFounded(2005)
                .build();

        formulaTeamService.save(rb);

        FormulaTeam ferrari = FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("2b78b0f5-d1c2-45d5-91d2-8616ff5969a3"))
                .formulaTeamName("Scuderia Ferrari")
                .formulaTeamNationality("Italy")
                .formulaTeamWCCTitles(16)
                .formulaTeamYearFounded(1950)
                .build();

        formulaTeamService.save(ferrari);

        FormulaTeam mclaren = FormulaTeam.builder()
                .formulaTeamID(UUID.fromString("5b78b0f5-abcd-45d5-90d2-8616ff5969a3"))
                .formulaTeamName("McLaren Formula 1 Team")
                .formulaTeamNationality("United Kingdom")
                .formulaTeamWCCTitles(8)
                .formulaTeamYearFounded(1966)
                .build();

        formulaTeamService.save(mclaren);


        System.out.println("Initialize is done");

        //consoleMenu.runMenuConsole();
    }
}
