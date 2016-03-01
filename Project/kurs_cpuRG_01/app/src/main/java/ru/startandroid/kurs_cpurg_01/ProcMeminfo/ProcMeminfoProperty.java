package ru.startandroid.kurs_cpurg_01.ProcMeminfo;

/**
 * Created by Roma on 14.12.2015.
 */
public class ProcMeminfoProperty {

    public static final String MEM_TOTAL 		= "MemTotal";
    public static final String MEM_FREE 		= "MemFree";
    public static final String BUFFERS 			= "Buffers";
    public static final String CACHED 			= "Cached";
    public static final String SWAP_CACHED 		= "SwapCached";
    public static final String ACTIVE 			= "Active";
    public static final String INACTIVE 		= "Inactive";
    public static final String ACTIVE_ANON 		= "Active(anon)";
    public static final String INACTIVE_ANON 	= "Inactive(anon)";
    public static final String ACTIVE_FILE 		= "Active(file)";
    public static final String INACTIVE_FILE 	= "Inactive(file)";
    public static final String UNEVICTABLE 		= "Unevictable";
    public static final String MLOCKED 			= "Mlocked";
    public static final String SWAP_TOTAL 		= "SwapTotal";
    public static final String SWAP_FREE 		= "SwapFree";
    public static final String DIRTY 			= "Dirty";
    public static final String WRITEBACK 		= "Writeback";
    public static final String ANON_PAGES 		= "AnonPages";
    public static final String MAPPED 			= "Mapped";
    public static final String SHMEM 			= "Shmem";
    public static final String SLAB 			= "Slab";
    public static final String SRECLAIMABLE 	= "SReclaimable";
    public static final String SUNRECLAIM 		= "SUnreclaim";
    public static final String KERNEL_STACK 	= "KernelStack";
    public static final String PAGE_TABLES 		= "PageTables";
    public static final String NFS_UNSTABLE 	= "NFS_Unstable";
    public static final String BOUNCE 			= "Bounce";
    public static final String WRITEBACK_TMP 	= "WritebackTmp";
    public static final String COMMIT_LIMIT 	= "CommitLimit";
    public static final String COMMITTED_AS 	= "Committed_AS";
    public static final String VMALLOC_TOTAL 	= "VmallocTotal";
    public static final String VMALLOC_USED 	= "VmallocUsed";
    public static final String VMALLOC_CHUNK 	= "VmallocChunk";


    private String name;
    private long amountCount;
    private String amountMeasure;

    public ProcMeminfoProperty(String name, long amountCount,
                               String amountMeasure) {
        super();
        this.name = name;
        this.amountCount = amountCount;
        this.amountMeasure = amountMeasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmountCount() {
        return amountCount;
    }

    public void setAmountCount(long amountCount) {
        this.amountCount = amountCount;
    }

    public String getAmountMeasure() {
        return amountMeasure;
    }

    public void setAmountMeasure(String amountMeasure) {
        this.amountMeasure = amountMeasure;
    }
}
