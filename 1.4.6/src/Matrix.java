
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Matrix {
    public static void main(String[] args) {
        //没有参数的时候,我认为是一个2*2的矩阵
        Matrix myMatrix_0 = new Matrix();
        Matrix myMatrix_0_a = new Matrix();
        //有两个参数的时候,这个矩阵有x列,y行,每个数据都是0
        Matrix myMatrix_2 = new Matrix(6, 7);
        //有1个参数的时候,这个矩阵接受的参数应该是一个二维数组(浮点型),就不需要x,y表示行数和列数了
        float myArray[][] = {{1, 2, 3}, {2, 3, 4}, {4, 5, 6}};
        Matrix myMatrix_1 = new Matrix(myArray);

        System.out.println(myMatrix_0);
        System.out.println(myMatrix_1);
        System.out.println(myMatrix_2);
        if (myMatrix_0.equals(myMatrix_0_a))
            System.out.println("yes");
        Set<Matrix> mySet = new HashSet<Matrix>();
        mySet.add(myMatrix_0);
        mySet.add(myMatrix_0_a);
        System.out.println(mySet);
        if (myMatrix_0==myMatrix_0_a){
            System.out.println("yes, the two objects are same");
        }
    }

    int x, y;
    float data[][];

    public boolean setX(int i_x) {
        if (i_x > 0) {
            this.x = i_x;
            return true;
        } else return false;
    }

    public boolean setY(int i_y) {
        if (i_y > 0) {
            this.y = i_y;
            return true;
        } else return false;
    }
	public int getx(){return x;}
	public int gety(){return y;}

    public boolean setArray(float i_data[][]) {
        if (i_data.length > 0 && i_data[0].length > 0) {
            data = i_data;
            return true;
        } else return false;
    }

    public Matrix() {
        x = y = 2;
        float temp[][] = {{0, 0}, {0, 0}};
        data = temp;
    }

    public Matrix(int i_x, int i_y) {
        this.setX(i_x);
        this.setY(i_y);
        float temp[][] = new float[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = 0;
            }
        }
        this.setArray(temp);


    }

    public Matrix(float i_array[][]) {
        setX(i_array.length);
        setY(i_array[0].length);
        setArray(i_array);
    }

    @Override
    public String toString() {
        StringBuilder myBuilder = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                myBuilder.append(data[i][j] + "  ");
            }
            myBuilder.append('\n');
        }
        return myBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        final Matrix obj2 = (Matrix) obj;
        if (null == obj2) {
            return false;
        }
        //首先,系统的那个数组类型,euqals是直接用的object.euqlas(),这个可以从调试中看到
        //查了stack overflow,Arrays.equals只能判断一维数组,然后说ArrayUtil.isEuqal可以用多维
        //发现并不能,查到ArrayUtil官方文档,发现现在那个method被删除了,现在是deepEquals,发现调用的还是Arrays.deepEquals()
        if (obj2.x == this.x && obj2.y == this.y && Arrays.deepEquals(this.data,obj2.data))
            return true;
        return false;

    }

    @Override
    //一些关于hash tabke可能会用到这个东西,例如之前的Set
    public int hashCode(){
        return x*y*5+10;
    }
}