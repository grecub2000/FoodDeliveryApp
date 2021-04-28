package service;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;


public class AuditService {

    private static AuditService instance = null;
    private BufferedWriter bw;

    private AuditService() {
        try{
            Path path = Path.of("files/audit.csv");
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            this.bw = Files.newBufferedWriter(path, StandardOpenOption.APPEND);

        }
        catch (Exception e){

        }
    }

    public static AuditService getInstance(){
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void write(String action) {
        String timeS = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(new Date());
        String output = action + ", " + timeS;

        try {
            bw.write(output + "\n");
            bw.flush();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
