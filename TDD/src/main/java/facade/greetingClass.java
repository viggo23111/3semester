package facade;

import java.util.ArrayList;
import java.util.Locale;

public class greetingClass {
    public static String greet(String name) {
        String result="Hello";

        if(name.isEmpty()) {
            name = name.replace("", "my friend");
        }
        if(name.toUpperCase().equals(name) && !name.isEmpty()){
            result=result.toUpperCase()+" "+name+"!";
        }else{
        result=result+", "+name+".";
        }

        return result;

    }

    public static String greetMultiple(String[] names) {
        String result= "Hello, ";
        ArrayList<String> namesLower = new ArrayList<String>();
        ArrayList<String> namesCapital = new ArrayList<String>();
        for (int i = 0; i <names.length ; i++) {
            if(names[i].toUpperCase().equals(names[i])){
                namesCapital.add(names[i]);
            }else{
                namesLower.add(names[i]);
            }
        }
        int lowerAmount = namesLower.size();
        int upperAmount = namesCapital.size();

        if(lowerAmount>0){
            for (int i = 0; i < lowerAmount ; i++) {
                if (i == namesLower.size()-2) {
                    result += names[i] + " and ";
                } else {
                    if(namesLower.size()2 && i!=lowerAmount-1){
                        result += names[i]+", ";
                    }else {
                        result += names[i];
                    }
                }
            }
        }
        result+=".";

        return result;
    }
}
