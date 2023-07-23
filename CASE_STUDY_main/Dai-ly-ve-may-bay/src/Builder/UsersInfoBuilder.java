package Builder;

import Entity.Others.UsersInfo;

public interface UsersInfoBuilder {
    UsersInfoBuilder setName(String name);
    UsersInfoBuilder setEmail(String email);
    UsersInfoBuilder setAddress(String address);
    UsersInfoBuilder setDayOfBirth(String dayOfBirth);

    UsersInfoBuilder setPhoneNumber(String phoneNumber);
    UsersInfoBuilder setGender(String gender);

    UsersInfo build();
}
