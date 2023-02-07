package org.django.models;

public class Person {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    public static class PersonBuilder{
        private  final Person person = new Person();

        public PersonBuilder firstName(String firstName){
            person.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName){
            person.lastName = lastName;
            return this;
        }

        public Person build(){
            return this.person;
        }
    }

    public static PersonBuilder builder(){
     return new PersonBuilder();
    }
}
