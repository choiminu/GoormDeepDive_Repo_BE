package task2;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println("직사각형 클래스 생성");
        oblong oblong = new oblong(10,20);
        System.out.println("직사각형의 넓이 = " + oblong.extent());
    }
}

class oblong {
    int width;
    int length;

    public oblong(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int extent() {
        return width * length;
    }
}
