package example.iscu;

public class OrderedList {
    private int size = 1000;
    private int[] listObject;
    private int[] tempObject;
    OrderedList(){
        this.listObject = new int[size];
    };
    OrderedList(int[] newObject){
        if(newObject.length >= size){
            this.size = newObject.length * 2;
        }
        this.listObject = new int[size];
        for (int i = 0; i < newObject.length; i++) {
            listObject[i] = newObject[i];
            if(i == listObject.length){
                listObject[1001] = 0;
            }
        }
    }
    public void add(int object){
        int nextIndex = listObject.length;
        if(nextIndex == size){
            tempObject = new int[nextIndex * 2];

        }
    }
    public void addSize(){

    }
    public void subSize(){

    }
}
