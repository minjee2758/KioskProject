package challenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderList {
    private List<MenuItem> orderList = new ArrayList<>(); //장바구니 리스트
    private double totalPrice = 0; //총액 변수
    Scanner scanner = new Scanner(System.in);

    //선택한 메뉴 담기 + 가격 더하기
    public void addOrderList(MenuItem menuItem){
        orderList.add(menuItem);
        totalPrice += menuItem.getPrice();
    }

    public List<MenuItem> getOrderList(){
        return orderList;
    }

    public void printOrderList(){
        System.out.println("\n[ Orders ]");
        AtomicInteger i= new AtomicInteger(1); //스트림 내부에서 인덱스를 증가시키기 위해 AtomicInteger로 정의하기
//        for (MenuItem ordering : orderList) { //장바구니에 있는 메뉴 리스트 출력
//             System.out.println(i++ + ". " +String.format("%-15s", ordering.getName()) + "  | W "+ordering.getPrice() + "  | " + ordering.getDescription());
//                }
        orderList.forEach(menu
                -> System.out.println(i.getAndIncrement()+
                ". " + String.format("%-15s", menu.getName()) + "  | W "+menu.getPrice() + "  | " + menu.getDescription()));
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    //주문을 종료하면 리스트 초기화하기
    public void clearOrderList() {
        orderList.clear();
    }

    //선택한 품목 삭제하기
    public void removeItem(){
        printOrderList();
        System.out.print("삭제하고 싶은 품목의 번호를 입력하세요 : ");
        int select = scanner.nextInt();
        if (select>orderList.size() || select<1){
            System.out.println("잘못된 입력입니다 다시 입력하세요");
            removeItem();
        } else {
            System.out.println(orderList.get(select-1).getName() +"품목을 삭제합니다");
            totalPrice-=orderList.get(select-1).getPrice();
            orderList = orderList.stream().filter(menuItem
                    -> !menuItem.getName().equals(orderList.get(select-1).getName())).collect(Collectors.toList());
        }
    }
}