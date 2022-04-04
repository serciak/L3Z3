package com.company;

import java.util.Random;

public class Main {

    public static InfiniteQueue<Client> clientQueueGenerator(int clientsAmount) {
        Random rand = new Random();
        InfiniteQueue<Client> q = new InfiniteQueue<>();
        int randArrivalTime = 0;

        for(int i = 0; i<clientsAmount; i++) {
            randArrivalTime = randArrivalTime + rand.nextInt(0,3);
            q.enqueue(new Client(randArrivalTime, rand.nextInt(29,30)));
            //zakladamy ze sprawa zawsze zajmuje wiecej niz 0 jednostek czasu
        }

        return q;
    }

    public static void main(String[] args) throws EmptyQueueException {
        InfiniteQueue<Client> queue = clientQueueGenerator(1000);
        OfficeQueue officeQueue = new OfficeQueue(queue);

        officeQueue.execute();
    }
}
