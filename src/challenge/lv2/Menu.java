package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItem;

    //생성자에서 카테고리명과 리스트를 함께 할당하기 -> 호출될때마다 새로운 리스트를 만든다.
    public Menu(String category){
        this.category = category;
        this.menuItem = new ArrayList<>();
    }

    //메뉴 추가
    public void addMenus(String name, double price, String description){
        menuItem.add(new MenuItem(name, price, description));
    }

    //카테고리 리턴
    public String getMenuCategory(){
        return category;
    }
    //세부 메뉴 리턴
    public List<MenuItem> getMenuItemCh1s(){
        return menuItem;
    }
    public void printDetailMenus(){
        System.out.println("[ "+category +" ]");
        for (int i = 0; i< menuItem.size(); i++){
            MenuItem menus = menuItem.get(i);
            System.out.println(i+1 +". "+menus.getName() +" |  W "+ menus.getPrice()+" | " + menus.getDescription());
        }
    }

}
