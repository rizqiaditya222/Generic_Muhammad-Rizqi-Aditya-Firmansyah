public class MainGeneric {
    public static void main(String[] args) {
        Generic<String> objGeneric = new Generic<String>("halo");

        String input = objGeneric.getDataT();
        System.out.println(input);
        objGeneric.displayType();
    }
}