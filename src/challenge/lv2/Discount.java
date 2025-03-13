package challenge.lv2;

import java.util.Scanner;

public class Discount {
    Scanner scanner = new Scanner(System.in);

    public void discountPrice(double price){
        System.out.println("할인 정보를 입력해주세요");
        for (Customer type : Customer.values()) {
            System.out.println(type.getNum()+". "+ type.getTitle() +" : " + String.format("%.0f",type.getDiscount()*100) +"%");
        }
        int num = scanner.nextInt();
        Double customerType = Customer.findDiscount(num);
        if (num>4 || num<1){
            throw new IllegalArgumentException("잘못 입력하셨습니다");
        } else {
            System.out.println("할인을 적용합니다!");
            double discountPrice = price*customerType;
            System.out.println("주문이 완료되었습니다. 금액은 W "+String.format("%.1f",price-discountPrice)+" 입니다.");
        }
    }
}
