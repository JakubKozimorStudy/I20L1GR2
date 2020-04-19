package com.l1gr2.restaurant.data;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class DataReader {


//    @EventListener(ApplicationReadyEvent.class)
    public void getDateFromDumpFile() {
        File file = new File("");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while ((scanner.hasNextLine())) {
            System.out.println(scanner.nextLine());
        }
    }
}
