import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PracGoormClass {
    public static void main(String[] args) {
        try {
            queue();
        } catch (IOException e) {
            System.out.println("error : %s" + e.getMessage());
        }
    }

    public static void addInt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        System.out.println(Integer.parseInt(input1) + Integer.parseInt(input2));
    }

    public static void findCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String MAX_NUMBER = br.readLine();
        ArrayList<String> stringArrayList = new ArrayList<>();
        int i = 1;
        while (i < Integer.parseInt(MAX_NUMBER)) {
            stringArrayList.add(br.readLine());
            i++;
        }

        ArrayList<Integer> intArray = new ArrayList<>();
        intArray = stringArrayList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.sort(intArray);

        for (i = 1; i < Integer.parseInt(MAX_NUMBER); i++) {
            if (!intArray.contains(i)) {
                System.out.println(i);
            }
        }

    }

    public static void queue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] initial = input.split(" ");
        String MAX_NUMBER = initial[0];
        String MAX_QUEUE_SIZE = initial[1];
        Queue<Integer> queue = new LinkedList<>();

        int i = 0;
        while (i < Integer.parseInt(MAX_NUMBER)) {
            input = br.readLine();
            String[] tmp = input.split(" ");
            String command = tmp[0];
            int data = 0;
            if(tmp.length > 1) {
                data = Integer.parseInt(tmp[1]);
            }
            if (queue.size() == 0 && command.equals("pop")) {
                System.out.println("Underflow");
            } else if (queue.size() == Integer.parseInt(MAX_QUEUE_SIZE) && command.equals("push")) {
                System.out.println("Overflow");
            }
            else {
                if (command.equals("pop")) {
                    int removeData = queue.remove();
                    System.out.println(removeData);
                } else if (command.equals("push")) {
                    queue.add(data);
                }
            }
            i++;
        }
    }

}
