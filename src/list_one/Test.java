import java.util.HashMap;
import java.util.Random;

class Template {
    private HashMap<Integer, Character> templateMap;
    private static final char[] ANWSERS = {'A', 'B', 'C', 'D', 'E'};

    public Template() {
        this.templateMap = new HashMap<>();

        // fill in the template with random answers
        Random generator = new Random();
        for(int q = 1; q <= 15; q++) {
            int randomIndex = generator.nextInt(ANWSERS.length);
            char randomAnwser = ANWSERS[randomIndex];

            this.templateMap.put(q, randomAnwser);            
        }
    }

    public char answerQuestion(int numQuestion) {
        return templateMap.get(numQuestion);
    }   
}

public class Test {
    private Template template;
    private HashMap<Integer, Character> studantAnwsers;
    private int currentInssue = 1;

    private static final double LESS_TEN = 0.5;
    private static final double GREATER_TEN = 1.0;

    public Test(Template template) {
        this.template = template;
        this.studantAnwsers = new HashMap<>();
    }

    public void answerStudent(char anwser) {
        studantAnwsers.put(currentInssue, anwser);
        currentInssue++;

    }

    public int hits() {
        int hits = 0;
            for(int i = 1; i < currentInssue; i++) {
                char templateAnwser = template.answerQuestion(i);
                char studantAnwser = studantAnwsers.get(i);

                if(templateAnwser == studantAnwser) {
                    hits++;
                }
            }
        return hits;
 
    }

    public double grade() {
        int hits = this.hits();
        double grade = 0.0;

        for(int i = 0; i < hits; i++) {
            if(i <= 10) {
                grade += LESS_TEN;

            } else {
                grade += GREATER_TEN;

            }
        }
        return grade;

    }

    public Test better(Test anotherTest) {
        double thisGrade = this.grade();
        double anotherGrade = anotherTest.grade();

        if(thisGrade > anotherGrade) {
            return this;
        }

        return anotherTest;
    }

    public static void main(String[] args) {
        Template template = new Template();

        Test studentA = new Test(template);
        Test studentB = new Test(template);
        
        char[] ANSWERS_OPTIONS = {'A', 'B', 'C', 'D', 'E'};
        
        // ==============================================================================
        // SIMULAÇÃO ALUNO A: Acertos Baixos (Ex: 8 Acertos)
        // ==============================================================================
        System.out.println("\n--- Respostas do Aluno A (Simulando 8 Acertos) ---");
        int targetHitsA = 8;
        int maxQuestions = 15;
        Random r = new Random();

        for (int i = 1; i <= maxQuestions; i++) {
            char correct = template.answerQuestion(i);
            char answerToGive;

            if (i <= targetHitsA) {
                answerToGive = correct;
            } else {

                do {
                    answerToGive = ANSWERS_OPTIONS[r.nextInt(ANSWERS_OPTIONS.length)];
                } while (answerToGive == correct); 
            }
            studentA.answerStudent(answerToGive);
        }

        // ==============================================================================
        // SIMULAÇÃO ALUNO B: Acertos Altos (Ex: 12 Acertos)
        // ==============================================================================
        System.out.println("--- Respostas do Aluno B (Simulando 12 Acertos) ---");
        int targetHitsB = 12;

        for (int i = 1; i <= maxQuestions; i++) {
            char correct = template.answerQuestion(i);
            char answerToGive;

            if (i <= targetHitsB) {
                answerToGive = correct;
            } else {

                do {
                    answerToGive = ANSWERS_OPTIONS[r.nextInt(ANSWERS_OPTIONS.length)];
                } while (answerToGive == correct);
            }
            studentB.answerStudent(answerToGive);
        }

        // ==============================================================================
        // RESULTADOS
        // ==============================================================================
        
        // Resultados Aluno A
        int hitsA = studentA.hits();
        double gradeA = studentA.grade();
        System.out.println("\n-------------------------------------------");
        System.out.println("RESULTADO ALUNO A:");
        System.out.println("Acertos (Esperado 8): " + hitsA);
        // Cálculo esperado (Correto): 8 acertos * 0.5 = 4.0
        System.out.println("Nota (Esperada 4.0): " + String.format("%.1f", gradeA)); 
        System.out.println("-------------------------------------------");

        int hitsB = studentB.hits();
        double gradeB = studentB.grade();
        System.out.println("\n-------------------------------------------");
        System.out.println("RESULTADO ALUNO B:");
        System.out.println("Acertos (Esperado 12): " + hitsB);

        System.out.println("Nota (Esperada 7.0): " + String.format("%.1f", gradeB));
        System.out.println("-------------------------------------------");

        Test betterStudent = studentA.better(studentB);
        
        System.out.println("\n-------------------------------------------");
        System.out.println("COMPARAÇÃO:");

        if (betterStudent == studentA) {
            System.out.println("O melhor desempenho foi do Aluno A (Nota: " + String.format("%.1f", gradeA) + ")");
        } else {
            System.out.println("O melhor desempenho foi do Aluno B (Nota: " + String.format("%.1f", gradeB) + ")");
        }
        System.out.println("-------------------------------------------");
    }
}
