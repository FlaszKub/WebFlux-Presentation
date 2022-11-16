package pl.lodz.webflux.webflux.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lodz.webflux.webflux.demo.model.Address;
import pl.lodz.webflux.webflux.demo.repository.AddressRepository;
import pl.lodz.webflux.webflux.demo.service.dto.AddressInput;
import pl.lodz.webflux.webflux.demo.service.dto.AddressView;
import pl.lodz.webflux.webflux.demo.service.dto.helper.AddressHelper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Mono<AddressView> create(AddressInput addressInput) {
        Address address = AddressHelper.prepareAddress(addressInput);

        return addressRepository.save(address)
                .map(AddressHelper::convertToAddressView);

    }

    public Flux<AddressView> getAll() {
        return  addressRepository.findAll()
                .map(AddressHelper::convertToAddressView);
    }

    public Mono<AddressView> getByUuid(UUID uuid) {
        return  addressRepository.findByUuid(uuid)
                .map(AddressHelper::convertToAddressView);
    }

    public Mono<Void> deleteByUuid(UUID uuid) {
        return  addressRepository.deleteByUuid(uuid);
    }

    public Mono<AddressView> updateAddress(UUID uuid,  AddressInput addressInput){
        return addressRepository.findByUuid(uuid)
                .flatMap(dbUser -> {
                    dbUser.setStreet(addressInput.getStreet());
                    dbUser.setCity(addressInput.getCity());
                    dbUser.setNumber(addressInput.getNumber());
                    dbUser.setZipcode(addressInput.getZipcode());
                    dbUser.setState(addressInput.getState());
                    return addressRepository.save(dbUser);
                })
                .map(AddressHelper::convertToAddressView);
    }

}
