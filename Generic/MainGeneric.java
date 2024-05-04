public class MainGeneric {
    public static void main(String[] args) {
        Generic<Integer> objGeneric = new Generic<Integer>(911);

        Integer input = objGeneric.getDataT();
        System.out.println(input);
        objGeneric.displayType();
    }
}