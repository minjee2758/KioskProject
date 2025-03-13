package challenge.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskCh1 {
    Scanner scanner = new Scanner(System.in); //스캐너 불러오기
    private final List<MenuCh1> menuCh1s;
    private final OrderList orderList = new OrderList(); //장바구니 클래스 불러오기
    private int selectNum; //선택할 수 있는 입력 번호의 개수 (장바구니에 메뉴가 담기면 +2)


    public KioskCh1(){
        this.menuCh1s = new ArrayList<>();
    }

    public void addMenus(MenuCh1 menuCh1){
        menuCh1s.add(menuCh1);
    }

    //키오스크 실행하기
    public void start(){
        System.out.println("햄버거 키오스크를 시작합니다!");
        selectMenuCategory();
    }

    //카테고리 고르기
    public void selectMenuCategory(){
        while (true){
            selectNum =3;
            System.out.println("================[ MAIN MENU ]================");
            int i=1;
            //메뉴 카테고리 출력
            for (MenuCh1 menuCh1 : menuCh1s) {
                System.out.println(i++ +". " + menuCh1.getMenuCategory());
            }
            System.out.println("0. 키오스크 종료");

            //장바구니 리스트 보여주기
            if (!orderList.getOrderList().isEmpty()) {
                System.out.println("[ Order Menu ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.\n"
                    + "5. Cancel       | 진행중인 주문을 취소합니다.");
                selectNum+=2;
            }

            //메뉴 입력 받기
            System.out.print("→ 원하는 번호를 입력하세요 : ");
            int select = scanner.nextInt();

            //switch-case로 번호 선택 로직
            switch (select){
                case 0:
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0); //break는 switch문만 탈출
                case 4 :
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
                case 5 :
                    System.out.println("주문 취소합니다");
                    orderList.clearOrderList(); //장바구니 비우기
                    break;
                default:
                    MenuCh1 selectCategory = menuCh1s.get(select-1); //해당하는 카테고리의 리스트 찾기
                    System.out.println("> "+ menuCh1s.get(select-1).getMenuCategory()+"를 선택하셨습니다 <");
                    System.out.println();
                    selectMenuDetail(selectCategory); //세부 메뉴로 넘어가기
            }
        }
    }

    //세부 메뉴 선택하기 - 리스트 받아서
    public void selectMenuDetail(MenuCh1 menuCh1){
        menuCh1.printDetailMenus(); //메뉴리스트 출력
        System.out.println("0. 뒤로가기");
        System.out.println("---------------------------------------------------");
        //메뉴 입력 받기
        System.out.print("→ 원하는 메뉴의 번호를 입력하세요 : ");
        int selectMenu = scanner.nextInt();
        switch (selectMenu){
            case 0 :
                System.out.println("카테고리 선택창으로 돌아갑니다");
            default:
                MenuItemCh1 DetailMenu = menuCh1.getMenuItemCh1s().get(selectMenu-1);
                System.out.println(DetailMenu.getName()+"를 선택하시겠어요?");
                System.out.println("1. 선택       2. 취소");
                int lastSelect = scanner.nextInt();
                if (lastSelect==1){
                    //장바구니에 추가하기
                    orderList.addOrderList(DetailMenu);
                    System.out.println(DetailMenu.getName()+"을 장바구니에 담았습니다!!");
                } else if (lastSelect==2) {
                    System.out.println("재선택합니다");
                }
        }

    }


}
