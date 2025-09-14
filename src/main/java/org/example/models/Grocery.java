package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    // Start grocery console application
    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int choice = 0;

        while (!quit) {
            System.out.println("\nPazar Arabası Uygulaması");
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");
            System.out.println("Mevcut liste:");
            printSorted();
            System.out.print("Seçiminizi yapın: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                        String itemsToAdd = scanner.nextLine();
                        addItems(itemsToAdd);
                        break;
                    case 2:
                        System.out.println("Çıkarılmasını istediğiniz elemanları giriniz:");
                        String itemsToRemove = scanner.nextLine();
                        removeItems(itemsToRemove);
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                }
            } catch (Exception e) {
                System.out.println("Geçersiz giriş!");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }

    // Add items to the list
    public static void addItems(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }

    // Remove items from the list
    public static void removeItems(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            groceryList.remove(trimmedItem);
        }
        Collections.sort(groceryList);
    }

    // Check if item is in the list
    public static boolean checkItemIsInList(String product) {
        if (product == null) {
            return false;
        }
        return groceryList.contains(product.trim().toLowerCase());
    }

    // Print sorted list
    public static void printSorted() {
        Collections.sort(groceryList);
        if (groceryList.isEmpty()) {
            System.out.println("Liste boş");
        } else {
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }
}