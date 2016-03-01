package ru.startandroid.kurs_cpurg_01.ProcCpuInfo;

/**
 * Created by Roma on 14.12.2015.
 */
public class ProcCpuinfoProperty {
    public static final String PROCESSOR		 	= "Processor";
    public static final String BOGO_MIPS 			= "BogoMIPS";
    public static final String FEATURES 			= "Features";
    public static final String CPU_IMPLEMENTER 		= "CPU implementer";
    public static final String CPU_ARCHITECTURE 	= "CPU architecture";
    public static final String CPU_VARIANT 			= "CPU variant";
    public static final String CPU_PART 			= "CPU part";
    public static final String CPU_REVISION 		= "CPU revision";
    public static final String HARDWARE 			= "Hardware";
    public static final String REVISION 			= "Revision";
    public static final String SERIAL 				= "Serial";

    private String name;
    private String value;

    public ProcCpuinfoProperty(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
