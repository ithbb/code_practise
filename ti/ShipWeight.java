class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight=Integer.MIN_VALUE;
        int maxWeight=0;

        // minWeight is the max of one product
        // maxWeight is the sum of all products

        for(int i=0;i<weights.length;i++){
            minWeight=Math.max(minWeight,weights[i]);
            maxWeight+=weights[i];
        }
        while(minWeight<=maxWeight){
            int mid=(minWeight+maxWeight)/2;
            if(checkValid(weights,mid,days)){
                maxWeight=mid-1;
            }
            else
                minWeight=mid+1;
        }
        return minWeight;
    }
    
    public boolean checkValid(int[] weights,int mid,int maxDays){
        int days=0;
        int sum=0;
        for(int i:weights){
            if(sum+i>mid){
                days++;
                sum=0;
            }
            sum+=i;
        }
        if(days+1>maxDays) return false;
        return true;
    }
}
