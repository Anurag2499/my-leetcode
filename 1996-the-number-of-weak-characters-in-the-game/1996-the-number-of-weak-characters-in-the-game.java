class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)-> (a[0]==b[0])?a[1]-b[1]:b[0]-a[0]);
        
        int max = -1,res = 0;
        
        for(int[] property: properties){
            if(property[1] < max) res++;
            else max = property[1];
        }
        return res;
    }
}

/*
(a[0]==b[0])?a[1]-b[1]:b[0]-a[0])
this is a custom comparator in java which helps such that it sorts in a particular way we want. for example-> Arrays.sort(array,(a,b)->b-a) sorts the array in descending order. Again, Arrays.sort(array,(a,b)->a-b) sorts the array in ascending order.
So, for the above statement, it sorts the array w.r.t. properties[x][0] in descending order, but when two properties[x][0] are equal, it sorts in ascending order of properties[x][1].
where, x is any number between 0 and properties.length-1
*/