/**
 * Created by flex on 17-2-23.
 * @author flex
 * no.495 Teemo Attacking
 */

public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int poisonedTime = 0;
        for (int i=1; i<timeSeries.length; i++) {
            int timescale = timeSeries[i] - timeSeries[i-1];
            poisonedTime += (timescale >= duration)?duration:timescale;
        }
        return poisonedTime + duration;
    }

    public static void main(String[] args) {
        FindPoisonedDuration fpd = new FindPoisonedDuration();
        System.out.println(fpd.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
