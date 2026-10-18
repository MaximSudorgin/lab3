public class Main {

    static volatile String last = "";

    public static void main(String[] args) throws InterruptedException {
        Speaker chicken = new Speaker("Курица");
        Speaker egg = new Speaker("Яйцо");
        chicken.setName("ChickenThread");
        egg.setName("EggThread");

        chicken.start();
        egg.start();

        chicken.join();
        egg.join();

        System.out.println();
        System.out.println("Последнее слово в споре: " + last);
        System.out.println("Победитель: " + last);
    }
}

class Speaker extends Thread {
    private final String word;

    Speaker(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(word);
            Main.last = word;
            Thread.yield();
        }
    }
}
