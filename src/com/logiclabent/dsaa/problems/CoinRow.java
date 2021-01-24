package com.logiclabent.dsaa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

/*
* This class implements the coin row problem in the dynamic programming class in
* Data Structures and Algorithms at the UG
* MSC Computer Science
 */
public class CoinRow {
    ArrayList<String> cbacktracks=new ArrayList<String>();

    ArrayList<String> backtraces=new ArrayList<String>();
    ArrayList<Integer> optimal=new ArrayList<Integer>();
    String side="";
    ArrayList<Integer> indexes=new ArrayList<Integer>();
    /**
     *
     * @param c which is an array of coins being maximized.
     * @return
     */
    public int[] row(int [] c)
    {
        int [] f= new int[c.length];
        f[0]=0;
        f[1]=c[1];
        for(int i=2;i<c.length;i++)
        {
            f[i]=max(c[i]+f[i-2],f[i-1]);
            if(side=="left")
            {
                backtraces.add("c["+String.valueOf(i)+"]plus"+"f["+String.valueOf(i-2)+"]");

            }else
            {
                backtraces.add("f["+String.valueOf(i-1)+"]");
            }
        }
        return f;
    }

    /**
     * This returns the maximum of two numbers
     * @param num1 the first number
     * @param num2 the second number
     * @return the maximum of the two
     */
    public int max(int num1,int num2)
    {
       int maxnum=0;
       if(num1 > num2)
       {
           maxnum=num1;
           side="left";
       }else
       {
           maxnum=num2;
           side="right";
       }
       return maxnum;
    }
    public void findOptimal(int [] c,int [] f,ArrayList<String> backtraces)
    {
        String maximum=backtraces.get(backtraces.size()-1);

        String [] data=maximum.split("plus");
        if(data[0].startsWith("c"))
        {
            int index=Integer.valueOf(data[0].substring(2,3));
            //System.out.println("c "+index);

            optimal.add(c[index]);
            indexes.add(index);
        }
        if(data[0].startsWith("f"))
        {
            int findex=Integer.valueOf(data[0].substring(2,3));
            //System.out.println("fa "+findex);
            ArrayList<String> subjects=find(c,f,findex);
           // System.out.println(subjects.toString());
            findOptimal(c,f,subjects);
        }
        if(data.length > 1)
        {
            if(data[1].startsWith("f"))
            {
            int findex=Integer.valueOf(data[1].substring(2,3));
            //System.out.println("fb "+findex);
            ArrayList<String> subjects=find(c,f,findex);
            findOptimal(c,f,subjects);
           }
        }
    }
    public String returnOptimal()
    {
        return optimal.toString();
    }
    public ArrayList<String> find(int [] c,int [] f,int index)
    {
        if(index > 1)
        {
            int num= max(c[index]+f[index-2],f[index-1]);
            if(side=="left")
            {
                cbacktracks.add("c["+String.valueOf(index)+"]plus"+"f["+String.valueOf(index-2)+"]");
            }else
            {
                cbacktracks.add("f["+String.valueOf(index-1)+"]");
            }
        }else if(index==1)
        {
            cbacktracks.add("c["+String.valueOf(index)+"]");
        }

        return cbacktracks;
    }
    public ArrayList<String> _back()
    {
        return backtraces;
    }
    public ArrayList<Integer> returnIndexes()
    {
        return indexes;
    }
}
