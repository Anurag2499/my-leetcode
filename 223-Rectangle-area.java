class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ans=0;
        ans = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);

        int x1 = Math.max(ax1,bx1);
        int y1 = Math.max(ay1,by1);
        int x2=  Math.min(ax2,bx2);
        int y2 = Math.min(ay2,by2);
        int lx =x2-x1;
        int ly = y2-y1;
        int a3=0;
        if(lx<0 || ly<0)
        {
            a3=0;
        }
        else a3= lx*ly;
        ans-=a3;
        return ans;
    }
}