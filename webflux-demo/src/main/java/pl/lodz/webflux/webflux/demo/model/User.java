package pl.lodz.webflux.webflux.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String pesel;

    private LocalDate dateOfBrith;

    @Column(value = "address_id")
    @JsonIgnore
    private Long addressId;

    @Transient
    private Address address;

}
