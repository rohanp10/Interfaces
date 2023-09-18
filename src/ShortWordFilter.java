public class ShortWordFilter implements Filter{

    public ShortWordFilter(){}
    @Override
    public boolean accept(Object x) {

        String word = x.toString();

        if (word.length() < 5) {
            return true;
        }
        else {
            return false;
        }
    }
}
