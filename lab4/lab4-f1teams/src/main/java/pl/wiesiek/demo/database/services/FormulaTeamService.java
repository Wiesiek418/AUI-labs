package pl.wiesiek.demo.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiesiek.demo.database.entities.FormulaTeam;
import pl.wiesiek.demo.database.event.F1TeamEventRestRepository;
import pl.wiesiek.demo.database.repositories.FormulaTeamRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FormulaTeamService {
    private FormulaTeamRepository formulaTeamRepository;
    private F1TeamEventRestRepository f1TeamEventRestRepository;

    @Autowired
    public FormulaTeamService(FormulaTeamRepository formulaTeamRepository, F1TeamEventRestRepository f1TeamEventRestRepository)
    {
        this.formulaTeamRepository = formulaTeamRepository;
        this.f1TeamEventRestRepository = f1TeamEventRestRepository;
    }

    //return all formula teams
    public List<FormulaTeam> getAll()
    {
        return formulaTeamRepository.findAll();
    }

    //return formula team by id
    public FormulaTeam getById(UUID id)
    {
        return formulaTeamRepository.findById(id).orElse(null);
    }

    //return formula team by name
    public FormulaTeam getByFormulaTeamName(String name)
    {
        return formulaTeamRepository.findByFormulaTeamName(name);
    }

    //return formula team by nationality
    public List<FormulaTeam> getByFormulaTeamNationality(String nationality)
    {
        return formulaTeamRepository.findByFormulaTeamNationality(nationality);
    }

        //return formula team by number of wcc
        public List<FormulaTeam> getByFormulaTeamWCC(int wcc)
        {
            return formulaTeamRepository.findByFormulaTeamWCCTitles(wcc);
        }

        //return formula team by nationality
        public List<FormulaTeam> getByFormulaTeamYearFounded(int yearFounded)
        {
            return formulaTeamRepository.findByFormulaTeamYearFounded(yearFounded);
        }

    public FormulaTeam save(FormulaTeam formulaTeam)
    {
        return formulaTeamRepository.save(formulaTeam);
    }

    public FormulaTeam create(FormulaTeam formulaTeam) {
        f1TeamEventRestRepository.create(formulaTeam);
        return formulaTeamRepository.save(formulaTeam);
    }

    public void deleteById(UUID id)
    {
        formulaTeamRepository.findById(id).ifPresent(formulaTeamRepository::delete);
        f1TeamEventRestRepository.delete(id);
    }

    public FormulaTeam update(UUID id, FormulaTeam updateFormulaTeam)
    {
        FormulaTeam existFormulaTeam = formulaTeamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));

        existFormulaTeam.setFormulaTeamName(updateFormulaTeam.getFormulaTeamName());
        existFormulaTeam.setFormulaTeamNationality(updateFormulaTeam.getFormulaTeamNationality());
        existFormulaTeam.setFormulaTeamWCCTitles(updateFormulaTeam.getFormulaTeamWCCTitles());
        existFormulaTeam.setFormulaTeamYearFounded(updateFormulaTeam.getFormulaTeamYearFounded());

        f1TeamEventRestRepository.update(id,updateFormulaTeam);
        return formulaTeamRepository.save(existFormulaTeam);
    }







}
