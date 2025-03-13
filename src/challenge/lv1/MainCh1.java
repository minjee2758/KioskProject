package challenge.lv1;

public class MainCh1 {
    public static void main(String[] args) {
        //메뉴 추가하기
        MenuCh1 BurgerList = new MenuCh1("Burgers");
        MenuCh1 DrinkList = new MenuCh1("Drinks");
        MenuCh1 DessertList = new MenuCh1("Desserts");

        BurgerList.addMenus("ShackBurger   ", 6.9, "토마토, 양상추, 쉑 소스가 토핑된 치즈버거");
        BurgerList.addMenus("SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        BurgerList.addMenus("Cheeseburger  ", 6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        BurgerList.addMenus("Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        DrinkList.addMenus("Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드");
        DrinkList.addMenus("Fifty/Fifty", 3.5, "쉐이크쉑의 시그니처 음료");
        DrinkList.addMenus("Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 등");

        DessertList.addMenus("Dark Chocolate Cake", 5.5,"인생은 초콜릿");
        DessertList.addMenus("Cheese Fries", 5.2, "바삭한 감자와 치즈");


        //키오스크의 addMenus 메서드를 통해 각 리스트를 추가해주기
        KioskCh1 kiosk = new KioskCh1();
        kiosk.addMenus(BurgerList);
        kiosk.addMenus(DrinkList);
        kiosk.addMenus(DessertList);
        kiosk.start();
    }

}
