package Lv3;

public class MenuItem3 {
    private final int numbering;
    private final String name;
    private final double price;
    private final String description;

    public MenuItem3(int numbering,String name, double price, String description){
        this.numbering = numbering;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //getter
    //메뉴 번호 가져오기'
    public int getNumbering(){
        return numbering;
    }
    //햄버거 이름 가져오기
    public String getName(){
        return name;
    }
    //햄버거 가격 가져오기
    public double getPrice(){
        return price;
    }
    //설명 가져오기
    public String getDescription(){
        return description;
    }
}
