package BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class BaiTap3 {
    private static final String filepath = "Student.txt";
    static ObjectOutputStream os;
    static ObjectInputStream is;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student a = new Student(1, "apple", 21, "male");
        readFile();

    }

//        public static void writeToFile(List<Object> fruits) throws IOException {
//            os = new ObjectOutputStream(new FileOutputStream(file));
//            os.writeObject(fruits);
//            os.close();
//
//        }

    public static void readFile() throws ClassNotFoundException, IOException {
        is = new ObjectInputStream(new FileInputStream(filepath));
        List<Object> input = (List<Object>) is.readObject();
        List<Object> checkList = new ArrayList<>();
        // this will contain the list of the objects
        for (Object l : input) {
            checkList.add(l.getClass().getSimpleName());
            if (l instanceof Student) {
                Student app = (Student) l;
                System.out.println(app.id);
                System.out.println(app.name);
                System.out.println(app.age);
                System.out.println(app.gender);
            }
        }
        System.out.println(checkList);

        is.close();
    }

    public static class Student implements Serializable{
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;
        private int age;
        private String gender;

        public Student(int id, String apple, int age, String male) {

        }
        public Student(int id, String name, byte age,
                       String gender) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(byte age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
