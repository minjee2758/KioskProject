package Lv1;

import java.util.Scanner;

public class KioskMain1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //메뉴 번호 입력받을 변수 select 선언
        //메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]\n" +
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                "0. 종료      | 종료\n");
        //종료할 때까지 반복
        while (true){
            System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();
            if (select==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println(select+"번 메뉴를 주문합니다.");
            }

        }
    }
}
