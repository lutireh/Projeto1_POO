public class App {
    /**
     * This class runs the program, instantiate the control object, and handle execptions;
     *
     *@autor group4
     *@version 1.?
     */
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
