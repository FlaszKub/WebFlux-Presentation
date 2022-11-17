package pl.lodz.webflux.webflux.demo.service.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserInput {

    private String firstName;

    private String lastName;

    private String pesel;

    private LocalDate dateOfBrith;

    private AddressInput address;

}
