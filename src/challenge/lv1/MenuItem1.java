package challenge.lv1;

public class MenuItem1 {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem1(String name, double price, String description){
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
