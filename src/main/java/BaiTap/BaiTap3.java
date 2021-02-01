package BaiTap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.lang.String;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaiTap3 {
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

        public Student(String s, String s1) {
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
        final ArrayList<Student> studentList = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(filepath));
            lines.forEach((String t) -> {
                String[] parse = t.split(":");
                if(parse.length<2) return;
                studentList.add(new Student(parse[0], parse[1]));
            });
        } catch (IOException ex) {
            System.out.println("Unable to open student file." + ex.toString());
        }
        System.out.println(studentList);
    }
}
