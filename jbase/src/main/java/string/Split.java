package string;

import java.util.Arrays;

public class Split {

    private static final String STR="#日志配置\\nlog.root.appender\\u003dinfo,console,error,kafka,trace,debug\\nlog.root.level\\u003derror\n";

    public static void main(String[] args) {

        System.out.println(STR);

        String[] split = STR.split("\\\\n");
        System.out.println(Arrays.asList(split));

        String split1 = STR.split("\\\\u003d")[1];
        System.out.println(Arrays.asList(split1));


        String str= "abc:d";
        System.out.printf( str.substring(0, str.indexOf(":")));
    }

}
