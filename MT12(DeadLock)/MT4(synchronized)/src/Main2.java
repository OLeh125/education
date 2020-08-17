public class Main2 {
    public static void main(String[] args) {
        try {
            new Worker().main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
