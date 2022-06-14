package recursion;

public class SubSets {

    static void printSubSets(String a, int indexNotPrint){
        if (a == "")return;
        String op = "";
        for(int i=0; i<a.length(); i++){
            if (indexNotPrint != -1 && i == indexNotPrint)continue;
            op += a.charAt(i);
        }
        System.out.print(op+" ");
        for (int i=0; i<op.length(); i++){
            printSubSets(op, i);
        }
    }

    public static void main(String[] args) {
        printSubSets("abc", -1);
    }

}
