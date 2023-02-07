package org.django.models;

public class Student extends Person{

    private int age;
    private String address;
    private String phone;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, String address, String phone) {
        super(firstName, lastName);
        this.age = age;
        this.address = address;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



    public static class StudentBuilder extends PersonBuilder{
        private final Student student = new Student();

        @Override
        public PersonBuilder firstName(String firstName) {
            return super.firstName(firstName);
        }

        @Override
        public PersonBuilder lastName(String lastName) {
            return super.lastName(lastName);
        }

        public StudentBuilder age(int age){
            student.age = age;
            return this;
        }

        public StudentBuilder address(String address){
            student.address = address;
            return this;
        }

        public StudentBuilder phone(String phone){
            student.phone = phone;
            return this;
        }

        public Student build(){
            return this.student;
        }

    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
}
