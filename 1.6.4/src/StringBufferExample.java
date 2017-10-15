class StringBufferExample{
    public static void main(String[]args){
        StringBuffer str=new StringBuffer("ABCDEFG");
        str.append("123456789");
        System.out.println(str);
        str.setCharAt(1,'b');
        System.out.println(str);
        str.setCharAt();
    }
}