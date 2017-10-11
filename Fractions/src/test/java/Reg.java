/**
 * Created by wanjia on 2017/10/11.
 */
public class Reg {
    public static void main(String[] args){
        String classification = "环境 - 磁盘";
        String labelToBeUsedInInput = classification.replaceAll(".*\\s.\\s", "");
       // System.out.println(labelToBeUsedInInput);

        String name = "Dieser “Fehler” wurde über die Seite `Fehleranalyse´ geöffnet.";
        String newName = name.replaceAll("[`´“”]","");
       // System.out.println(newName);

        String str = "{{position}} von {{count}}";
        str = str.replaceAll("[{{}}]","").replaceAll("\\bposition\\b | \\bcount\\b","").trim();
        System.out.println("----" + str);
    }
}
