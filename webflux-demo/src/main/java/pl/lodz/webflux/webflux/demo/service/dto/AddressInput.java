package pl.lodz.webflux.webflux.demo.service.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AddressInput {

    private String state;

    private String city;

    private String zipcode;

    private String street;

    private String number;

}
