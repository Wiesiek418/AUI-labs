package pl.wiesiek.demo.database.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchDriverDTO {
    private String driverName;
    private String driverSurname;
    private Integer driverWDCTitles;
}
