package sri.misc;

/**
 *  https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrapRainWater {
    public static int trappedRainWater (int[] elevation) {
        int[] leftSweep = new int[elevation.length];
        int[] rightSweep = new int[elevation.length];

        leftSweep[0] = elevation[0];
        for(int i=1; i<elevation.length;i++) {
            leftSweep[i] = Math.max(leftSweep[i-1],elevation[i]);
        }

        rightSweep[elevation.length-1] = elevation[elevation.length-1];
        for(int j=elevation.length-2;j>=0;j--) {
            rightSweep[j] = Math.max(rightSweep[j+1],elevation[j]);
        }

        int water = 0;
        for(int i=0; i<elevation.length; i++) {
            water += (Math.min(leftSweep[i],rightSweep[i]) - elevation[i]);
        }

        return water;
    }

    public static void main(String[] args) {
        System.out.println(trappedRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
