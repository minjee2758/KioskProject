package Challenge.Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderList {
    private final List<MenuItemCh1> orderList = new ArrayList<>(); //장바구니 리스트
    private double totalPrice = 0; //총액 변수
    Scanner scanner = new Scanner(System.in);



    //선택한 메뉴 담기 + 가격 더하기
    public void AddOrderList(String name, double price, String description){
        orderList.add(new MenuItemCh1(name, price, description));
        totalPrice += price;
    }

    //주문 내역 확인시켜주기
    public void getOrderList() {
        //장바구니에 물건이 들어있으면
        if (orderList.size()>0){
            System.out.println("[ Order Menu ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.\n"
                    + "5. Cancel       | 진행중인 주문을 취소합니다.");
            System.out.println("입력 | ");
            int orderSelect = scanner.nextInt();
            if (orderSelect==4){
                System.out.println("아래와 같이 주문하시겠습니까? \n" +"[ Orders ]");
                for (MenuItemCh1 ordering : orderList) { //장바구니에 있는 메뉴 리스트 출력
                    System.out.println(ordering.getName() + "  | W "+ordering.getPrice() + "  | " + ordering.getDescription());
                }
                System.out.println("\n" +"[ Total ] \n" + "W " + totalPrice);
            }
        }
    }

    //주문을 종료하면 리스트 초기화하기
    public void clearOrderList() {
        orderList.clear();
    }
}
