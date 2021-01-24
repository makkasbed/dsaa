package com.logiclabent.dsaa.problems;

public class CoinCollecting {

    public int robotCoinCollecting(int [][]c)
    {
        int n=c[0].length;
        int m=c[1].length;
        int [][] f=new int[n][m];
        f[1][1]=1;
        for(int j=2; j<m;j++)
        {
            f[1][j]=f[1][j-1]+c[1][j];
        }
        for(int i=2;i<n;i++)
        {
            f[i][1]=f[i-1][1]+c[i][1];
            for(int j=2;j<m;j++)
            {
                f[i][j]=max(f[i-1][j],f[i][j-1]) + c[i][j];
            }
        }
      return f[n][m];
    }
    public int max(int num1,int num2)
    {
        int maximum=0;
        if(num1 > num2)
        {
            maximum=num1;
        }else
        {
            maximum=num2;
        }
        return maximum;
    }
}
