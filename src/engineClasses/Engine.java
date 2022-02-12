package engineClasses;

import input.KeyManager;
import objectClasses.World;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {

    //Attributes
    private Display display;
    public int width, height;
    public String title;
    public int fps;
    public int engineTicks;

    private World world;

    private boolean running = false;
    private Thread thread;

    private final KeyManager keyManager;

    //Constructor
    public Engine(String title, int width, int height, int fps){
        this.width = width;
        this.height = height;
        this.title = title;
        this.fps = fps;
        this.keyManager = new KeyManager();
        this.engineTicks = 60;
    }

    public KeyManager getKeyManager() { return keyManager; }

    //Methods
    //TODO remove scanner import
    private void init(){
        display = new Display(title, width, height);
        //TODO INIT HERE
        display.getFrame().addKeyListener(keyManager);
        world = new World("objectClasses/worlds/defaultWorld.txt", this);
        world.init();
    }

    int x = 0;

    private void tick(){
        x += 1;
        //TODO TICK HERE
        keyManager.tick();
        world.tick();
    }

    private void render(){
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //TODO RENDER HERE
        world.render(g, width, height);

        //Ends render
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = this.fps;
        double timePerTick = 1000000000f / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long timer2 = 0;
        int ticks = 0;
        int ticks2 = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            timer2 += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                ticks2++;
                delta--;
            }

            if(timer2 >= 100000000){
                this.engineTicks = ticks2;
                ticks2 = 0;
                timer2 = 0;
            }

            if(timer >= 1000000000){
                display.getFrame().setTitle("fps : " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}











