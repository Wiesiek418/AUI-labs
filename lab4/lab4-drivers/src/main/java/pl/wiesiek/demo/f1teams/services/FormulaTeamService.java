package pl.wiesiek.demo.f1teams.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;
import pl.wiesiek.demo.f1teams.repositories.FormulaTeamRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FormulaTeamService {
    @Autowired
    private FormulaTeamRepository formulaTeamRepository;

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

    public FormulaTeam create(FormulaTeam formulaTeam) {return formulaTeamRepository.save(formulaTeam);}

    public void deleteById(UUID id)
    {
        formulaTeamRepository.deleteById(id);
    }

    public FormulaTeam update(UUID id, FormulaTeam updateFormulaTeam)
    {
        FormulaTeam existFormulaTeam = formulaTeamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));

        existFormulaTeam.setFormulaTeamName(updateFormulaTeam.getFormulaTeamName());
        existFormulaTeam.setFormulaTeamNationality(updateFormulaTeam.getFormulaTeamNationality());
        existFormulaTeam.setFormulaTeamWCCTitles(updateFormulaTeam.getFormulaTeamWCCTitles());
        existFormulaTeam.setFormulaTeamYearFounded(updateFormulaTeam.getFormulaTeamYearFounded());

        return formulaTeamRepository.save(existFormulaTeam);
    }






}
