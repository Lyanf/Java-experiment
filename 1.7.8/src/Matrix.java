
import java.io.*;
import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        float[][] test = new float[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                test[i][j] = (float) (i + j);
            }
        }
        Matrix obj = new Matrix(test);
        obj.write("test2.txt");
        Matrix readtest = new Matrix("test2.txt");
        System.out.println(readtest.toString());
        try{
            System.out.println(obj.jia(obj));
            System.out.println(obj.jian(obj));
            System.out.println(obj.cheng(obj));
        }
        catch (Exception e){
            System.out.println(e);
        }
        String a="中国";
        System.out.println(a.getBytes().length);
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

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

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
        if (obj2.x == this.x && obj2.y == this.y && Arrays.deepEquals(this.data, obj2.data))
            return true;
        return false;

    }

    @Override
    //一些关于hash tabke可能会用到这个东西,例如之前的Set
    public int hashCode() {
        return x * y * 5 + 10;
    }

    public Matrix(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String xy = bufferedReader.readLine();
            String xyarray[];
            xyarray = xy.split(" ");
            int row = Integer.parseInt(xyarray[0]);
            int column = Integer.parseInt(xyarray[1]);
            data = new float[row][column];
            x = row;
            y = column;
            float[][] temp = new float[row][column];
            for (int i = 0; i < row; i++) {
                String thisRow = bufferedReader.readLine();
                String[] tempStringArray;
                tempStringArray = thisRow.split(" ");
                for (int j = 0; j < column; j++) {
                    this.data[i][j] = Float.parseFloat(tempStringArray[j]);
                }
            }
            bufferedReader.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName);
            int i, j;
            writer.write(Integer.toString(x) + " " + Integer.toString(y));
            writer.write('\n');
            for (i = 0; i < x; i++) {
                for (j = 0; j < y; j++) {
                    writer.write(Float.toString(data[i][j]) + " ");
                }
                writer.write('\n');

            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Matrix jia(Matrix another) throws Exception {
        Matrix m = new Matrix(x, y);
        if (this.y != another.y || this.x != another.y) {
            throw new Exception("矩阵大小不同，不能相加！");
        } else {
            for (int i = 0; i < m.x; i++) {
                for (int j = 0; j < m.y; j++) {
                    m.data[i][j] = this.data[i][j] + another.data[i][j];
                }
            }
        }
        return m;
    }

    public Matrix jian(Matrix another) throws Exception {
        Matrix m = new Matrix(x, y);
        if (this.x != another.x || this.y != another.y) {
            throw new Exception("矩阵大小不同，不能相减！");
        } else {
            for (int i = 0; i < m.x; i++) {
                for (int j = 0; j < m.y; j++) {
                    m.data[i][j] = this.data[i][j] - another.data[i][j];
                }
            }
        }
        return m;
    }

    public Matrix cheng(Matrix another) throws Exception {
        Matrix m = new Matrix(x, another.y);
        if (this.x != another.y) {
            throw new Exception("第一个矩阵的列数和第二个矩阵行数不相同，不能相乘！");
        } else {
            for (int i = 0; i < this.x; i++) {
                for (int j = 0; j < another.y; j++) {
                    for (int k = 0; k < this.y; k++) {
                        m.data[i][j] += this.data[i][k] * another.data[k][i];
                    }
                }
            }
        }
        return m;
    }

}