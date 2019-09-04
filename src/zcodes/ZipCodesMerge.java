package zcodes;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pratibha Shambhangoudar date: 2019-September-04
 */
class ZipCodesMerge {
    public int[][] findMinRanges(int[][] zipcodes) {
        //return empty array if no zipcodes
        if (zipcodes.length == 0) return zipcodes;
        
        //Sort by the first zipcode in the pair
        Arrays.sort(zipcodes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        int cnt = 0;
        int i = 1;
        while ( i < zipcodes.length ){
            //Check if upper bound of first zipcode range is greater than lower bound of second zipcode range
            if (zipcodes[cnt][1] >= zipcodes[i][0]){
                zipcodes[cnt][1] = Math.max(zipcodes[i][1], zipcodes[cnt][1]);  
            }
            // If not, add a new range to the output list
            else{
                cnt++;
                zipcodes[cnt][0] = zipcodes[i][0];
                zipcodes[cnt][1] = zipcodes[i][1];
            }
            i++;
        }
        return Arrays.copyOfRange(zipcodes, 0, cnt+1);
    }
    public static void main(String[] args) {
		    int zipCodes[][] = new int[][]{{94133,94133},{94200,94299},{94226,94399}};
        int result[][] = findMinRanges(zipCodes);
	  }
}
