public class Generic <T> {
    private T Data;

    public Generic (T data){
        this.Data = data;
    }

    public T getDataT(){
        return Data;
    }

    public void displayType(){
        System.out.println("Tipe datanya merupakan "+Data.getClass().getName());
    }
}