package qps;

import java.io.*;
import java.util.*;

public class JQPS {

    private static final String FILENAME = "result.txt";

    public static void main(String[] args) throws Exception {

        serviceQps();

    }

    public static void serviceQps() throws IOException {
        List<String> list = getList(FILENAME);
        Map<String, Integer> sqps = new LinkedHashMap<>();
        for (String path: list){
            if (!path.contains("/"))
                continue;
            int i = path.indexOf("/")+1;
            int j = path.indexOf("/", i);
            String serviceName=path.substring(i,j);

            int m = path.lastIndexOf(":")+1;
            int n = path.lastIndexOf("}");
            Integer value=Integer.parseInt(path.substring(m,n));

            if(!sqps.containsKey(serviceName)){
                sqps.put(serviceName,value);
            }else {
                Integer sum = sqps.get(serviceName);
                sqps.put(serviceName,sum+value);
            }
        }

        for (Map.Entry<String,Integer> entry: sqps.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue()*10/120);
        }
    }

    public static void outPutFile(List<String> list,String fileName){

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
            try {
                br.write(s);
                br.newLine();
                br.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static List<String> getList(String fileName) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        LinkedList<String> list = new LinkedList<>();
        String buffer;
        while ((buffer = br.readLine()) != null) {
            buffer=buffer.trim();
            if(buffer!=null&&!buffer.equals(""))
                list.add(buffer);
        }
        br.close();
        isr.close();
        is.close();
        Collections.sort(list);
        return list;
    }
}
