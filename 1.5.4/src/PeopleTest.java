class People{
    protected double weight,height;
    public void speakHello(){
        System.out.println("who am i?");

    }
    public void avervageHeight(){
        height=173;
        System.out.println("average height:"+height);

    }
    public void averageWeight(){
        weight=70;
        System.out.println("average weight:"+weight);
    }
}

class ChinaPeople extends People{
    @Override
    public void speakHello() {
        System.out.println("哈喽,我是中国人!");

    }

    @Override
    public void avervageHeight() {
        System.out.println("我们中国人的平均身高:168.78厘米");
    }

    @Override
    public void averageWeight() {
        System.out.println("我们中国人的平均体重:65公斤");
    }
    public void chinaGongfu(){
        System.out.println("坐如钟,站如松,睡如弓");
    }

}

class AmericanPeople extends People{
    @Override
    public void speakHello() {
        System.out.println("Hello,I am American!");
    }

    @Override
    public void avervageHeight() {
        System.out.println("the average height is 170cm");
    }

    @Override
    public void averageWeight() {
        System.out.println("the average weight is 70kg");
    }
    public void americanBoxing(){
        System.out.println("The straight,hook");

    }
}

class BeijingPeople extends ChinaPeople{
    @Override
    public void speakHello() {
        System.out.println("你好,我是北京人");
    }
    public void beijingOpera(){
        System.out.println("京剧");
    }
}

class PeopleTest{
    public static void main(String[]args)
    {
        ChinaPeople chinaPeople=new ChinaPeople();
        AmericanPeople americanPeople=new AmericanPeople();
        BeijingPeople beijingPeople=new BeijingPeople();
        chinaPeople.speakHello();
        americanPeople.speakHello();;
        beijingPeople.speakHello();
        chinaPeople.averageWeight();;
        americanPeople.averageWeight();
        beijingPeople.averageWeight();
        chinaPeople.avervageHeight();
        americanPeople.avervageHeight();
        beijingPeople.avervageHeight();
        chinaPeople.chinaGongfu();
        americanPeople.americanBoxing();
        beijingPeople.beijingOpera();
        beijingPeople.chinaGongfu();
    }
}