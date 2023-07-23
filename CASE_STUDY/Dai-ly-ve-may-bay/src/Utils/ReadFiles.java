package Utils;

import Entity.Others.Revenue;
import Entity.Others.UsersInfo;
import Entity.Users.Customer;
import Entity.Users.Staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

    public class ReadFiles {
        public static List<String> readDataFromFile(String path) {
            List<String> objects = new ArrayList<>();
            try (FileReader fr = new FileReader(path);
                 BufferedReader bufferedReader = new BufferedReader(fr)) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    objects.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return objects;
        }

        public static List<Customer> readCustomerAccountsData(String path) {
            List<String> propertiesOfUsersList = readDataFromFile(path);
            List<Customer> customersList = new ArrayList<>();
            final int INDEX_OF_ACCOUNT = 0;
            final int INDEX_OF_PASSWORD = 1;
            for (String propertiesOfUsers : propertiesOfUsersList) {
                if (propertiesOfUsers.equals(propertiesOfUsersList.get(0))) {
                    continue;
                }
                String[] properties = propertiesOfUsers.split(";");
                customersList.add(new Customer(properties[INDEX_OF_ACCOUNT],properties[INDEX_OF_PASSWORD]));
            } return customersList;
        }

        public static List<Revenue> readRevenuesData(String path) {
            List<String> propertiesOfRevenuesList = readDataFromFile(path);
            List<Revenue> revenuesList = new ArrayList<>();
            final int INDEX_OF_BUY_DATE = 0;
            final int INDEX_OF_INCOME = 1;
            for (String propertiesOfRevenues : propertiesOfRevenuesList) {
                if (propertiesOfRevenues.equals(propertiesOfRevenuesList.get(0))) {
                    continue;
                }
                String[] properties = propertiesOfRevenues.split(";");
                revenuesList.add(new Revenue(properties[INDEX_OF_BUY_DATE],properties[INDEX_OF_INCOME]));
            } return revenuesList;
        }

        public static List<Staff> readStaffAccountsData(String path) {
            List<String> propertiesOfStaffsList = readDataFromFile(path);
            List<Staff> staffsList = new ArrayList<>();
            final int INDEX_OF_ACCOUNT = 0;
            final int INDEX_OF_PASSWORD = 1;
            for (String propertiesOfUsers : propertiesOfStaffsList) {
                if (propertiesOfUsers.equals(propertiesOfStaffsList.get(0))) {
                    continue;
                }
                String[] properties = propertiesOfUsers.split(";");
                staffsList.add(new Staff(properties[INDEX_OF_ACCOUNT],properties[INDEX_OF_PASSWORD]));
            } return staffsList;
        }

        public static List<UsersInfo> readUsersInfoData(String path) {
            List<String> propertiesOfUsersInfoList = readDataFromFile(path);
            List<UsersInfo> usersInfoList = new ArrayList<>();
            final int INDEX_OF_NAME = 0;
            final int INDEX_OF_DAYOFBIRTH = 1;
            final int INDEX_OF_GENDER = 2;
            final int INDEX_OF_PHONENUMBER = 3;
            final int INDEX_OF_EMAIL = 4;
            final int INDEX_OF_ADDRESS = 5;
            for (String propertiesOfUsersInfo: propertiesOfUsersInfoList) {
                if (propertiesOfUsersInfo.equals(propertiesOfUsersInfoList.get(0))) {
                    continue;
                }
                String[] properties = propertiesOfUsersInfo.split(";");
                usersInfoList.add(new UsersInfo(
                        properties[INDEX_OF_NAME],
                        properties[INDEX_OF_DAYOFBIRTH],
                        properties[INDEX_OF_GENDER],
                        properties[INDEX_OF_PHONENUMBER],
                        properties[INDEX_OF_EMAIL],
                        properties[INDEX_OF_ADDRESS]
                ));
            }
            return usersInfoList;
        }
    }
