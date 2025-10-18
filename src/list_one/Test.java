import java.util.HashMap;
import java.util.Random;

class Template {
    private HashMap<Integer, Character> templateMap;
    private static final char[] ANWSERS = {'A', 'B', 'C', 'D', 'E'};
    
    public Template(HashMap templateMap) {
        this.templateMap = new HashMap<>();
        Random generator = new Random();
        
        for(int q = 1; q <= 15; q++) {
            int randomIndex = generator.nextInt(ANWSERS.length);
            char randomAnwser = ANWSERS[randomIndex];

            templateMap.put(q, randomAnwser);            
        }
    }

    public char anwserQuestion(int numQuestion) {

    }   
}

public class Test {
    Template template;

    public Test(Template template) {
        this.template = template;
    }

    public Boolean anwserStudant(char anwser) {

    }

    public int hits() {

    }

    public int grade() {

    }

    public Test better(Test anotherTest) {
        
    }

}