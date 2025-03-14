package challenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
    Scanner scanner = new Scanner(System.in); //스캐너 불러오기
    private final List<Menu> menu;
    private final OrderList orderList = new OrderList(); //장바구니 클래스 불러오기

    public Kiosk(){
        this.menu = new ArrayList<>();
    }

    public void addMenus(Menu menu){
        this.menu.add(menu);
    }

    //키오스크 실행하기
    public void start(){
        System.out.println("햄버거 키오스크를 시작합니다!");
        selectMenuCategory();
    }

    //카테고리 고르기
    public void selectMenuCategory(){
        while (true){
            int selectNum =3;
            System.out.println("================[ MAIN MENU ]================");
            AtomicInteger i = new AtomicInteger(1);
            //메뉴 카테고리 출력
//            for (Menu menu : this.menu) {
//                System.out.println(i++ +". " + menu.getMenuCategory());
//            }
            menu.forEach(menus -> System.out.println(i.getAndIncrement() + ". "+ menus.getMenuCategory()));
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
            if (select<0 || select>selectNum){
                throw new IllegalArgumentException(select + "번은 존재하지 않습니다");
            }

            //switch-case로 번호 선택 로직
            switch (select){
                case 0:
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0); //break는 switch문만 탈출
                case 4 :
                    orderList.printOrderList();
                        System.out.println("\n" +"[ Total ] \n" + "W " + String.format("%.1f",orderList.getTotalPrice()));
                        System.out.println("1. 주문      2. 메뉴판      3. 메뉴 삭제");
                        int lastSelect = scanner.nextInt();
                        try {
                            if (lastSelect == 1){
                                Discount discount = new Discount();
                                discount.discountPrice(orderList.getTotalPrice());
                                System.exit(0);
                            }
                            else if(lastSelect==2){
                                System.out.println("다시 메뉴판으로 이동합니다");
                                break;
                            } else if( lastSelect == 3){
                                orderList.removeItem();
                                System.out.println("다시 메뉴판으로 이동합니다");
                                break;
                            }
                        }catch (IllegalArgumentException e){
                                System.out.println(e);
                        }
                case 5 :
                    System.out.println("주문 취소합니다");
                    orderList.clearOrderList(); //장바구니 비우기
                    break;
                default:
                    Menu selectCategory = menu.get(select-1); //해당하는 카테고리의 리스트 찾기
                    System.out.println("> "+ menu.get(select-1).getMenuCategory()+"를 선택하셨습니다 <");
                    System.out.println();
                    selectMenuDetail(selectCategory); //세부 메뉴로 넘어가기
            }
        }
    }

    //세부 메뉴 선택하기 - 리스트 받아서
    public void selectMenuDetail(Menu menu){
        menu.printDetailMenus(); //메뉴리스트 출력
        System.out.println("0. 뒤로가기");
        System.out.println("---------------------------------------------------");
        //메뉴 입력 받기
        System.out.print("→ 원하는 메뉴의 번호를 입력하세요 : ");
        int selectMenu = scanner.nextInt();
        switch (selectMenu){
            case 0 :
                System.out.println("카테고리 선택창으로 돌아갑니다");
            default:
                MenuItem DetailMenu = menu.getMenuItemCh1s().get(selectMenu-1);
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
