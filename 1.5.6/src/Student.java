class Person{
    protected int age=0;
    protected String name="noname";
    protected char sex='M';
    public Person(){}
    public Person(String n,int a,char s){
        name = n;
        if (a>=0&&a<140) age=a;
        else age=0;
        if (s=='M') sex=s;
        else sex='F';
    }
    public void introduceme(){
        System.out.println("my name is :" +name +"\tmy age is :"+age);
        if (sex=='M')System.out.println("i am man!");
        else System.out.println("I am woman!");
    }
    public String getName(){return name;}
    public void setName(String n){name=n;}
    public int getAge(){return age;}
    public void setAge(int a){
        if (a>=0&&a<140) age=a;
        else age=0;
    }
    public char getSex(){return sex;}
    public void setSex(char s){
        if (s=='M') sex='M';
        else sex='F';
    }
    public boolean equals(Person a){
        if (this.name.equals(a.name)&&this.age==a.age&&this.sex==a.sex)
            return true;
        else return false;
    }
    public String toString(){
        return name+","+sex+","+age;
    }
}

public class Student extends Person{
    public static void main(String[]args){
        Student me=new Student("李彦峰","320150939151",19,'男',"100");
        me.display();
    }
    private String num,grade;
    Student(String i_name,String i_num,int i_age,char i_sex,String i_grade){
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