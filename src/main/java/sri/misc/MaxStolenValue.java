package sri.misc;

/**
 *  https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
 */
public class MaxStolenValue {
    public static long maxLoot(int[] houseValues) {
        if(houseValues.length == 0)
            return 0;
        if(houseValues.length == 1)
            return houseValues[1];
        if(houseValues.length == 2)
            return Math.max(houseValues[0],houseValues[1]);

        int[] lootSoFar = new int[houseValues.length];

        lootSoFar[0] = houseValues[0];
        lootSoFar[1] = houseValues[1];

        for(int i=2; i<houseValues.length; i++) {
            lootSoFar[i] = Math.max(houseValues[i] + lootSoFar[i-2],lootSoFar[i-1]);
        }

        return lootSoFar[houseValues.length - 1];
    }

    public static void main(String[] args) {
        int hval[] = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("Maximum loot value : " + maxLoot(hval));
    }
}
