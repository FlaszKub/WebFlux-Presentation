package pl.lodz.webflux.webflux.demo.service.dto.helper;

import pl.lodz.webflux.webflux.demo.model.Address;
import pl.lodz.webflux.webflux.demo.model.User;
import pl.lodz.webflux.webflux.demo.service.dto.UserInput;
import pl.lodz.webflux.webflux.demo.service.dto.UserView;

import java.util.UUID;

public class UserHelper {

    public static User prepareUser(UserInput userInput, Address address) {
        return User.builder()
                .uuid(UUID.randomUUID())
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .pesel(userInput.getPesel())
                .dateOfBrith(userInput.getDateOfBrith())
                .addressId(address.getId())
                .address(address)
                .build();
    }

    public static UserView convertToUserView(User user) {
        return UserView.builder()
                .uuid(user.getUuid())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .pesel(user.getPesel())
                .dateOfBrith(user.getDateOfBrith())
                .address(AddressHelper.convertToAddressView(user.getAddress()))
                .build();
    }

}
