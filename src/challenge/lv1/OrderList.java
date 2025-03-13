package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<MenuItemCh1> orderList = new ArrayList<>(); //장바구니 리스트
    private double totalPrice = 0; //총액 변수

    //선택한 메뉴 담기 + 가격 더하기
    public void addOrderList(MenuItemCh1 menuItemCh1){
        orderList.add(menuItemCh1);
        totalPrice += menuItemCh1.getPrice();
    }

    public List<MenuItemCh1> getOrderList(){
        return orderList;
    }

    public void printOrderList(){
        System.out.println("아래와 같이 주문하시겠습니까? \n" +"[ Orders ]");
                for (MenuItemCh1 ordering : orderList) { //장바구니에 있는 메뉴 리스트 출력
                    System.out.println(ordering.getName() + "  | W "+ordering.getPrice() + "  | " + ordering.getDescription());
                }
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    //주문을 종료하면 리스트 초기화하기
    public void clearOrderList() {
        orderList.clear();
    }
}
