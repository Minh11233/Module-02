package Builder;

import Entity.Others.UsersInfo;

public class UsersInfoConcreteBuilder implements UsersInfoBuilder {
    private String name;
    private String email;
    private String address;
    private String dayOfBirth;
    private String phoneNumber;
    private String gender;
    @Override
    public UsersInfoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UsersInfoBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UsersInfoBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    @Override
    public UsersInfoBuilder setDayOfBirth(String age) {
        this.dayOfBirth = age;
        return this;
    }

    @Override
    public UsersInfoBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public UsersInfoBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public UsersInfo build() {
        return new UsersInfo(name, dayOfBirth, gender, phoneNumber, address, email);
    }
}
