package pl.wiesiek.demo.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;
import pl.wiesiek.demo.database.repositories.DriverRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    //return all drivers
    public List<Driver> getAllDrivers()
    {
        return driverRepository.findAll();
    }

    //return driver by him ID
    public Driver getByID(UUID id)
    {
        return driverRepository.findById(id).orElse(null);
    }

    //return drivers by nationality
    public List<Driver> getByDriverNationality(String nationality)
    {
        return driverRepository.findByDriverNationality(nationality);
    }

    //return drivers by formula team object
    public List<Driver> getByFormulaTeam(FormulaTeam formulaTeam)
    {
        return driverRepository.findByFormulaTeam(formulaTeam);
    }

    //return drivers by formula team id
    public List<Driver> getByFormulaTeamID(UUID formulaTeamID)
    {
        return driverRepository.findAllByFormulaTeamFormulaTeamID(formulaTeamID);
    }

    //return drivers by name
    public List<Driver> getByDriverName(String driverName)
    {
        return driverRepository.findByDriverName(driverName);
    }


    //return drivers by surname
    public List<Driver> getByDriverSurname(String driverSurname)
    {
        return driverRepository.findByDriverSurname(driverSurname);
    }

    //return drivers by number of wdc
    public List<Driver> getByDriverWDC(int driverWDC)
    {
        return driverRepository.findByDriverWDCTitles(driverWDC);
    }

    public Driver update(UUID id, Driver updateDriver)
    {
        Driver existDriver = driverRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Driver not found"));

        existDriver.setDriverName(updateDriver.getDriverName());
        existDriver.setDriverSurname(updateDriver.getDriverSurname());
        existDriver.setDriverNationality(updateDriver.getDriverNationality());
        existDriver.setDriverWDCTitles(updateDriver.getDriverWDCTitles());
        existDriver.setFormulaTeam(updateDriver.getFormulaTeam());

        return driverRepository.save(existDriver);
    }

    public Driver patch(UUID id, Driver patchDriver)
    {
        Driver existDriver = driverRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Driver not found"));

        if(patchDriver.getDriverName()!=null){
            existDriver.setDriverName(patchDriver.getDriverName());
        }

        if(patchDriver.getDriverSurname()!=null){
            existDriver.setDriverSurname(patchDriver.getDriverSurname());
        }

        if(patchDriver.getDriverNationality()!=null){
            existDriver.setDriverNationality(patchDriver.getDriverNationality());
        }

        if(patchDriver.getDriverWDCTitles()!=null){
            existDriver.setDriverName(patchDriver.getDriverName());
        }


        //Moze wywolywac bledy do pozniejszej poprawy
        if(patchDriver.getFormulaTeam()!=null)
        {
            existDriver.setFormulaTeam(patchDriver.getFormulaTeam());
        }

        return driverRepository.save(existDriver);
    }

    public Driver create(Driver driver)
    {
        driver.setDriverID(UUID.randomUUID());
        return driverRepository.save(driver);
    }
    public Driver save(Driver driver)
    {
        return driverRepository.save(driver);
    }

    public void deleteByID(UUID id)
    {
        driverRepository.deleteById(id);
    }







}
