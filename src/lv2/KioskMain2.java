package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //스캐너 불러오기
        List<MenuItem2> burgers = new ArrayList<>(); //햄버거 메뉴 저장할 리스트 만들기 -> 리스트에 클래스도 타입으로 설정가능

        burgers.add(new MenuItem2("ShackBurger   ", 6.9, "토마토, 양상추, 쉑 소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem2("SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem2("Cheeseburger  ", 6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem2("Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        System.out.println("햄버거 키오스크를 시작합니다--------------");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i=0; i<burgers.size(); i++){
            //get으로 i번째 리스트의 항목을 꺼내오자
            System.out.println((i+1) +". "+burgers.get(i).getName() + "   | W "+burgers.get(i).getPrice()+" | "+burgers.get(i).getDescription());
        }
        System.out.println("0. 종료              | 키오스크를 종료합니다");

        double totalPrice =0; //총액을 저장

        //사용자가 종료할때까지 반복하기
        while (true) {
            //메뉴 입력 받기
            System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
            int select = scanner.nextInt();

            if (select == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println(burgers.get(select-1).getName()+"를 장바구니에 넣었습니다.");
                totalPrice += burgers.get(select-1).getPrice(); //가격 합산하기
                System.out.println("지금까지 총액은 "+totalPrice+"W");
            }
        }

    }

}
