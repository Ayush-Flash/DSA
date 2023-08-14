package MeetingMaximumGuest;

import java.util.*;

class Main {
    static void getMaximumGuestDetails(int[] arrival, int[] departure) {
        int arrivalIndex = 0, departureIndex = 0, maxGuest = Integer.MIN_VALUE, guestCount = 0;
        int arrivalTime = -1, departureTime = -1, n = arrival.length;
        while(arrivalIndex <= n - 1 || departureIndex <= n - 1) {
            if(arrivalIndex <= n - 1 && arrival[arrivalIndex] <= departure[departureIndex]) {
                arrivalIndex++;
                guestCount++;
            } else {
                if(guestCount == maxGuest && departureIndex <= n - 1) {
                    arrivalTime = arrival[departureIndex];
                    departureTime = departure[departureIndex];
                    System.out.println("Ideal Arrival Time = " + arrivalTime + " Ideal Departure Time = " +  departureTime + " Guest Count = " + maxGuest);
                }
                departureIndex++;
                guestCount--;
            }
            maxGuest = Math.max(maxGuest, guestCount);
        }
        System.out.println("Maximum Guest = " + maxGuest);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arrival = new int[n];
            for (int i = 0; i < n; i++) {
                arrival[i] = sc.nextInt();
            }
            int[] departure = new int[n];
            for (int i = 0; i < n; i++) {
                departure[i] = sc.nextInt();
            }
            Arrays.sort(arrival);
            Arrays.sort(departure);
            getMaximumGuestDetails(arrival, departure);
        }
    }
}