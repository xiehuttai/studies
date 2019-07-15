package _enum;

public enum Color {

    RED(0,"RED"),
    GREEN(1,"GREEN"),
    BLUE(2,"BLUE")
    ;

    private String color;

    private int number;

    Color(int number, String color) {
        this.color = color;
        this.number = number;
    }
}
