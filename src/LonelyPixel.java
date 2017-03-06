import org.jetbrains.annotations.Contract;

/**
 * Created by flex on 17-3-6.
 * no.531 Lonely Pixel I
 * @author flex
 */

public class LonelyPixel {

    private int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) return 0;
        int lsum = 0, csum = 0;
        for (char[] arr: picture) {
            int tmp = 0;
            for (char c: arr) {
                if (c=='B') tmp++;
            }
            if (tmp == 1) lsum ++;
        }
        for (int i=0; i<picture[0].length; i++) {
            int tmp = 0;
            for (int j=0; j<picture.length; j++) {
                if (picture[j][i]=='B') tmp++;
            }
            if (tmp == 1) csum ++;
        }
        return (lsum>csum)?csum:lsum;
    }

    public static void main(String[] args) {
        char[][] picture = new char[][] {
                {'W', 'B', 'W'},
                {'W', 'B', 'W'},
                {'W', 'W', 'B'}
        };
        LonelyPixel lp = new LonelyPixel();
        System.out.println(lp.findLonelyPixel(picture));
    }

}