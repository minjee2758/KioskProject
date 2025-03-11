package Lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk4 {
    static private double totalPrice =0; //총액을 저장
    Scanner scanner = new Scanner(System.in); //스캐너 불러오기
    Menu menu = new Menu();
    List<String> category = new ArrayList<>(menu.getMenuCartegory().keySet());

    //키오스크 실행하기
    public void start(){
        System.out.println("햄버거 키오스크를 시작합니다!");
        SelectMenuCartegory();
    }

    //메인메뉴 고르기
    public void SelectMenuCartegory(){
        while (true){
            int i=1;
            for (String s : category) {
                System.out.println(i +". "+s);
                i++;
            }
            System.out.println("0. 키오스크 종료");
            //메뉴 입력 받기
            System.out.print("→ 원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            try {
                if (select == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    String menuCartegory = findMenuCartegory(select);
                    System.out.println("> "+ menuCartegory+"를 선택하셨습니다 <");
                    System.out.println();
                    System.out.println("=================== [ "+menuCartegory+" ] ===================");
                    SelectMenuDetail(menuCartegory); //세부 메뉴로 넘어가기
                }
            } catch (IllegalArgumentException e){
                System.out.println("error : "+e.getMessage()); //에러 뱉기
            }
        }
    }

    //세부 메뉴 선택하기
    public void SelectMenuDetail(String menuCartegory){
        for (int i = 0; i<menu.getBurgers().size(); i++){
            System.out.println(menu.getBurgers().get(i).getNumbering() + ". " + menu.getBurgers().get(i).getName() + " " +
                    menu.getBurgers().get(i).getPrice() +"W  " + menu.getBurgers().get(i).getDescription());
        }
        for (int i=0; i<menu.getMenuCartegory().get(menuCartegory).size(); i++){
            System.out.println(menu.getMenuCartegory());
        }

        System.out.println("0. 뒤로가기");
        System.out.println("---------------------------------------------------");

            //메뉴 입력 받기
            System.out.print("→ 원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            try {
                if (select == 0){
                    System.out.println("뒤로 가기");
                } else {
                    String MenuName = findMenu(select);
                    System.out.println("> "+MenuName+"를 선택하셨습니다 <");
                    System.out.println();
                }
            } catch (IllegalArgumentException e){
                System.out.println("error : "+e.getMessage()); //에러 뱉기
            }

    }

    //가격 더하기
    public Double addPrice(int price){
        totalPrice += price;
        return totalPrice;
    }

    //카테고리명 찾기
    public String findMenuCartegory(int select){
        for (String s : category) {
            if (category.get(select-1).equals(s)){
                return s;
            }
        }
        throw new IllegalArgumentException(select+"번째 메뉴는 없습니다");
    }

    //메뉴명 찾기
    public String findMenu(int select) {
        if (select <0 || select >menu.getBurgers().size()){
            //번호 잘못 입력했을때 에러 던져주기
            throw new IllegalArgumentException(select+"번째 메뉴는 존재하지 않습니다");
        }
        return menu.getBurgers().get(select-1).getName();
    }

}
