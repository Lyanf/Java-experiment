package intellect;

import java.util.*;
/*
 * 操某人出品
 */
public class AI {
    public static void main(String[] args) {
// TODO Auto-generated method stub

        AI M = new AI();//小子这句都不要?

// 各个圈的数据分别如下

        int num1[] = new int[] { 1, 5, 2, 2, 3, 4, 3, 5 };// 第一个小圈
        int num2[] = new int[] { 4, 3, 1, 2, 2, 5, 3, 5 };// 第二个小圈
        int num3[] = new int[] { 1, 2, 3, 1, 5, 2, 4, 3 };// 第三个小圈
        int num4[] = new int[] { 4, 3, 2, 3, 5, 4, 3, 1 };// 第四个小圈

        List<int[]> list1 = new ArrayList<int[]>();
        list1.add(num1);
        List<int[]> list2 = new ArrayList<int[]>();
        M.species(list2, num2);//有八种
        List<int[]> list3 = new ArrayList<int[]>();
        M.species(list3, num3);//有八种
        List<int[]> list4 = new ArrayList<int[]>();
        M.species(list4, num4);//有八种
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list3.size(); j++) {
                for (int k = 0; k < list4.size(); k++) {
                    boolean b = M.match(list1.get(0), list2.get(i), list3.get(j), list4.get(k));
                    if (b) {
                        System.out.println("结果：");
                        M.p(list1.get(0));
                        M.p(list2.get(i));
                        M.p(list3.get(j));
                        M.p(list4.get(k));
                    }
                }
            }
        }
    }

    public static boolean match(int[] a, int[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length; i++) {
            int num = a[i] + b[i] + c[i] + d[i];
            if (num == 12)	continue;
            else	return false;
        }
        return true;
    }

    public static void p(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void species(List<int[]> list , int[] arr){
        list.add(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int[] temp = new int[8];
            for (int j = i, k = 0; k < arr.length; j++, k++) {
                temp[k] = arr[(j + 1) % 8];
            }
            list.add(temp);
        }
    }
}