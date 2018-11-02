package analysis;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ParseAppFileUtil {


    public static void main(String[] args) throws IOException {

        String fileName="deploy-config.txt";
        String outFileName="out-file-deploy.txt";


        BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)));
        LinkedList<String> list = new LinkedList<>();
        String buffer;
        while ((buffer = br.readLine()) != null) {
            if (buffer.contains("="))
                list.add(buffer.trim());
        }

        LinkedList<App> outList = new LinkedList<>();
        for (String str : list) {
            String[] split = str.split("=");
            String appName=split[0].trim();
            String[] array = split[1].split(":");
            String host=array[0].trim();
            String pid="";
            if (array.length>1)
                pid=array[1].trim();
            App app = new App(appName, host, pid);
            outList.add(app);
        }

        updateAppName(outList);

//
//        LinkedList<String> fileList = new LinkedList<>();
//        for (App s: outList){
//            String str = s.toString();
//            fileList.add(str);
//        }
//
//
//
//        outPutFile(fileList,outFileName);

    }

    private static void updateAppName(LinkedList<App> outList) {

        for (App a : outList) {
            String sql="UPDATE provider set app='"+a.getAppName()+"' where host='"+a.getHost()+"' and pid='"+a.getPid()+"';";
            System.out.println(sql);
        }


    }

    public static void outPutFile(List<String> list, String fileName) throws IOException {

        File file = new File(fileName);
        FileOutputStream fos= null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter br = new BufferedWriter(osw);
        for (String s: list){
            br.write(s);
            br.newLine();
            br.flush();
        }
    }


}
