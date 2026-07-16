package model;

public class Patient extends Person {

    private int id;
    private String address;
    private int age;
    private int weight;

    public Patient(){}

    // used for INSERT (NO ID because AUTO_INCREMENT)
    public Patient(String name, String phone, String address, int age, int weight){
        super(name, phone);
        this.address = address;
        this.age = age;
        this.weight = weight;
    }

    // used for UPDATE / GET
    public Patient(int id, String name, String phone, String address, int age, int weight){
        super(name, phone);
        this.id = id;
        this.address = address;
        this.age = age;
        this.weight = weight;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address = address; }

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    public int getWeight(){ return weight; }
    public void setWeight(int weight){ this.weight = weight; }
}