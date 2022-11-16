package pl.lodz.webflux.webflux.demo.service.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AddressView {

    private UUID uuid;

    private String state;

    private String city;

    private String zipcode;

    private String street;

    private String number;

}
