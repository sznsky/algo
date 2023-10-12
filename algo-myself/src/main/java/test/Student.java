package test;

public class Student {

    private String stuld;
    public void setStuld(String stuld) throws Exception{//1
        if(stuld.length() != 4){//2
            throw new Exception("学号必须是4位数");//3
        }else {
            this.stuld = stuld;
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setStuld("5444");
    }
}
