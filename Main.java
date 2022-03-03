import java.util.*;
import java.io.*;
public class Main
{
public static void main(String[] args) {
    HashMap<String, List<String>> map=new LinkedHashMap<>();
    InputStream is = null;
        BufferedReader br = null;
        try {
            System.out.print(">");
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                String string[]=line.split(" ");
                int i=1;
                if(string[0].equalsIgnoreCase("ADD")){
                    List<String> list=map.get(string[1]);
                    if(map.containsKey(string[1])){
                        if(list.contains(string[2])){
                        System.out.println(") ERROR, member already exists for key");
                        }
                        else {
                            list.add(string[2]);
                            System.out.println(") ADDED");
                        }
                    } else{
                        list=new ArrayList<>();
                        list.add(string[2]);
                    map.put(string[1],list);
                    System.out.println(") ADDED");
                    }
                } else if(string[0].equalsIgnoreCase("KEYS")) {
                    if(!map.isEmpty()){
                    for(String key:map.keySet()){
                        System.out.println(i+") "+key);
                        i++;
                    }
                    i=0;
                    }
                    else{
                        System.out.println(") empty set");
                    }
                } else if(string[0].equalsIgnoreCase("MEMBERS")) {
                    if(map.containsKey(string[1])){
                    List<String> value=map.get(string[1]);
                    for(String val:value){
                        System.out.println(i+") "+val);
                        i++;
                    }
                    i=0;
                    }else{
                    System.out.println(") ERROR, key does not exist");
                    }
                }else if(string[0].equalsIgnoreCase("REMOVE")) {
                    List<String> list=map.get(string[1]);
                    if(map.containsKey(string[1])){
                        if(list.contains(string[2])){
                            list.remove(string[2]);
                           System.out.println(") Removed");
                           if(list.isEmpty())
                            map.remove(string[1]);
                        }
                        else {
                            System.out.println(") ERROR, member does not exist");
                        }
                    } else{
                    System.out.println(") ERROR, key does not exist");
                    }
                }else if(string[0].equalsIgnoreCase("REMOVEALL")) {
                    if(map.containsKey(string[1])){
                        map.remove(string[1]);
                        System.out.println(") Removed");
                    } else{
                    System.out.println(") ERROR, key does not exist");
                    }
                }else if(string[0].equalsIgnoreCase("CLEAR")) {
                    if(!map.isEmpty()){
                     map.clear();
                     System.out.println(") Cleared");
                    }
                    else{
                        System.out.println(") Cleared");
                    }
                }else if(string[0].equalsIgnoreCase("KEYEXISTS")) {
                    if(map.containsKey(string[1])){
                     System.out.println(") true");
                    }
                    else{
                        System.out.println(") false");
                    }
                } else if(string[0].equalsIgnoreCase("MEMBEREXISTS")) {
                    if(map.containsKey(string[1])){
                         List<String> list=map.get(string[1]);
                        if(list.contains(string[2])){
                            System.out.println(") true");
                        }
                    }
                    else{
                        System.out.println(") false");
                    }
                } else if(string[0].equalsIgnoreCase("ALLMEMBERS")) {
                    if(!map.isEmpty()){
                    for(String s: map.keySet()){
                        List<String> values=map.get(s);
                        for(String val:values){
                        System.out.println(i+") "+val);
                        i++;
                        }
                    }
                    i=0;
                    }else{
                    System.out.println(") empty set");
                    }
                }else if(string[0].equalsIgnoreCase("ITEMS")) {
                    if(!map.isEmpty()){
                    for(String s: map.keySet()){
                        List<String> values=map.get(s);
                        for(String val:values){
                        System.out.println(i+") "+s+" : "+val);
                        i++;
                        }
                    }
                    i=0;
                    }else{
                    System.out.println(") empty set");
                    }
                }
                System.out.print(">");
                
            }
             
        }
        catch (IOException ioe) {
            System.out.println("Exception while reading input " + ioe);
        }
        finally {
            // close the streams using close method
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
 
        }
}
}
