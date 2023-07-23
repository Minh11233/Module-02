package Service;

import Entity.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryService {
    private static final List<Category> CategoryList;
    static {
        CategoryList = new ArrayList<>();
        addCategory("Thời Trang Nam"); // index: 0 -  ID: 1
        addCategory("Điện Thoại & Phụ Kiện");
        addCategory("Thiết bị Điện tử");
        addCategory("Đồng hồ");
    }

    public static void addCategory(String name) {
        CategoryList.add(new Category(name));

    }

    public static void removeCategory(int id) {
        for (Category Element: CategoryList) {
            if (Element.getId() == id) {
                CategoryList.remove(Element);
                break;
            }
        }
    }

    public static void displayAllCategory() {
        CategoryList.forEach(System.out::println);
    }
}

