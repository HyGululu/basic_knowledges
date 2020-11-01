package fanshedemo;

public class Student {
    static {
        System.out.println("Student:静态代码块");
    }
    {
        System.out.println("Student:动态代码块");
    }
    public Student(){
        System.out.println("Student: 构造方法");
    }
    private int id;
    String name;

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    protected boolean gender;
    public float score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }
}
