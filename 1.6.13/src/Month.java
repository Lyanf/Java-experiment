import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

class Month {
    int month,day,week;
    String[][] out = new String[7][8];
    public Month(int iYear,int iMonth){
        LocalDate firstDay = LocalDate.of(iYear,iMonth,1);
        week = firstDay.getDayOfWeek().getValue();
        day = firstDay.lengthOfMonth();
        month = iMonth;
        int i,j;
        for (i=0;i<7;i++){
            for (j=0;j<8;j++){
                out[i][j]=" ";
                if (j==7){
                    out[i][j]="\n";
                }
            }
        }
        out[0][0]="一";
        out[0][1]="二";
        out[0][2]="三";
        out[0][3]="四";
        out[0][4]="五";
        out[0][5]="六";
        out[0][6]="日";
        int start = week-1;
        int x=1;
        int flag = 1;
        for (i=1;i<7;i++){
            for (j=0;j<7;j++){
                if (flag == 1){
                    j=start;
                    flag=0;
                }
                if (x<=day){
                    out[i][j]=String.format("%d",x);
                    x++;
                }
            }
        }
    }

    public void disPlay(){
        int i,j;
        System.out.println("\n");
        for (i=0;i<7;i++){
            for (j=0;j<7;j++){
                System.out.printf("%s\t ",out[i][j]);
            }
            System.out.println("\n");
        }
    }
    public static void  main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要显示的年份");
        int year = scanner.nextInt();
        int i = 1;
        for (i=1;i<=12;i++){
            Month month = new Month(year, i);
            System.out.println(i+"月");
            month.disPlay();
        }

    }
}

