package pl.lodz.webflux.webflux.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.webflux.webflux.demo.service.UserService;
import pl.lodz.webflux.webflux.demo.service.dto.UserInput;
import pl.lodz.webflux.webflux.demo.service.dto.UserView;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserView> create(@RequestBody UserInput userInput){
        return userService.createWithAddress(userInput);
    }

    @GetMapping
    public Flux<UserView> getAllAddresses(){
        return userService.getAll();
    }

    @GetMapping(path = "{uuid}")
    public Mono<ResponseEntity<UserView>> getByUuid(@PathVariable UUID uuid){
        return userService.getByUuid(uuid)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{uuid}")
    public Mono<Void> deleteByUuid(@PathVariable UUID uuid){
        return userService.deleteByUuid(uuid);
    }

}
