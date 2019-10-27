package pojo;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private int age;
    private String address;
    private char gender;
    private String phoneNum;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public User(String name, int age, String address, char gender, String phoneNum) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.phoneNum = phoneNum;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
