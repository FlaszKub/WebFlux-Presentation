package pl.lodz.webflux.webflux.demo.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import pl.lodz.webflux.webflux.demo.model.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findByUuid(UUID uuid);

    Mono<Void> deleteByUuid(UUID uuid);

}
