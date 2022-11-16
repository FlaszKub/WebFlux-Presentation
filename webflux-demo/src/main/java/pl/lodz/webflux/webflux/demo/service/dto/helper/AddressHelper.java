package pl.lodz.webflux.webflux.demo.service.dto.helper;

import lombok.experimental.UtilityClass;
import pl.lodz.webflux.webflux.demo.model.Address;
import pl.lodz.webflux.webflux.demo.service.dto.AddressInput;
import pl.lodz.webflux.webflux.demo.service.dto.AddressView;

import java.util.UUID;

@UtilityClass
public class AddressHelper {

    public static Address prepareAddress(AddressInput addressInput) {
        return Address.builder()
                .uuid(UUID.randomUUID())
                .street(addressInput.getStreet())
                .state(addressInput.getState())
                .number(addressInput.getNumber())
                .zipcode(addressInput.getZipcode())
                .city(addressInput.getCity())
                .build();
    }

    public static AddressView convertToAddressView(Address addressInput) {
        return AddressView.builder()
                .uuid(addressInput.getUuid())
                .street(addressInput.getStreet())
                .state(addressInput.getState())
                .number(addressInput.getNumber())
                .zipcode(addressInput.getZipcode())
                .city(addressInput.getCity())
                .build();
    }

}
