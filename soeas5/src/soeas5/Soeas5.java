package soeas5;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Soeas5 {
    String buffer;
    File f;
    public Soeas5() {
        buffer = "";
    }
    
    void delSingleComments() {
        String pat = "//.*?\\n";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(buffer);
        buffer = m.replaceAll("\n");
    }
    
    void delMultiComments() {
        String pat = "/\\*.*?\\*/";
        Pattern p = Pattern.compile(pat,Pattern.DOTALL);
        Matcher m = p.matcher(buffer);
        buffer = m.replaceAll("\n");
    }
    
    void delQuotes() {
        String pat = "\".*?\"";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(buffer);
        buffer = m.replaceAll("");
    }
    
    int getDecPoints(Scanner sc) {
        int ndp = 0;
        int count = 0;
        int logs = 0;
        String condition = "(<|>|<=|>=|==|!=)";
        String condition2 = "(\\s)*if[(](.*)?[)]|((\\s)*while[(].*?[)])";
        Pattern p2 = Pattern.compile(condition2);
        Pattern p = Pattern.compile(condition);
        Matcher m,m2;
        while(true) {
            int test = 0;
            String l = sc.nextLine();
            m = p.matcher(l);
            m2 = p2.matcher(l);
            while(m.find()) {
                if(m.group().contains("&&") || m.group().contains("||"))
                    logs++;
                ndp++;
                test = 1;
            } 
            if(test == 0) {
                while(m2.find()) {
                    ndp++;
                }   
            }
            ndp+=logs;
            if(l.contains("{"))
                count++;
            if(l.contains("}"))
                count--;
            if(count == 0)
                break;
        }
        return ndp;
    }
    
    void getCycloComplexity() throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        int ndp;
        int i = 0,j,sum=0;
        String pat = "(void|int|char|float|double)\\s+(.+)\\s*[(](.*)[)]";
        int array[] = new int[20];
        Pattern p = Pattern.compile(pat);
        while(sc.hasNextLine()) {
            String l = sc.nextLine();
            if(l.contains(";"))
                continue;
            Matcher m = p.matcher(l);
            if(m.find()) {
                ndp = getDecPoints(sc);
                sum += ndp+1;
                array[i++] = ndp+1;
                System.out.println("Function "+m.group(2)+"(C"+i+"):"+ndp+" + "+"1 = "+Integer.toString(ndp+1));
            }
        }
        System.out.print("TC = ");
        for(j=0;j<i-1;j++) 
            System.out.print(array[j]+" + ");
        System.out.print(array[j]+" = ");
        System.out.println(sum);
    }
    
    void getAndCreateNewFile() {
        try{
            f = new File("inputcode.c");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
                buffer += sc.nextLine()+"\n";
            delSingleComments();
            delMultiComments();
            delQuotes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Soeas5.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            f = new File("modifiedcode.c");
            FileWriter fw = new FileWriter(f,false);
            fw.write(buffer);
            fw.close();
            getCycloComplexity();
        } catch (IOException ex) {
            Logger.getLogger(Soeas5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Soeas5().getAndCreateNewFile();
    } 
}
