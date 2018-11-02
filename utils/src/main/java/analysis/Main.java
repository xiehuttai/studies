package analysis;

import java.io.*;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName="dubbo-list-new.txt";
        String outFileName="out-file.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)));
        LinkedList<String> list = new LinkedList<>();
        String buffer;
        while ((buffer = br.readLine()) != null) {
            list.add(buffer.trim());
        }

        LinkedList<Service> outList = new LinkedList<>();
        for (String str : list) {
            String decode = URLDecoder.decode(str, "utf-8");
            int i=0;
            String type=null;
            if (decode.contains("consumer:")){
                i = decode.indexOf("consumer:");
                type="consumer";
            }
            else if (decode.contains("dubbo:")){
                i = decode.indexOf("dubbo:");
                type="provider";
            }else {
                continue;
            }
            decode=decode.substring(i);
            int j = decode.indexOf("com");
            String hostAndPort = decode.substring(0, j);
            int i1 = hostAndPort.indexOf("://");
            int i2 = hostAndPort.lastIndexOf(":");
            String host = null;
            String port= null;
            if (type.equals("provider")){
                host = hostAndPort.substring(i1 + 3, i2);
                port= hostAndPort.substring(i2+1,hostAndPort.length()-2);
            }else {
                host = hostAndPort.substring(i1 + 3, hostAndPort.length()-1);
                port= "0";
            }
            int k = decode.indexOf("?");
            String serviceName = decode.substring(j, k);
            int m = decode.indexOf("pid=");
            String pidStr = decode.substring(m);
            int n = pidStr.indexOf("&");
            String pid = pidStr.substring(4, n);
            Service service = new Service(serviceName, type, host, port, pid);
            outList.add(service);
        }

        LinkedList<Service> consumer = new LinkedList<>();
        LinkedList<Service> provider = new LinkedList<>();
        for (Service s: outList){
            if (s.getType().equals("consumer"))
                consumer.add(s);
            if (s.getType().equals("provider"))
                provider.add(s);
        }

        // printProvider(provider);

        // printConsumer(consumer);


    //   consumerList(consumer);

      insertConsumerApp();


        LinkedList<String> fileList = new LinkedList<>();
        for (Service s: outList){
            String str = s.toString();
            fileList.add(str);
        }


        //findConsumerApp(consumer);

        outPutFile(fileList,outFileName);

    }

    private static void insertConsumerApp() {

        String str="\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"120109\"\t\"basic-msoa-goods\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.75\"\t\"20445\"\t\"stock-soa\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.32.161\"\t\"44390\"\t\"basic-msoa-member\"\n" +
                "\"10.60.34.119\"\t\"64902\"\t\"basic-msoa-promotion\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.32.161\"\t\"80567\"\t\"basic-soa-shop\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.32.161\"\t\"111097\"\t\"logistics-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"111097\"\t\"logistics-soa-common\"\n" +
                "\"10.60.32.161\"\t\"111097\"\t\"logistics-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.33.22.69\"\t\"37004\"\t\"\"\n" +
                "\"10.33.22.69\"\t\"37004\"\t\"\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"107346\"\t\"goods-msoa-price\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"61853\"\t\"basic-msoa-shop\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"107346\"\t\"goods-msoa-price\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"30817\"\t\"member-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"20370\"\t\"stock-msoa\"\n" +
                "\"10.60.32.161\"\t\"61853\"\t\"basic-msoa-shop\"\n" +
                "\"10.60.32.161\"\t\"44390\"\t\"basic-msoa-member\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"30817\"\t\"member-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"30817\"\t\"member-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"44390\"\t\"basic-msoa-member\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.32.161\"\t\"128309\"\t\"basic-soa-logistics\"\n" +
                "\"10.60.32.161\"\t\"111097\"\t\"logistics-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.32.161\"\t\"78476\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"119536\"\t\"goods-business-engine\"\n" +
                "\"10.60.34.75\"\t\"120109\"\t\"basic-msoa-goods\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"107346\"\t\"goods-msoa-price\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"44390\"\t\"basic-msoa-member\"\n" +
                "\"10.60.32.161\"\t\"30817\"\t\"member-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"58053\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"78476\"\t\"basic-msoa-logistics\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"64902\"\t\"basic-msoa-promotion\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"27230\"\t\"logistics-msoa-common\"\n" +
                "\"10.60.32.161\"\t\"63215\"\t\"shop-msoa-common\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"120109\"\t\"basic-msoa-goods\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"107346\"\t\"goods-msoa-price\"\n" +
                "\"10.60.34.75\"\t\"107346\"\t\"goods-msoa-price\"\n" +
                "\"10.60.34.119\"\t\"119610\"\t\"promotion-msoa-common\"\n" +
                "\"10.60.34.75\"\t\"19092\"\t\"goods-msoa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"39252\"\t\"pay-soa-gateway\"\n" +
                "\"10.33.3.214\"\t\"40540\"\t\"\"\n" +
                "\"10.60.34.119\"\t\"49592\"\t\"promotion-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.32.161\"\t\"27960\"\t\"member-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.32.161\"\t\"41696\"\t\"basic-soa-member\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.119\"\t\"89841\"\t\"cart-soa-common\"\n" +
                "\"10.60.34.75\"\t\"40420\"\t\"goods-soa-common\"\n" +
                "\"10.60.34.82\"\t\"48068\"\t\"order-soa-common\"\n";

        str=str.replace('\"',' ');

        String[] array = str.split("\n");
        for (String s: array){
            String[] strings = s.split("\t");
            String host=strings[0].trim();
            String pid=strings[1].trim();
            String app=strings[2].trim();
            if (app.length()==0)
                app=" ";


            String sql = "update consumer set app='"+app+"' where host='"+host+"' and pid='"+pid+"';";
            System.out.println(sql);

        }


    }


    private static void insertProvider(LinkedList<Service> consumer) {


        for (Service s :consumer   ) {
            String sql = "UPDATE consumer INNER JOIN (SELECT * FROM provider where serviceName='"+ s.getServiceName()+"' ) b " +
                    "ON consumer.serviceName = b.serviceName SET consumer.provider = b.app" +
                    " , consumer.phost=b.host ,consumer.pport=b.port,consumer.ppid=b.pid ;";

            System.out.println(sql);
        }


    }





    private static void consumerList(LinkedList<Service> consumer) {
        for (Service s:consumer){
            String sql = "select DISTINCT host,pid, app from provider where host='" + s.getHost()+"' and pid='"+s.getPid()+ "';";
            System.out.println(sql);
        }
    }


    private static void printProvider(LinkedList<Service> provider) {

        for (Service s:provider){
            String sql = "insert into provider (serviceName,host,port,pid) values ( '" + s.getServiceName()+"' , '"+s.getHost()+"' , '"+s.getPort()+"' , '"+s.getPid() +"');";
            System.out.println(sql);
        }

    }


    private static void printConsumer(LinkedList<Service> provider) {

        for (Service s:provider){
            String sql = "insert into consumer (serviceName,host,pid) values ( '" + s.getServiceName()+"' , '"+s.getHost()+"' , '"+s.getPid() +"');";
            System.out.println(sql);
        }

    }


    public static void outPutFile(List<String> list, String fileName){

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

}
