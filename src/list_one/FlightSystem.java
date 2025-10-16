import src.list_one.CustomDate;

public class FlightSystem {
    private int fNumber;
    private CustomDate fDate;

    private static final Boolean[] F_CHAIRS = new Boolean[100];

    static {
        for(int i = 0; i < F_CHAIRS.length; i++) {
            F_CHAIRS[i] = false;
        }
    }

    public FlightSystem(int fNumber, CustomDate fDate) {
        this.fNumber = fNumber;
        this.fDate = fDate;
    }

    private Boolean isChairExist(int chair) {
        if(chair < 0 || chair > F_CHAIRS.length) {
            return false;
        }
        return true;
    }

    public void occupyChair(int chairNumber) {
        int chair = chairNumber - 1;

        if(!isChairExist(chairNumber)) {
            System.out.println("This chair does not exist.");
            return;
        }

        if(F_CHAIRS[chair]) {
            System.out.println("This chair is occupied.");
            return;

        }
        F_CHAIRS[chair] = true;
    }

    public Boolean isOccupy(int chairNumber) {

        if(!isChairExist(chairNumber)) {
            System.out.println("This chair does not exist.");
            return false;
        }

        if(F_CHAIRS[chairNumber]) {
            return true;
        
        } else {
            return false;
        }
    }

    public int nextFreeChair() {
        for (int i = 0; i < F_CHAIRS.length; i++) {
            if (!F_CHAIRS[i]) {
                return i + 1;

            }
        }
        System.out.println("Este voo está lotado (crowded).");
        return -1;
    }

    public int numberFreeChairs() {
        int freeChairs = 0;

        for(Boolean chair : F_CHAIRS) {
            if(!chair) {
                freeChairs++;
            }
        }
        return freeChairs;
    }

    public void flyInfos() {
        System.out.println("---------- flight information -----------");
        System.out.println("NUMBER: " + getfNumber());
        System.out.println("DATE: " + getDate());
        System.out.println("-----------------------------------------");
    }

    //gets
    public int getfNumber() {
        return fNumber;
    }

    public String getDate() {
        return fDate.dateToString();
    }
}