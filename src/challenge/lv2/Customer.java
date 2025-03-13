package challenge.lv2;

public enum Customer {
    PATRIOT(1, 0.1), //1번 국가유공자
    SOLDIER(2, 0.05), //2번 군인
    STUDENT(3, 0.03),//3번 학생
    DEFAULT(4, 0); //4번 일반인

    private final int num;
    private final double discount;

    Customer(int num, double discount){
        this.num = num;
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }
    public int getNum(){
        return num;
    }

    //선택한 번호의 할인을 찾아서 번호-할인유형 매칭
    public double findDiscount(int num){
        for (Customer type : Customer.values()){
            if (type.getNum() == num){
                return type.getDiscount();//찾은 할인 유형을 할인%로 반환해주기
            }
        }
        throw new IllegalArgumentException("잘못된 번호를 입력했습니다."); //번호 잘못 입력했을때
    }
}