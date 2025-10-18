package src.list_one;
import java.time.LocalDate;

// question 02;

public class CustomDate {
    private int day;
    private int month;
    private int year;

    private static final LocalDate CURRENT_DATE = LocalDate.now();
    private static final int CURRENT_YEAR = CURRENT_DATE.getYear();

    private static final int[] DAYS_IN_MONTH = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public CustomDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.err.println("A data fornecida é inválida. Inicializando com a data atual (" + CURRENT_DATE.getYear() + ").");
            this.day = CURRENT_DATE.getDayOfMonth();
            this.month = CURRENT_DATE.getMonthValue();
            this.year = CURRENT_YEAR;
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 1 || year > CURRENT_YEAR) {
            return false;
        }
        
        int maxDays = DAYS_IN_MONTH[month];
        
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        
        if (day < 1 || day > maxDays) {
            return false;
        }
        
        return true;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String dateToString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public String getMonthString() {
        String monthStr = "";

        switch (month) {
            case 1: 
                monthStr = "Janeiro";
                break;
            case 2: 
                monthStr = "Fevereiro";
                break;
            case 3: 
                monthStr = "Março";
                break;
            case 4: 
                monthStr = "Abril";
                break;
            case 5: 
                monthStr = "Maio";
                break;
            case 6: 
                monthStr = "Junho";
                break;
            case 7: 
                monthStr = "Julho";
                break;
            case 8: 
                monthStr = "Agosto";
                break;
            case 9: 
                monthStr = "Setembro";
                break;
            case 10: 
                monthStr = "Outubro";
                break;
            case 11: 
                monthStr = "Novembro";
                break;
            case 12: 
                monthStr = "Dezembro";
                break;
            default:
                monthStr = "Mês Inválido";
                break;
        }
        return monthStr;
    }

    public CustomDate clone() {
        return new CustomDate(getDay(), getMonth(), getYear()); 
    }

    public static void main(String[] args) {
        CustomDate validDate = new CustomDate(29, 2, 2024);
        System.out.println("Data Válida: " + validDate.dateToString() + " (" + validDate.getMonthString() + ")");
        System.out.println("É bissexto: " + (validDate.isLeapYear() ? "sim" : "não"));
        System.out.println("---------------------------");

        CustomDate invalidDate = new CustomDate(30, 2, 2023); 
        System.out.println("Data Inválida (30/02): " + invalidDate.dateToString());
        System.out.println("---------------------------");
        
        CustomDate birthDay = new CustomDate(9, 3, 2006);
        System.out.println("data: " + birthDay.dateToString());
        System.out.println("mes por extenso: " + birthDay.getMonthString());
        System.out.println("---------------------------");
        System.out.println("dia: " + birthDay.getDay());
        System.out.println("mes: " + birthDay.getMonth());
        System.out.println("ano: " + birthDay.getYear());
        System.out.println("---------------------------");

        boolean isLeap = birthDay.isLeapYear();

        if(!isLeap) {
            System.out.println("e bissexto: nao");
        } else {
            System.out.println("e bissexto: sim");
        }
    }
}