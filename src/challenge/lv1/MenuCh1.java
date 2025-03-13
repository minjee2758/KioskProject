package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class MenuCh1 {
    private final String category;
    private final List<MenuItemCh1> menuItemCh1s;

    //생성자에서 카테고리명과 리스트를 함께 할당하기 -> 호출될때마다 새로운 리스트를 만든다.
    public MenuCh1(String category){
        this.category = category;
        this.menuItemCh1s = new ArrayList<>();
    }

    //메뉴 추가
    public void addMenus(String name, double price, String description){
        menuItemCh1s.add(new MenuItemCh1(name, price, description));
    }

    //카테고리 리턴
    public String getMenuCategory(){
        return category;
    }
    //세부 메뉴 리턴
    public List<MenuItemCh1> getMenuItemCh1s(){
        return menuItemCh1s;
    }
    public void printDetailMenus(){
        System.out.println("[ "+category +" ]");
        for (int i = 0; i<menuItemCh1s.size(); i++){
            MenuItemCh1 menus = menuItemCh1s.get(i);
            System.out.println(i+1 +". "+menus.getName() +" |  W "+ menus.getPrice()+" | " + menus.getDescription());
        }
    }

}
