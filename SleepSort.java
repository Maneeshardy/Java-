import java.util.ArrayList;
class SleepSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);   
        arr.add(23);
        arr.add(122);
        arr.add(9);
        sleepSort(arr); 
    }
    public static void sleepSort(ArrayList<Integer> arr) {
        ArrayList<Thread> threads = new ArrayList<>();  
        for (int num : arr) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(num);  
                    System.out.print(num + " "); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread); 
            thread.start(); 
        }
        for (Thread thread : threads) {
            try {
                thread.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
