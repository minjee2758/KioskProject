package Lv2;

public class MenuItem2 {
    private String name;
    private double price;
    private String description;

    public MenuItem2(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //getter
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
