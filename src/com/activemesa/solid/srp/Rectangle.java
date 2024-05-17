package com.activemesa.solid.srp;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
class Rectangle {

    protected int width, height;

    public int getArea() {
        return width * height;
    }

    public boolean isSquare() {
        return width == height;
    }
}

@NoArgsConstructor
class Square extends Rectangle {

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RectangleFactory {
    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }

    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }
}

class LSPDemo {
    // maybe conform to ++
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setHeight(5);
        sq.setWidth(10);
        useIt(sq);
    }
}