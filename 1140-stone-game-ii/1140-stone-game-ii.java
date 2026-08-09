class Solution {
    public int stoneGameII(int[] p) {
        int n=p.length;
        int[] s=new int[n+1];
        int[][] d=new int[n][n+1];

        for(int i=n-1;i>=0;i--) s[i]=s[i+1]+p[i];

        for(int i=n-1;i>=0;i--)
            for(int m=1;m<=n;m++)
                for(int x=1;x<=2*m&&i+x<=n;x++)
                    d[i][m]=Math.max(d[i][m],
                        s[i]-(i+x<n?d[i+x][Math.max(m,x)]:0));

        return d[0][1];
    }
}