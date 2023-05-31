import java.util.Scanner;

public class Main {
    private static final int[] time = new int[3];

    public static void main(String[] args) {
        currentTime();

        while (true) {
            String h;
            String m;
            String s;

            for (int hours = time[0]; hours < 24; hours++) {
                h = check(hours);

                for (int minutes = time[1]; minutes < 60; minutes++) {
                    m = check(minutes);

                    for (int seconds = time[2]+1; seconds < 60; seconds++) {
                        s = check(seconds);

                        System.out.println(h + ":" + m + ":" + s);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            time[0] = 0;
            time[1] = 0;
            time[2] = 0;
        }
    }

    private static String check(int i) {
        String s;
        if (i < 10) {
            s = "0" + i;
        } else {
            s = String.valueOf(i);
        }
        return s;
    }

    private static void currentTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your time -> XX:XX:XX");
        String timeString = scanner.nextLine();
        String[] parts = timeString.split(":");

        Main.time[0] = 0;
        Main.time[1] = 0;
        Main.time[2] = 0;

        if (parts.length == 3) {
            Main.time[0] = Integer.parseInt(parts[0]);
            Main.time[1] = Integer.parseInt(parts[1]);
            Main.time[2] = Integer.parseInt(parts[2]);
        } else {
            System.out.println("Invalid input! Time -> XX:XX:XX");
            currentTime();
        }
    }
}