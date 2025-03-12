package challenge.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskCh1 {
    Scanner scanner = new Scanner(System.in); //스캐너 불러오기
    MenuCh1 menu = new MenuCh1();
    List<String> category = new ArrayList<>(menu.getMenuCategory().keySet());
    OrderList orderList = new OrderList(); //장바구니 클래스 불러오기

    //키오스크 실행하기
    public void start(){
        System.out.println("햄버거 키오스크를 시작합니다!");
        SelectMenuCategory();
    }

    //카테고리 고르기
    public void SelectMenuCategory(){
        while (true){
            System.out.println("================[ MAIN MENU ]================");
            int i=1;
            for (String s : category) {
                System.out.println(i++ +". "+s);
            }
            System.out.println("0. 키오스크 종료");

            //장바구니 리스트 보여주기
            if (!orderList.getOrderList().isEmpty()) {
                System.out.println("[ Order Menu ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.\n"
                    + "5. Cancel       | 진행중인 주문을 취소합니다.");
            }

            //메뉴 입력 받기
            System.out.print("→ 원하는 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            try {
                if (orderList.getOrderList().isEmpty()){
                    if (select == 0){
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    } else {
                        String menuCategory = findMenuCategory(select);
                        System.out.println("> "+ menuCategory+"를 선택하셨습니다 <");
                        System.out.println();
                        System.out.println("[ "+menuCategory+" ]");
                        SelectMenuDetail(menuCategory); //세부 메뉴로 넘어가기
                    }
                } else {
                    if (select == 0){
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    } else if (select == 4) {
                        orderList.printOrderList();
                        System.out.println("\n" +"[ Total ] \n" + "W " + orderList.getTotalPrice());
                        System.out.println("1. 주문      2. 메뉴판");
                        int lastSelect = scanner.nextInt();
                        if (lastSelect == 1){
                            System.out.println("주문이 완료되었습니다. 금액은 W "+orderList.getTotalPrice()+" 입니다.");
                            break;
                        } else {
                            System.out.println("다시 메뉴판으로 이동합니다");
                        }
                    } else if (select==5) {
                        System.out.println("주문 취소합니다");
                        break;
                    } else {
                        String menuCategory = findMenuCategory(select);
                        System.out.println("> "+ menuCategory+"를 선택하셨습니다 <");
                        System.out.println();
                        System.out.println("[ "+menuCategory+" ]");
                        SelectMenuDetail(menuCategory); //세부 메뉴로 넘어가기
                    }
                }
            } catch (IllegalArgumentException e){
                System.out.println("error : "+e.getMessage()); //에러 뱉기
            }
        }
    }

    //세부 메뉴 선택하기
    public void SelectMenuDetail(String menuCategory){
        List<MenuItemCh1> DetailMenu = menu.findDetailMenu(menuCategory);
        int i = 1;
        for (MenuItemCh1 detailMenu : DetailMenu) {
            System.out.println(i++ + ". " + detailMenu.getName() + " " +
                    detailMenu.getPrice() + "W  " + detailMenu.getDescription());
        }
        System.out.println("0. 뒤로가기");
        System.out.println("---------------------------------------------------");

            //메뉴 입력 받기
            System.out.print("→ 원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            try {
                if (select == 0){
                    System.out.println("카테고리 선택창으로 돌아갑니다");
                } else {
                    String MenuName = findMenu(DetailMenu, select);
                    System.out.println("> "+MenuName+"를 선택하셨습니다 <");
                    //장바구니에 추가하기
                    orderList.AddOrderList(DetailMenu.get(select-1).getName(), DetailMenu.get(select-1).getPrice(),DetailMenu.get(select-1).getDescription());
                }
            } catch (IllegalArgumentException e){
                System.out.println("error : "+e.getMessage()); //에러 뱉기
            }

    }

    //카테고리명 찾기
    public String findMenuCategory(int select){
        for (String s : category) {
            if (category.get(select-1).equals(s)){
                return s;
            }
        }
        throw new IllegalArgumentException(select+"번째 메뉴는 없습니다");
    }

    //메뉴명 찾기
    public String findMenu(List<MenuItemCh1> DetailMenu, int select) {
        if (select <0 || select >DetailMenu.size()){
            //번호 잘못 입력했을때 에러 던져주기
            throw new IllegalArgumentException(select+"번째 메뉴는 존재하지 않습니다");
        }
        return DetailMenu.get(select-1).getName();
    }

}
