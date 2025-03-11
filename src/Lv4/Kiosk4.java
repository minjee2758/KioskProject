package Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk3 {
    static private final List<MenuItem3> burgers = new ArrayList<>(); //햄버거 메뉴 리스트 만들기
    static private double totalPrice =0; //총액을 저장

    public Kiosk3(){
        burgers.add(new MenuItem3(1,"ShackBurger   ", 6.9, "토마토, 양상추, 쉑 소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem3(2,"SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem3(3,"Cheeseburger  ", 6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem3(4,"Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    //키오스크 실행하기
    public void start(){
        System.out.println("햄버거 키오스크를 시작합니다--------------");
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem3 burger : burgers) {
            System.out.println(burger.getNumbering()+". " +burger.getName() + "   | W "+burger.getPrice()+" | "+burger.getDescription());
        }
        System.out.println("0. 종료              | 키오스크를 종료합니다");
    }

    //메뉴 선택하기
    public void OrderByKiosk(){
        Scanner scanner = new Scanner(System.in); //스캐너 불러오기
        while (true) {
            //메뉴 입력 받기
            System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            try {
                if (select == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    String MenuName = findMenu(select);
                    System.out.println(MenuName+"를 선택하셨습니다");
                    System.out.println("총액은 "+String.format("%.1f",totalPrice)+"W"); //가격 합산하기
                    System.out.println("총액은 "+totalPrice+"W");
                    System.out.println("======================");
                }
            } catch (IllegalArgumentException e){
                System.out.println("error : "+e.getMessage()); //에러 뱉기
            }

        }
    }

    public String findMenu(int select) {
        if (select <0 || select >burgers.size()){
            //번호 잘못 입력했을때 에러 던져주기
            throw new IllegalArgumentException(select+"번째 메뉴는 존재하지 않습니다");
        }
        return  burgers.get(select-1).getName();
    }

}
