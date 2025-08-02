package StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiQuestion {

    public static void main(String[] args){
        String str = "Convert a List of Strings to Uppercase";
        List<String> strList = new ArrayList<>();
        strList.add(str);
        strList.add("Convert a List of Strings to Uppercase.Convert a List of Strings to Uppercase.");

        List<String>strList1 = strList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        for(String st : strList1){
            System.out.println(st);
        }

        //

    }
}
