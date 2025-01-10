package pl.wiesiek.demo.database.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import pl.wiesiek.demo.database.dto.CreateFormulaTeamDTO;
import pl.wiesiek.demo.database.dto.PutFormulaTeamDTO;
import pl.wiesiek.demo.database.entities.FormulaTeam;

import java.util.UUID;

@Repository
public class F1TeamEventRestRepository {
    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public F1TeamEventRestRepository(RestTemplate template, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = template;
        this.loadBalancerClient = loadBalancerClient;
    }

    public void delete(UUID id)
    {
        String uri = loadBalancerClient.choose("lab4Drivers").getUri().toString();
        restTemplate.delete(uri+"/api/formulaTeams/{id}",id);
    }

    public void create(FormulaTeam createdTeam){
        String uri = loadBalancerClient.choose("lab4Drivers").getUri().toString();
        CreateFormulaTeamDTO dto = CreateFormulaTeamDTO.builder()
                .formulaTeamID(createdTeam.getFormulaTeamID())
                .formulaTeamName(createdTeam.getFormulaTeamName())
                .formulaTeamNationality(createdTeam.getFormulaTeamNationality())
                .formulaTeamWCCTitles(createdTeam.getFormulaTeamWCCTitles())
                .formulaTeamYearFounded(createdTeam.getFormulaTeamYearFounded())
                .build();

        restTemplate.postForObject( uri+"/api/formulaTeams", dto, Void.class);
    }


    //jakis blad tutaj jest
    public void update(UUID id,FormulaTeam updateTeam){
        String uri = loadBalancerClient.choose("lab4Drivers").getUri().toString();
        PutFormulaTeamDTO dto = PutFormulaTeamDTO.builder()
                .formulaTeamName(updateTeam.getFormulaTeamName())
                .formulaTeamNationality(updateTeam.getFormulaTeamNationality())
                .formulaTeamWCCTitles(updateTeam.getFormulaTeamWCCTitles())
                .formulaTeamYearFounded(updateTeam.getFormulaTeamYearFounded())
                .build();

        restTemplate.put(uri+"/api/formulaTeams/"+id, dto, Void.class);
    }
}
