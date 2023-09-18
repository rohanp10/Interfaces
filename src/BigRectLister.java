import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {

    public static void main(String[] args) {

        ArrayList<Rectangle> rects = new ArrayList<>();

        rects.add(new Rectangle(2, 4));
        rects.add(new Rectangle(1, 2));
        rects.add(new Rectangle(5, 10));
        rects.add(new Rectangle(4, 6));
        rects.add(new Rectangle(2, 2));
        rects.add(new Rectangle(8, 4));
        rects.add(new Rectangle(10, 20));
        rects.add(new Rectangle(1, 1));
        rects.add(new Rectangle(4, 3));
        rects.add(new Rectangle(3, 1));

        ArrayList<Rectangle> filteredList = collectAll(rects);

        System.out.println("\nRectangles with Big Perimeters:\n");

        for (Rectangle rect: filteredList) {
            System.out.println("Width: " + rect.width + ", Height: " + rect.height);
        }

    }

    public static ArrayList<Rectangle> collectAll(ArrayList<Rectangle> list) {

        BigRectangleFilter filter = new BigRectangleFilter();

        ArrayList<Rectangle> filteredList = new ArrayList<>();

        for (Rectangle rect: list) {

            if (filter.accept(rect)) {
                filteredList.add(rect);
            }
        }

        return filteredList;
    }

}
