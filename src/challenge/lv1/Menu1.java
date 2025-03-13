package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class Menu1 {
    private final String category;
    private final List<MenuItem1> menuItem1;

    //생성자에서 카테고리명과 리스트를 함께 할당하기 -> 호출될때마다 새로운 리스트를 만든다.
    public Menu1(String category){
        this.category = category;
        this.menuItem1 = new ArrayList<>();
    }

    //메뉴 추가
    public void addMenus(String name, double price, String description){
        menuItem1.add(new MenuItem1(name, price, description));
    }

    //카테고리 리턴
    public String getMenuCategory(){
        return category;
    }
    //세부 메뉴 리턴
    public List<MenuItem1> getMenuItemCh1s(){
        return menuItem1;
    }
    public void printDetailMenus(){
        System.out.println("[ "+category +" ]");
        for (int i = 0; i< menuItem1.size(); i++){
            MenuItem1 menus = menuItem1.get(i);
            System.out.println(i+1 +". "+menus.getName() +" |  W "+ menus.getPrice()+" | " + menus.getDescription());
        }
    }

}
