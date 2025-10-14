package resolutions;


public class Studant {

    private static int nextRegistration = 1000;

    private final int registration;
    private String name;
    private double noteOne;
    private double noteTwo;
    private double workNote;
    
    private static final double WEIGHT_TEST = 2.5;
    private static final double WEIGHT_WORK = 2.0;
    private static final double WEIGHT_SUM = (WEIGHT_TEST * 2) + WEIGHT_WORK;
    private static final double APPROVAL_RATING = 6.0;

    public Studant(String name, double n1, double n2, double wNote) {
        this.registration = nextRegistration++;
        this.name = name;
        this.noteOne = n1;
        this.noteTwo = n2;
        this.workNote = wNote;

    }

    public double calculateAvarege() {
        double sumWeighted = (this.noteOne * WEIGHT_TEST) +
                             (this.noteTwo * WEIGHT_TEST) +
                             (this.workNote * WEIGHT_WORK);
        
        return sumWeighted / WEIGHT_SUM;
    }

    public double finalTest() {
        double currAvarege = calculateAvarege();

        if (currAvarege >= APPROVAL_RATING) {
            return 0.0;
        }

        double requiredWeightedSum = APPROVAL_RATING * (WEIGHT_SUM + (WEIGHT_SUM + 2.5));

        double currentWeightedSum = currAvarege * WEIGHT_SUM;

        double missingWeightedSum = requiredWeightedSum - currentWeightedSum;
        
        double finalNoteRequired = missingWeightedSum / (WEIGHT_SUM + 2.5);

        double roundedNote = Math.round(finalNoteRequired * 100.0) / 100.0;
        
        return Math.min(10.0, roundedNote);
    }
}
