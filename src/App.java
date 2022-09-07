public class App {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
