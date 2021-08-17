/**
 * Welcome! This is a small phonebook program and this is the main class.
 * We implement this project using MVC design pattern.
 *
 * @Author Eran Meir
 */
public class Main {
    public static void main(String[] argv) {
        IModel myModel = new Model();
        IView myView = new View(myModel);
        IController myController = new Controller(myModel, myView);
    }
}
