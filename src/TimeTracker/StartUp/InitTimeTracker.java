/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTracker.StartUp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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

                System.out.println("done!");
            } catch (Exception e) {
                System.err.println("Coudln't create charge number file.");
            }
        }
    }

}
