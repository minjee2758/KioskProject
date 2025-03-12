package Challenge.Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MenuCh1 {
    //HashMap 이용해서 MenuCategory 리스트에 다 넣기 - 카테고리로 활용하자
    private final HashMap<String, List<MenuItemCh1>> MenuCategory = new LinkedHashMap<>();
    //햄버거 메뉴 리스트
    private final List<MenuItemCh1> Burgers = new ArrayList<>();
    //음료수 리스트
    private final List<MenuItemCh1> Drinks = new ArrayList<>();
    //디저트 리스트
    private final List<MenuItemCh1> Desserts = new ArrayList<>();

    public MenuCh1(){
        Burgers.add(new MenuItemCh1("ShackBurger   ", 6.9, "토마토, 양상추, 쉑 소스가 토핑된 치즈버거"));
        Burgers.add(new MenuItemCh1("SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burgers.add(new MenuItemCh1("Cheeseburger  ", 6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Burgers.add(new MenuItemCh1("Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Drinks.add(new MenuItemCh1("Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"));
        Drinks.add(new MenuItemCh1("Fifty/Fifty", 3.5, "쉐이크쉑의 시그니처 음료"));
        Drinks.add(new MenuItemCh1("Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 등"));

        Desserts.add(new MenuItemCh1("Dark Chocolate Cake", 5.5,"인생은 초콜릿"));
        Desserts.add(new MenuItemCh1("Cheese Fries", 5.2, "바삭한 감자와 치즈"));

        MenuCategory.put("Burgers", Burgers);
        MenuCategory.put("Drinks", Drinks);
        MenuCategory.put("Desserts", Desserts);
    }

    //카테고리 뱉기
    public HashMap<String, List<MenuItemCh1>> getMenuCategory(){
        return MenuCategory;
    }

    //카테고리에 맞는 세부 메뉴 출력하기
    public List<MenuItemCh1> findDetailMenu(String MenuName){
        if (MenuName.equals("Burgers")){
            return getBurgers();
        } else if (MenuName.equals("Drinks")) {
            return getDrinks();
        } else if (MenuName.equals("Desserts")){
            return getDesserts();
        } else {
            throw new IllegalArgumentException("그런 카테고리는 없습니다.");
        }
    }

    //세부 메뉴 리스트
    public List<MenuItemCh1> getBurgers() {
        return Burgers;
    }
    public  List<MenuItemCh1> getDrinks(){
        return Drinks;
    }
    public List<MenuItemCh1> getDesserts(){
        return Desserts;
    }
}
