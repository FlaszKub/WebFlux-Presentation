package pl.lodz.webflux.webflux.demo.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import pl.lodz.webflux.webflux.demo.model.Address;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AddressRepository extends R2dbcRepository<Address, Long> {

    Mono<Address> findByUuid(UUID uuid);

    Mono<Void> deleteByUuid(UUID uuid);

}
