public class Student extends Person{
    public static void main(String[]args){
        Student me=new Student("李彦峰","320150939151","19","男","100");
        me.display();
    }
    private String name,num,age,sex,grade;
    Student(String i_name,String i_num,String i_age,String i_sex,String i_grade){
        name=i_name;
        num=i_num;
        age=i_age;
        sex=i_sex;
        grade=i_grade;
    }
    public void display(){
        System.out.println("姓名:"+name+"\n学号:"+num+"\n年龄:"+age+"\n性别:"+sex+"\n成绩:"+grade);
    }
}