package Hospital;

public class Person {
    private int id;
    private String name;
    private String address;
    private String gender;
    private int age;
    private int phoneNumber;

    Person(int id, String name, String address, String gender, int age, int phoneNumber){
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getId(){

        return id;

    }



    public String getName(){

        return name;

    }



    public String getAddress(){
        return address;

    }



    public String getGender(){

        return gender;
    }



    public int getAge(){

        return age;
    }



    public int getPhoneNumber(){

        return phoneNumber;

    }


    @Override
    public String toString() {
        return "Person Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n" +
                "Phone Number: " + phoneNumber;
    }




}
