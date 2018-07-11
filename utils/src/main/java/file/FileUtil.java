package file;

import java.io.*;

public class FileUtil {

    public static int getFilesName(String path) throws IOException {
        File file = new File(path);
        if (!file.isDirectory())
            return 0;
        File[] files = file.listFiles();
        String outFileName = file.getPath() + File.separator + "0 目录.txt";
        FileWriter fw = new FileWriter(new File(outFileName));
        for (File f: files)
            fw.write(String.format("%-40s  %s \n",f.getName(),getFileSize(f)));
        fw.close();
        return 1;
    }

    public static void main(String[] args) throws IOException {
        String path ="/";
        getFilesName(path);
    }

    public static String getFileSize(File f){
        if (f.isDirectory())
            return "";
        long length = f.length();
        if (length<1024)
            return length+" B";
        length=length>>10;
        if (length<1024)
            return length+" K";
        length=length>>10;
        if (length<1024)
            return length+" M";
        length=length>>10;
        return length+" G";
    }

}
