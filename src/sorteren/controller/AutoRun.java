package sorteren.controller;

/**
 * Created by rik on 3/5/17.
 */
public class AutoRun implements Runnable {
    private SortInterface sort;
    public AutoRun(SortInterface sort){
        this.sort = sort;
    }
    @Override
    public void run() {
        while (true){
            if (sort.getAuto()){
                sort.nextStep();
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                System.out.println("rip");
            }

        }
    }
}
