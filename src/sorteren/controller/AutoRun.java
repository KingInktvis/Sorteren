package sorteren.controller;

/**
 * Created by rik on 3/5/17.
 */
public class AutoRun implements Runnable {
    private ChartTabController sort;
    public AutoRun(ChartTabController sort){
        this.sort = sort;
    }
    @Override
    public void run() {
        while (true){
            if (sort.getAuto()){
                sort.nextStep();
            }
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("rip");
            }

        }
    }
}
