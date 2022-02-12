import engineClasses.Engine;

public class Launcher {

    public static void main(String[] args) {

        Engine engine = new Engine("Engine3D", 1280,720, 60);
        engine.start();

    }

}
