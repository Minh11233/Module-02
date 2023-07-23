package Service;

import Entity.Others.UsersInfo;
import Utils.ReadFiles;

import java.util.List;

public class UsersInfoService {
    public static List<UsersInfo> usersInfo;
    static {
        usersInfo = ReadFiles.readUsersInfoData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv");
    }
}
