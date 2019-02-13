package pp;

public class CaculateDate {
    static class Date {
        int y;
        int m;
        int d;
        static int[] monthDaysMap = new int[]{1,-2,1,0,1,0,1,1,0,1,0,1};

        static int convertDateToDaysInYear (Date date) {
            int y = date.y;
            int m = date.m;
            int d = date.d;
            // month==4, 1+2+3, 0+1+2
            int sum = d;
            for (int i=0; i<m-1; ++i) {
                if (i==1 && isLeapYear(y))
                    sum += 29;
                else
                    sum += 30 + monthDaysMap[i];
            }
            return sum;
        }

        static boolean isLeapYear (int y) {
            return (y%100+y%400+y%4==0) || (y%100>0 && y%4==0);
        }

        static int getDaysDiffJan1 (int yearFrom, int yearTo) {
            int daysDiff = 0;
            for (int y=yearFrom; y<yearTo; ++y) {
                daysDiff += isLeapYear(y) ? 366 : 365;
            }
            return daysDiff;
        }
    }

    int getDaysFromTo(Date dateFrom, Date dateTo) {
        int daysInYearFrom = Date.convertDateToDaysInYear(dateFrom);
        int daysInYearTo = Date.convertDateToDaysInYear(dateTo);

        int yearDiff = Date.getDaysDiffJan1(dateFrom.y, dateTo.y);
        return yearDiff + daysInYearTo - daysInYearFrom;
    }

//    Date getDaysAfter(Date dateStart, int daysAfter) {
//        return 0;
//    }

    public static void main(String[] args) {

    }




}
