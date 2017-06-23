/**
 * Created by jb.liang on 2017/6/23.
 */
public class RunnableTest implements Runnable {

    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            try {
                for(int i = 0; i < 100;i++){
                    System.out.println(i + "---");
                    if(i == 50){
                        System.out.println("sleep");
                        Thread.sleep(5000);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(123);
                e.printStackTrace();
                return;
            }
        }
    }
}
