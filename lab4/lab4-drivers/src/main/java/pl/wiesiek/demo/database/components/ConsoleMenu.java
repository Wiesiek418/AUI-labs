package pl.wiesiek.demo.database.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wiesiek.demo.database.entities.Driver;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;
import pl.wiesiek.demo.database.services.DriverService;
import pl.wiesiek.demo.f1teams.services.FormulaTeamService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ConsoleMenu {

    private final DriverService driverService;
    private final FormulaTeamService formulaTeamService;

    @Autowired
    public ConsoleMenu(DriverService driverService, FormulaTeamService formulaTeamService) {
        this.driverService = driverService;
        this.formulaTeamService = formulaTeamService;
    }

    public void runMenuConsole() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\n__MENU__\n" +
                    "1. Display all drivers\n" +
                    "2. Display all teams\n" +
                    "3. Search driver by ID\n" +
                    "4. Add new driver\n" +
                    "5. Add new team\n" +
                    "6. Delete driver by ID\n" +
                    "7. Exit\n");

            System.out.println("Choose your option by number:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    displayAllDrivers();
                    break;
                }
                case 2: {
                    displayAllTeams();
                    break;
                }
                case 3: {
                    searchDriverById(scanner);
                    break;
                }
                case 4: {
                    addNewDriver(scanner);
                    break;
                }
                case 5: {
                    addNewTeam(scanner);
                    break;
                }
                case 6: {
                    deleteDriverById(scanner);
                    break;
                }
                case 7: {
                    System.out.println("Exiting ...");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Unknown command. Try again!");
            }
        }
    }

    private void deleteDriverById(Scanner scanner) {
        System.out.println("Driver ID?");
        String id = scanner.nextLine();
        try{
            driverService.deleteByID(UUID.fromString(id));
            System.out.println("Driver was deleted");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Wrong format of ID");
        }
    }

    private void addNewTeam(Scanner scanner) {
        System.out.println("Team name:");
        String name = scanner.nextLine();
        System.out.println("Team nationality:");
        String country = scanner.nextLine();
        System.out.println("WCC:");
        int wcc = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Team year founded:");
        int year = scanner.nextInt();
        scanner.nextLine();

        FormulaTeam formulaTeam = FormulaTeam.builder()
                .formulaTeamID(UUID.randomUUID())
                .formulaTeamName(name)
                .formulaTeamNationality(country)
                .formulaTeamWCCTitles(wcc)
                .formulaTeamYearFounded(year)
                .build();
        formulaTeamService.save(formulaTeam);
    }

    private void addNewDriver(Scanner scanner) {
        System.out.println("Driver name:");
        String name = scanner.nextLine();
        System.out.println("Driver surname:");
        String surname = scanner.nextLine();
        System.out.println("Driver nationality:");
        String nationality = scanner.nextLine();
        System.out.println("WDC:");
        int wdc = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Driver team:");
        String team = scanner.nextLine().trim();


        FormulaTeam f1team = formulaTeamService.getByFormulaTeamName(team);
        if(f1team==null)
        {
            System.out.println("Team not found");
            return;
        }

        Driver driver = Driver.builder()
                .driverID(UUID.randomUUID())
                .driverName(name)
                .driverSurname(surname)
                .driverNationality(nationality)
                .driverWDCTitles(wdc)
                .formulaTeam(f1team)
                .build();
        driverService.save(driver);
        System.out.println("Driver added");
    }

    private void searchDriverById(Scanner scanner) {
        System.out.println("Driver ID?");
        String id = scanner.nextLine();
        try{
            Driver driver = driverService.getByID(UUID.fromString(id));
            if(driver != null)
            {
                System.out.println(
                        "ID: "+driver.getDriverID()+
                                ", Name: "+driver.getDriverName()+
                                ", Surname: "+driver.getDriverSurname()+
                                ", Nationality: "+driver.getDriverNationality()+
                                ", WDC: "+driver.getDriverWDCTitles()+
                                ", Team: "+(driver.getFormulaTeam() !=null ? driver.getFormulaTeam().getFormulaTeamName() : "Don't have")
                );
            }
            else
                System.out.println("Driver not exist or wrong id");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Wrong format of ID");
        }
    }

    private void displayAllTeams() {
        List<FormulaTeam> listOfTeams = formulaTeamService.getAll();
        System.out.println("__Teams:__");
        listOfTeams.forEach(team -> System.out.println(
                "ID: "+team.getFormulaTeamID()+
                ", Name: "+team.getFormulaTeamName()+
                ", Country: "+team.getFormulaTeamNationality()+
                ", WDD: "+team.getFormulaTeamWCCTitles()+
                ", Year founded: "+team.getFormulaTeamYearFounded()
        ));
    }

    private void displayAllDrivers() {
        List<Driver> listOfDrivers = driverService.getAllDrivers();
        System.out.println("__Drivers:__");
        listOfDrivers.forEach(driver -> System.out.println(
                "ID: "+driver.getDriverID()+
                ", Name: "+driver.getDriverName()+
                ", Surname: "+driver.getDriverSurname()+
                ", Nationality: "+driver.getDriverNationality()+
                ", WDC: "+driver.getDriverWDCTitles()+
                ", Team: "+(driver.getFormulaTeam() !=null ? driver.getFormulaTeam().getFormulaTeamName() : "Don't have")
        ));
    }
}