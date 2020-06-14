/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author julivanespi
 */
public class InitTimeTracker {

    public static void initFiles() throws IOException {
        initChargeNumberFile();
    }

    /**
     * Creates the charge number file in the users "Documents" folder.
     *
     * @throws IOException
     */
    public static void initChargeNumberFile() throws IOException {
        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/charge_numbers.txt";
        String filePathLoc = System.getProperty("user.home") + "/Documents/TimerTracker/";
        if (!(new File(fileName).exists())) {
            File filePath = new File(filePathLoc);
            File chargeNumFile = new File(fileName);
            try {
                filePath.mkdirs();
                chargeNumFile.createNewFile();
                PrintWriter writer = new PrintWriter(chargeNumFile, "UTF-8");
                writer.println("Add,Charge_Number");
                writer.close();

                //System.out.println("done!");
            } catch (Exception e) {
                System.err.println("Coudln't create charge number file.");
            }
        }
    }

    /**
     * This init method will read a config file that was saved from previous
     * sessions. If it is first time using TimeTracker, a default config will be
     * created.
     */
    public static void applicationInitCofig() {
        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/config.txt";
        String filePathLoc = System.getProperty("user.home") + "/Documents/TimerTracker/";
        if (!(new File(fileName).exists())) {
            File filePath = new File(filePathLoc);
            File chargeNumFile = new File(fileName);
            try {
                filePath.mkdirs();
                chargeNumFile.createNewFile();
                PrintWriter writer = new PrintWriter(chargeNumFile, "UTF-8");
                writer.println("style,default");
                writer.close();

                System.out.println("done!");
            } catch (Exception e) {
                System.err.println("Coudln't create config number file.");
            }
        }
    }

    /**
     * This method reads the existing config file for the style attribute. If
     * the style is default, then it returns true.
     *
     * @return Boolean
     * @throws IOException
     */
    public static boolean isDefaultCss() throws IOException {

        String fileName = System.getProperty("user.home") + "/Documents/TimerTracker/config.txt";
        File dir = new File(fileName);
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] configItems = line.split(",");
            return configItems[0].equalsIgnoreCase("style") && configItems[1].equalsIgnoreCase("default");
        }
        return false;
    }

}
