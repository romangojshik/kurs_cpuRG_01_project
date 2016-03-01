package ru.startandroid.kurs_cpurg_01.ProcCpuInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Roma on 14.12.2015.
 */
public class ProcCpuInfoParser {
    private static final String PROC_CPUINFO_FILENAME = "/proc/cpuinfo";

    public static HashMap<String, ProcCpuinfoProperty> parseProcCpuinfo() {
        String procMemInfo = PROC_CPUINFO_FILENAME;

        HashMap<String, ProcCpuinfoProperty> procCpuinfoProperties = new HashMap<String, ProcCpuinfoProperty>();
        ProcCpuinfoProperty property;

        String temp;
        int readBlockSize = 8192;

        try {
            FileReader fileReader = new FileReader(procMemInfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader, readBlockSize);

            while ((temp = bufferedReader.readLine()) != null) {

                property = parseProcCpuinfoLine( temp );
                if( property != null ){
                    procCpuinfoProperties.put( property.getName(), property );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return procCpuinfoProperties;
    }

    private static ProcCpuinfoProperty parseProcCpuinfoLine(String line) {
        String[] parts = line.split(":");
        if (parts != null && parts.length == 2 && parts[0] != null
                && parts[1] != null) {
            return new ProcCpuinfoProperty( parts[0].trim(), parts[1].trim() );
        }

        return null;
    }
}
