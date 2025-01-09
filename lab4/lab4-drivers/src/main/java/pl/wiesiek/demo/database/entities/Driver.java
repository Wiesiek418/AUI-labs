package pl.wiesiek.demo.database.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.wiesiek.demo.f1teams.entities.FormulaTeam;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="drivers")
public class Driver {
    @Id
    @Column(name = "driver_id", unique = true, nullable = false)
    private UUID driverID;

    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @Column(name = "driver_surname", nullable = false)
    private String driverSurname;

    @Column(name = "driver_nationality", nullable = false)
    private String driverNationality;

    @Column(name = "driver_wdc_titles")
    private Integer driverWDCTitles;

    @ManyToOne
    @JoinColumn(name = "formula_team_id")
    private FormulaTeam formulaTeam;
}
