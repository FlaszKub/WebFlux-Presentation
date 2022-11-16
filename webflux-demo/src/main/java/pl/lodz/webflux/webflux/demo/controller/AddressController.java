package pl.lodz.webflux.webflux.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.webflux.webflux.demo.service.AddressService;
import pl.lodz.webflux.webflux.demo.service.dto.AddressInput;
import pl.lodz.webflux.webflux.demo.service.dto.AddressView;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/addresses")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AddressView> create(@RequestBody AddressInput addressInput){
        return addressService.create(addressInput);
    }

    @GetMapping
    public Flux<AddressView> getAllAddresses(){
        return addressService.getAll();
    }

    @GetMapping(path = "{uuid}")
    public Mono<ResponseEntity<AddressView>> getByUuid(@PathVariable UUID uuid){
        return addressService.getByUuid(uuid)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{uuid}")
    public Mono<Void> deleteByUuid(@PathVariable UUID uuid){
        return addressService.deleteByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    public Mono<ResponseEntity<AddressView>> updateByUuid(@PathVariable UUID uuid,@RequestBody AddressInput addressInput){
        return addressService.updateAddress(uuid,addressInput)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

}
