package hw6task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Worker> listOfWorkers = new ArrayList<>();
        int counter = 2;
        String name;
        String job;
        int year = 0;

        for (int i = 0; i < counter; i++) {
            System.out.println("Enter person's info: ");
            name = scanner.nextLine();
            System.out.println("Enter job activity: ");
            job = scanner.nextLine();
            try {
                System.out.println("Enter the year when " + name + " started working: ");
                year = scanner.nextInt();
                if (year > 2023 || year < 1970) {
                    throw new Exception();
                }
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Enter correct value of year, when person began working on current job!" +
                                    "\nMust be INTEGER value from 1970 to 2023.\n");
                scanner.nextLine();
                i--;
                continue;
            }
            listOfWorkers.add(new Worker(name, job, year));
            System.out.println();
        }

        WorkerComparator comparator = new WorkerComparator();
        listOfWorkers.sort(comparator);

        for (Worker worker: listOfWorkers) {
            System.out.println(worker);
        }

        System.out.println("\nEnter some number: ");
        int someNumber = scanner.nextInt();

        System.out.println("Workers, whose working experience higher then entered number:");
        for (Worker worker: listOfWorkers) {
            if (2023 - worker.getYear() > someNumber)
                System.out.println(worker);
        }
        scanner.close();
    }
}


