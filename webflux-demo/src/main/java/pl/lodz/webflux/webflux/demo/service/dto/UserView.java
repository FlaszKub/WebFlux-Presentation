package pl.lodz.webflux.webflux.demo.service.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserView {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String pesel;

    private LocalDate dateOfBrith;

    private AddressView address;

}
