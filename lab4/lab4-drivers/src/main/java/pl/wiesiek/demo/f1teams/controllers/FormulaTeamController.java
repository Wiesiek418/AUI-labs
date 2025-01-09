package pl.wiesiek.demo.f1teams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiesiek.demo.database.dto.PutDriverDTO;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.dto.CreateFormulaTeamDTO;
import pl.wiesiek.demo.f1teams.dto.PutFormulaTeamDTO;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;
import pl.wiesiek.demo.f1teams.services.FormulaTeamService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import pl.wiesiek.demo.f1teams.dto.GetFormulaTeamsDTO;

@RestController
public class FormulaTeamController{
    @Autowired
    private final FormulaTeamService formulaTeamService;

    @Autowired
    public FormulaTeamController(FormulaTeamService formulaTeamService)
    {
        this.formulaTeamService = formulaTeamService;
    }

    @GetMapping("/api/formulaTeams")
    public ResponseEntity<GetFormulaTeamsDTO> getFormulaTeams()
    {
        List<GetFormulaTeamsDTO.FormulaTeam> teams = formulaTeamService.getAll().stream()
                .map(f1team -> GetFormulaTeamsDTO.FormulaTeam.builder()
                        .formulaTeamID(f1team.getFormulaTeamID())
                        .formulaTeamName(f1team.getFormulaTeamName())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(GetFormulaTeamsDTO.builder().formulaTeams(teams).build());
    }

    @PutMapping("/api/formulaTeams/{id}")
    public ResponseEntity<Void> updateFormulaTeam(@PathVariable("id") UUID id,@RequestBody PutFormulaTeamDTO putFormulaTeamDTO)
    {
        if(formulaTeamService.getById(id)!=null)
        {
            formulaTeamService.update(id,fromPutFormulaTeamDTOToFormulaTeam(putFormulaTeamDTO));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/formulaTeams")
    public ResponseEntity<Void> createFormulaTeam(@RequestBody CreateFormulaTeamDTO createFormulaTeamDTO)
    {
        formulaTeamService.create(fromCreateFormulaTeamDTOToFormulaTeam(createFormulaTeamDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/api/formulaTeams/{id}")
    public ResponseEntity<Void> deleteFormulaTeam(@PathVariable("id") UUID id) {
        if(formulaTeamService.getById(id)!=null)
        {
            formulaTeamService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private FormulaTeam fromCreateFormulaTeamDTOToFormulaTeam(CreateFormulaTeamDTO createFormulaTeamDTO)
    {
        return FormulaTeam.builder()
                .formulaTeamID(createFormulaTeamDTO.getFormulaTeamID())
                .formulaTeamName(createFormulaTeamDTO.getFormulaTeamName())
                .formulaTeamNationality(createFormulaTeamDTO.getFormulaTeamNationality())
                .formulaTeamWCCTitles(createFormulaTeamDTO.getFormulaTeamWCCTitles())
                .formulaTeamYearFounded(createFormulaTeamDTO.getFormulaTeamYearFounded())
                .build();
    }

    private FormulaTeam fromPutFormulaTeamDTOToFormulaTeam(PutFormulaTeamDTO putFormulaTeamDTO)
    {
        return FormulaTeam.builder()
                .formulaTeamName(putFormulaTeamDTO.getFormulaTeamName())
                .formulaTeamNationality(putFormulaTeamDTO.getFormulaTeamNationality())
                .formulaTeamYearFounded(putFormulaTeamDTO.getFormulaTeamYearFounded())
                .formulaTeamWCCTitles(putFormulaTeamDTO.getFormulaTeamWCCTitles())
                .build();
    }

}
