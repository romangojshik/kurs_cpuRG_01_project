package ru.startandroid.kurs_cpurg_01.ProcMeminfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Roma on 14.12.2015.
 */
public class ProcMeminfoParser {
    private static final String PROC_MEMINFO_FILENAME = "/proc/meminfo";

    public static HashMap<String, ProcMeminfoProperty> parseProcMeminfo() {
        String procMemInfo = PROC_MEMINFO_FILENAME;

        HashMap<String, ProcMeminfoProperty> procMeminfoProperties = new HashMap<String, ProcMeminfoProperty>();
        ProcMeminfoProperty property;

        String temp;
        int readBlockSize = 8192;

        try {
            FileReader fileReader = new FileReader(procMemInfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader, readBlockSize);

            while ((temp = bufferedReader.readLine()) != null) {

                property = parseProcMeminfoLine( temp );
                if( property != null ){
                    procMeminfoProperties.put( property.getName(), property );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return procMeminfoProperties;
    }

    private static ProcMeminfoProperty parseProcMeminfoLine(String line) {
        String name;
        String[] amount;
        long amountCount;
        String amountMeasure;
        String[] parts = line.split(":");
        if (parts != null && parts.length == 2 && parts[0] != null
                && parts[1] != null) {
            name = parts[0];
            amount = parts[1].trim().split(" ");
            if (amount != null && amount.length == 2 && amount[0] != null
                    && amount[1] != null) {
                try {
                    amountCount = Long.parseLong(amount[0]);
                } catch (NumberFormatException e) {
                    amountCount = 0L;
                }

                amountMeasure = amount[1];

                return new ProcMeminfoProperty(name, amountCount, amountMeasure);
            }

            return new ProcMeminfoProperty(name, 0, "");
        }

        return null;
    }
}
