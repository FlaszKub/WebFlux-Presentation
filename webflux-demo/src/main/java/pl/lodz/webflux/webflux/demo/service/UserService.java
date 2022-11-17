package pl.lodz.webflux.webflux.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lodz.webflux.webflux.demo.model.Address;
import pl.lodz.webflux.webflux.demo.model.User;
import pl.lodz.webflux.webflux.demo.repository.AddressRepository;
import pl.lodz.webflux.webflux.demo.repository.UserRepository;
import pl.lodz.webflux.webflux.demo.service.dto.UserInput;
import pl.lodz.webflux.webflux.demo.service.dto.UserView;
import pl.lodz.webflux.webflux.demo.service.dto.helper.AddressHelper;
import pl.lodz.webflux.webflux.demo.service.dto.helper.UserHelper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public Mono<UserView> createWithAddress(UserInput userInput) {
        Address address = AddressHelper.prepareAddress(userInput.getAddress());

        return addressRepository.save(address)
                .flatMap(addressEntity -> {
                    User user = UserHelper.prepareUser(userInput, addressEntity);
                    return userRepository.save(user);
                })
                .map(UserHelper::convertToUserView);

    }

    public Flux<UserView> getAll() {
        return userRepository.findAll()
                .flatMap(user -> Mono.just(user)
                        .zipWith(addressRepository.findById(user.getAddressId()))
                        .map(result -> {
                            User u = result.getT1();
                            result.getT1().setAddress(result.getT2());
                            return u;
                        }))
                .map(UserHelper::convertToUserView);
    }

    public Mono<UserView> getByUuid(UUID uuid) {
        return userRepository.findByUuid(uuid)
                .flatMap(user -> Mono.just(user)
                        .zipWith(addressRepository.findById(user.getAddressId()))
                        .map(result -> {
                            User u = result.getT1();
                            result.getT1().setAddress(result.getT2());
                            return u;
                        }))
                .map(UserHelper::convertToUserView);
    }

    public Mono<Void> deleteByUuid(UUID uuid) {
        return userRepository.deleteByUuid(uuid);
    }

}
