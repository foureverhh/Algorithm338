package JavaStepByStep;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        //String fileTemp = File.createTempFile("file",".tmp");
        String path = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(path);
        if(chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
        System.out.println(path);
        //Each time the least number is put in the last position
        int[] num = {2, 5, 1, 6, 4, 9, 3, 7, 10, 8};
        int temp;
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                }
            }
        }
        System.out.println("The ordered int array is: ");
         for(int i : num)
             System.out.println(i);

        System.out.println("The ordered double array is:");
        double f[] = {9.0,13.0,6.0,1.0,8.0,12.0};
        sort1(f,0,f.length-1);
        for(double d:f)
            System.out.println(d);

        System.out.println("The ordered double array is:");
        sort2(f,0,f.length-1);
        for(double d:f)
            System.out.println(d);
   /* int[] numReturn=sort(num);
	for(int i:numReturn)
        System.out.println(i);
        */
    }

//Each time the least number is put in the beginning of the array
    private static void sort2(double[] a, int startP,int endP){

        for(int start = startP;start<endP;start++){
            int indexLeast = start;
            for(int i=start;i<endP;i++)
                if(a[i]<a[indexLeast])
                indexLeast = i;
                //Exchange the value of start and index, in other word, exchange the least and startPoint value each time
                double temp = a[start];
                a[start]=a[indexLeast];
                a[indexLeast]=temp;
        }

    }

    private static void sort1(double[] a,int startPoint,int endPoint)
    {
      for(int start=startPoint; start<endPoint; start++){
          int leastIndex = getIndex(a,start,endPoint);
          changeOrder(a,start,leastIndex);
      }
    }

    private static void changeOrder(double[] a,int i,int j) {
        double temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static int getIndex(double[] a,int first,int last) {
        int index = first;
        for(int i = first; i<last;i++){
            if(a[i]<a[index])
                index = i;
        }
        return index;
    }
}
