package pl.wiesiek.demo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiesiek.demo.database.dto.CreateFormulaTeamDTO;
import pl.wiesiek.demo.database.dto.GetFormulaTeamDTO;
import pl.wiesiek.demo.database.dto.GetFormulaTeamsDTO;
import pl.wiesiek.demo.database.dto.PutFormulaTeamDTO;
import pl.wiesiek.demo.database.entities.FormulaTeam;
import pl.wiesiek.demo.database.services.FormulaTeamService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class FormulaTeamController{
    @Autowired
    private final FormulaTeamService formulaTeamService;

    @Autowired
    public FormulaTeamController(FormulaTeamService formulaTeamService)
    {
        this.formulaTeamService = formulaTeamService;
    }

    @GetMapping("/api/formulaTeams/{id}")
    public ResponseEntity<GetFormulaTeamDTO> getFormulaTeamByID(@PathVariable("id") UUID id) {
        FormulaTeam team = formulaTeamService.getById(id);
        return team!=null ? ResponseEntity.ok(toGetFormulaTeamDTO(team)) : ResponseEntity.notFound().build();
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

    public GetFormulaTeamDTO toGetFormulaTeamDTO(FormulaTeam team)
    {
        return GetFormulaTeamDTO.builder()
                .id(team.getFormulaTeamID())
                .formulaTeamName(team.getFormulaTeamName())
                .formulaTeamNationality(team.getFormulaTeamNationality())
                .formulaTeamYearFounded(team.getFormulaTeamYearFounded())
                .formulaTeamWCCTitles(team.getFormulaTeamWCCTitles())
                .build();
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
