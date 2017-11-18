import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.*;
public class SystemTest{
            public static void main(String[]args){
                //获取从1970年1-1 0:0 到现在的毫秒数
                long starttime=System.currentTimeMillis();
                //获取环境变量的值
                String path=System.getenv("Path");
                //返回一个该类,这个类可以使用一个方法获取各种属性
                Properties myprop=System.getProperties();
                System.out.println("version:"+myprop.getProperty("java.version"));
                System.out.println("java home:"+myprop.getProperty("java.home"));
                System.out.println("path="+path);
                long endtime = System.currentTimeMillis();
                System.out.println("spent time:"+(endtime-starttime));

            }
        }