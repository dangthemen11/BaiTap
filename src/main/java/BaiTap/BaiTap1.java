package BaiTap;

import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

public class BaiTap1 {
    private static int max = 0;
    private static int max2 = 0;
    private static boolean prime = true;

    public static void main(String args[]){
        ArrayList<String> al = new ArrayList<>();
        al.add(" 34 5");
        al.add("5b 3");
        al.add("  6 54");
        al.add("a 65");
        al.add("2  5  5");
        al.add("9 5 3");
        al.add("7  8   5");
        al.add("9     9         9 5");
        al.add("18");
        System.out.println("Danh sách hiện tại là: ");
        System.out.println(al);

        //Xóa space
        for (int i = 0; i < al.size(); i++){
            al.set(i, al.get(i).replaceAll("\\s+", ""));
        }
        System.out.println("Danh sách sau khi xóa space: "+ al);

        //xóa những item không phải là số

        //cách 1
//        for (int i = 0; i < al.size(); i++){
//            al.set(i, al.get(i).replaceAll("\\D",""));
//        }
//        System.out.println("Danh sách sau khi xóa item không phải số: "+ al);

        //cách 2
        for (int i = 0; i < al.size(); i++){
            if (Pattern.matches(".*[a-zA-Z].*", al.get(i))){
                al.remove(al.get(i));
            }
        }
        System.out.println("Danh sách sau khi xóa item không phải số: "+ al);


        //Thay thế các số 5 thành 4
        for (int i = 0; i < al.size(); i++){
            al.set(i, al.get(i).replaceAll("5", "4"));
        }
        System.out.println("Danh sách sau khi thay thế 5 -> 4: "+ al);



        //Tìm ptu lớn nhất và lớn thứ 2 -> convert sang int

        List<Integer> newList = new ArrayList<Integer>(al.size());
        for (String str:al){
            newList.add(Integer.valueOf(str));
        }
        max = newList.get(0);
        max2 = newList.get(1);
        if(newList.get(0) > newList.get(1)){
            max = newList.get(0);
            max2 = newList.get(1);
        }else{
            max = newList.get(1);
            max2 = newList.get(0);
        }
        for (int i = 2; i < newList.size(); i++){
            if(newList.get(i) >= max){
                max2 = max;
                max = newList.get(i);
            }else if(newList.get(i) > max2){
                max2 = newList.get(i);
            }
        }
        System.out.println("Số lớn nhất là: "+ max);
        System.out.println("Số lớn thứ 2 là: "+ max2);


        //Sắp xếp mảng theo thứ tự giảm dần
        Collections.sort(newList, Collections.reverseOrder());
        System.out.println("Dãy số được sắp xếp giảm dần là: "+ newList);

        //Tìm các tích số con 18 = 2*3*3
        Iterator<Integer> iterator = newList.listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            prime = true;
            for (int i = 2; i < n; i++){
                if(n%i == 0){
                    prime = false;
                    break;
                }
            }
            if(prime == true){
                System.out.println(n+ " = " +n);
            }else {
                System.out.print(n + " = ");
                int num = 2;
                while (n >= num){
                    while (n%num == 0){
                        System.out.print(num);
                        n /= num;
                        if(n/num != 0){
                            System.out.print(" x ");
                        }
                    }
                    num++;
                }
                System.out.println();
            }
        }
    }
}
