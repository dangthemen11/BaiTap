package BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.lang.String;

public class BaiTap2 {
    private static final String filepath = "Student.txt";
    public static class Student implements Serializable{
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;
        private int age;
        private String gender;

        public Student() {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getAge(){
            return age;
        }
        public void setAge(int age){
            this.age = age;
        }
        public String getGender(){
            return gender;
        }
        public void setGender(String gender){
            this.gender = gender;
        }
    }

    public static void main(String args[]){
        ArrayList<String> myList = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                myList.add(str);
            }
            System.out.println(myList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
