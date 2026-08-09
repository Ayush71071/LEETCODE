class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean[][] d=new boolean[n+1][m+1];
        d[0][0]=true;

        for(int j=2;j<=m;j++)
            if(p.charAt(j-1)=='*') d[0][j]=d[0][j-2];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1))
                    d[i][j]=d[i-1][j-1];
                else if(p.charAt(j-1)=='*') {
                    d[i][j]=d[i][j-2];
                    if(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1))
                        d[i][j]|=d[i-1][j];
                }

        return d[n][m];
    }
}