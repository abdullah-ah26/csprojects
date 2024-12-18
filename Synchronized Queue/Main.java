package lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get all required user inputs
        System.out.print("Enter queue size: ");
        int queueSize = scanner.nextInt();
        
        System.out.print("Enter number of producer threads: ");
        int producerCount = scanner.nextInt();
        
        System.out.print("Enter number of consumer threads: ");
        int consumerCount = scanner.nextInt();
        
        System.out.print("Enter producer delay (ms): ");
        int producerDelay = scanner.nextInt();
        
        System.out.print("Enter consumer delay (ms): ");
        int consumerDelay = scanner.nextInt();
        
        Synchronized_Queue<Integer> queue = new Synchronized_Queue<>(queueSize);
        
        for (int i = 0; i < producerCount; i++) {
            Thread producer = new Thread(new Producer(queue, producerDelay));
            producer.start();
        }
        
        for (int i = 0; i < consumerCount; i++) {
            Thread consumer = new Thread(new Consumer(queue, consumerDelay));
            consumer.start();
        }
    }
}