package pl.wiesiek.demo.database.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.wiesiek.demo.database.dto.CreateFormulaTeamDTO;
import pl.wiesiek.demo.database.dto.PutFormulaTeamDTO;
import pl.wiesiek.demo.database.entities.FormulaTeam;

import java.util.UUID;

@Repository
public class F1TeamEventRestRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public F1TeamEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    public void delete(UUID id)
    {
        restTemplate.delete("/api/formulaTeams/{id}",id);
    }

    public void create(FormulaTeam createdTeam){
        String driversServiceUrl = "/api/formulaTeams";
        CreateFormulaTeamDTO dto = CreateFormulaTeamDTO.builder()
                .formulaTeamID(createdTeam.getFormulaTeamID())
                .formulaTeamName(createdTeam.getFormulaTeamName())
                .formulaTeamNationality(createdTeam.getFormulaTeamNationality())
                .formulaTeamWCCTitles(createdTeam.getFormulaTeamWCCTitles())
                .formulaTeamYearFounded(createdTeam.getFormulaTeamYearFounded())
                .build();

        restTemplate.postForObject(driversServiceUrl, dto, Void.class);
    }


    //jakis blad tutaj jest
    public void update(UUID id,FormulaTeam updateTeam){
        String driversServiceUrl = "/api/formulaTeams/"+id;
        PutFormulaTeamDTO dto = PutFormulaTeamDTO.builder()
                .formulaTeamName(updateTeam.getFormulaTeamName())
                .formulaTeamNationality(updateTeam.getFormulaTeamNationality())
                .formulaTeamWCCTitles(updateTeam.getFormulaTeamWCCTitles())
                .formulaTeamYearFounded(updateTeam.getFormulaTeamYearFounded())
                .build();

        restTemplate.put(driversServiceUrl, dto, Void.class);
    }
}
