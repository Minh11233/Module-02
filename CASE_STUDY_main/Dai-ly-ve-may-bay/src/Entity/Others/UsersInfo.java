package Entity.Others;

import Interface.writeToFile;

import java.io.Serializable;

public class UsersInfo implements Serializable, writeToFile {
    private String name;
    private String gender;

    private String email;
    private String address;
    private String dayOfBirth;
    private String phoneNumber;
    private static int count = 0;
    private int UserID;
    public UsersInfo(String name, String dayOfBirth, String gender, String phoneNumber, String email, String address) {
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        this.phoneNumber = phoneNumber;
        this.UserID = ++count;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String age) {
        this.dayOfBirth = age;
    }

    @Override
    public String toString() {
        return "\nTHÔNG TIN KHÁCH HÀNG: " + "\nHọ và tên: " + name + "\nGiới tính: " + gender
                + "\nNăm sinh: " + dayOfBirth + "\nEmail: " + email + "\nSố điện thoại: "
                + phoneNumber + "\nĐịa chỉ: " + address + "\nID khách hàng: " + UserID;
    }

    @Override
    public String writeToFile() {
        return name + ";" + dayOfBirth + ";" + gender + ";" + phoneNumber
                + ";" + email + ";" + address;
    }
}
