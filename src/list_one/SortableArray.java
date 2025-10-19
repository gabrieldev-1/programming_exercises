// question 05;

public class SortableArray {
    private String[] array;
    private int lastElementIndex;

    public SortableArray(int length) {
        this.array = new String[length];
        this.lastElementIndex = -1;
    }

    private void expendArray() {
        int newLength = array.length * 2;
        String[] temp = new String[newLength];

        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;

    }

    public void insert(String newStr) {
        if(lastElementIndex == array.length - 1) {
            expendArray();
     
        } 

        lastElementIndex++;
        array[lastElementIndex] = newStr;
    }

    public String get(int index) {
        if(index > lastElementIndex || index < 0) {
            return null;
        }

        return array[index];
    }

    public int size() {
        return array.length;
    }

    public static void main(String[] args) {
        SortableArray myArray = new SortableArray(5);
        
        for(int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }
    }
}