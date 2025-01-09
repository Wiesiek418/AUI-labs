package pl.wiesiek.demo.database.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiesiek.demo.database.dto.*;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.database.services.DriverService;
import pl.wiesiek.demo.f1teams.services.FormulaTeamService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DriverController {
    private final DriverService driverService;
    private final FormulaTeamService formulaTeamService;

    public DriverController(DriverService driverService, FormulaTeamService formulaTeamService)
    {
        this.driverService=driverService;
        this.formulaTeamService = formulaTeamService;
    }


    @GetMapping("/api/drivers/{id}")
    public ResponseEntity<GetDriverDTO> getDriverDTOResponseEntityByID(@PathVariable("id") UUID driverID)
    {
        Driver driver = driverService.getByID(driverID);
        return driver != null ? ResponseEntity.ok(toGetDriverDTO(driver)) : ResponseEntity.notFound().build();
    }


    @GetMapping("/api/drivers")
    public ResponseEntity<GetDriversDTO> getDriversDTOResponseEntityByID()
    {
        List<GetDriversDTO.Driver> driversList = driverService.getAllDrivers().stream()
                .map(driver -> GetDriversDTO.Driver.builder()
                        .driverID(driver.getDriverID())
                        .driverName(driver.getDriverName())
                        .driverSurname(driver.getDriverSurname())
                        .fomulaTeamID(driver.getFormulaTeam().getFormulaTeamID())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(GetDriversDTO.builder().drivers(driversList).build());
    }

    @GetMapping("/api/formulaTeams/{id}/drivers")
    public ResponseEntity<List<GetDriverDTO>> getDriverByFormulaTeam(@PathVariable("id") UUID formulaTeamID)
    {
        List<Driver> drivers = driverService.getByFormulaTeamID(formulaTeamID);
        if(drivers.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        List<GetDriverDTO> driversDTO = drivers.stream()
                .map(this::toGetDriverDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(driversDTO);
    }

    @PostMapping("/api/drivers")
    public ResponseEntity<Void> createDriver(@RequestBody PutDriverDTO putDriverDTO)
    {
        driverService.create(fromPutDriverDTOToDriver(putDriverDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/api/drivers/{id}")
    public ResponseEntity<Void> updateDriver(@PathVariable("id") UUID id,@RequestBody PutDriverDTO putDriverDTO)
    {
        if(driverService.getByID(id)!=null)
        {
            driverService.update(id,fromPutDriverDTOToDriver(putDriverDTO));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/api/drivers/{id}")
    public ResponseEntity<Void> patchDriver(@PathVariable("id") UUID id,@RequestBody PatchDriverDTO patchDriverDTO)
    {
        if(driverService.getByID(id)!=null)
        {
            driverService.patch(id,fromPatchDriverDTOToDriver(patchDriverDTO));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/api/drivers/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") UUID id)
    {
        if(driverService.getByID(id)!=null)
        {
            driverService.deleteByID(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    private GetDriverDTO toGetDriverDTO(Driver driver)
    {
        return GetDriverDTO.builder()
                .driverName(driver.getDriverName())
                .driverSurname(driver.getDriverSurname())
                .driverNationality(driver.getDriverNationality())
                .driverWDCTitles(driver.getDriverWDCTitles())
                .formulaTeam(GetDriverDTO.FormulaTeam.builder()
                        .formulaTeamID(driver.getFormulaTeam().getFormulaTeamID())
                        .formulaTeamName(driver.getFormulaTeam().getFormulaTeamName())
                        .build())
                .build();
    }

    private Driver fromPutDriverDTOToDriver(PutDriverDTO putDriverDTO)
    {
        return Driver.builder()
                .driverName(putDriverDTO.getDriverName())
                .driverSurname(putDriverDTO.getDriverSurname())
                .driverNationality(putDriverDTO.getDriverNationality())
                .driverWDCTitles(putDriverDTO.getDriverWDCTitles())
                .formulaTeam(formulaTeamService.getById(putDriverDTO.getFormulaTeamID()))
                .build();
    }

    private Driver fromPatchDriverDTOToDriver(PatchDriverDTO patchDriverDTO) {
        return Driver.builder()
                .driverName(patchDriverDTO.getDriverName())
                .driverSurname(patchDriverDTO.getDriverSurname())
                .driverWDCTitles(patchDriverDTO.getDriverWDCTitles())
                .build();
    }
}
