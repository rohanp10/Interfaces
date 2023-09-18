import java.awt.*;

public class BigRectangleFilter implements Filter{

    public BigRectangleFilter(){}

    @Override
    public boolean accept(Object x) {

        Rectangle rect = (Rectangle) x;

        double perimeter = ((2 * rect.width) + (2 * rect.height));

        if (perimeter > 10) {
            return true;
        }
        else {
            return false;
        }
    }

}
