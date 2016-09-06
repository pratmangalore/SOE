package soeas1;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Soeas1 {
    HashMap<String,Integer> nonini = new HashMap<String,Integer>();
    HashMap<String,Integer> funs = new HashMap<String,Integer>();
    HashMap<String,Integer> ini = new HashMap<String,Integer>();
    HashMap<String,Integer> loops = new HashMap<String,Integer>();
    HashMap<String,Integer> conds = new HashMap<String,Integer>();
    public Soeas1() throws FileNotFoundException
    {
        ini.put("int",0);   ini.put("float",0);   ini.put("double",0);    ini.put("char",0);
        nonini.put("int",0);  nonini.put("float",0);   nonini.put("double",0);   nonini.put("char",0);
        funs.put("int",0);   funs.put("void",0);   funs.put("char",0);  funs.put("float",0);  funs.put("double",0);
        loops.put("for",0);   loops.put("while",0);   loops.put("do",0);    conds.put("if",0);
        PrintStream out = new PrintStream(new FileOutputStream("iit2014112.txt"));
        System.setOut(out);
    }
    public void findVar(String line,String pat,String type) {
        int flag=0;
        Integer count=0;
        String lin[];
        line = line.trim();
        Pattern pa = Pattern.compile(pat);
        Matcher m = pa.matcher(line);
        if (m.find( )) {
            //System.out.println("Found value: " + m.group(0) );
            lin = m.group(0).split("[\\s*,]");
            for(String word:lin) {
               if(word.contains("(")||word.contains(")")) {
                   flag=1;
                   break;
               }
               if(word.contains(";")) {
                   flag=2;
                   break;
               }
            }
            if(flag==1) {
                for(String word:lin) {                    
                    if(word.contains(";")) {
                        flag=2;
                        break;
                    }
                }
            }
            if(flag==2)  {
                for(String word:lin) {
                    //System.out.println(word);
                    if(word.compareTo(type)!=0 && (word.contains("(")==false && word.contains(")")==false)) {
                        if(word.contains("=")) {
                            count=ini.get(type);
                            ini.remove(type);
                            //System.out.println("INI "+word);
                            ini.put(type, count+1);    
                        }
                        else {
                            count=nonini.get(type);
                            nonini.remove(type);
                            //System.out.println("NINI "+word);
                            nonini.put(type, count+1);
                        }
                    }
                }
            }
        }
    }
    
    public void findFun(String line,String pat) {
        int count;
        String lin[];
        Pattern pa = Pattern.compile(pat);
        Matcher m = pa.matcher(line);
        if (m.find( )) {
            //System.out.println("Found value: " + m.group(0) );
            lin = m.group(0).split("[\\s*,\\(\\)]");
            count = funs.get(lin[0]);
            funs.remove(lin[0]);
            funs.put(lin[0],count+1);
            for(int i=1;i<lin.length;i++)
                System.out.println(lin[i]+" ");
            System.out.println("");
        }
    }
    public void findLoop(String line,String pat) {
        int count=0;
        String lin[];
        Pattern pa = Pattern.compile(pat);
        Matcher m = pa.matcher(line);
        if (m.find( )) {
            lin = m.group(0).split("[\\s*,\\(\\)]");
            count = loops.get(lin[0]);
            loops.remove(lin[0]);
            loops.put(lin[0], count+1);
        }
    }
    
    public void findCond(String line,String pat) {
        int count=0;
        String lin[];
        Pattern pa = Pattern.compile(pat);
        Matcher m = pa.matcher(line);
        if (m.find( )) {
            lin = m.group(0).split("[\\s*,\\(\\)]");
            for(String word:lin)
            {
                //System.out.println(word);
                if(word.compareTo("if")==0)
                {
                    count = conds.get(word);
                    conds.remove(word);
                    conds.put(word, count+1);
                    break;
                }          
            }    
            //System.out.println("");
        }
    }
    
    public void printMap(HashMap<String,Integer> m) {
        for(HashMap.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + ":::" + entry.getValue());
        }
    }
    
    public void parsThis(String line) {
        String variable="\\s+\\w*\\s*";
        String intPat = "(\\.*(\\()?\\s*int\\s+\\w*\\s*(\\s*=\\s*\\d*)?(;)?\\s*(?:\\s*[,)]\\s*([;]|(int)?\\s*\\w*(\\))?(\\s*=\\s*\\d*)?)*)*)";
        String charPat = "(\\.*(\\()?\\s*char\\s+\\w*\\s*(\\s*=\\s*\\'\\w*\\')?(;)?\\s*(?:\\s*[,)]\\s*([;]|(char)?\\s*\\w*(\\))?(\\s*=\\s*\\'\\w*\\')?)*)*)";
        String douPat = "(\\.*(\\()?\\s*double\\s+\\w*\\s*(\\s*=\\s*\\d*)?(;)?\\s*(?:\\s*[,)]\\s*([;]|(double)?\\s*\\w*(\\))?(\\s*=\\s*\\d*)?)*)*)";
        String floatPat = "(\\.*(\\()?\\s*float\\s+\\w*\\s*(\\s*=\\s*\\d*)?(;)?\\s*(?:\\s*[,)]\\s*([;]|(float)?\\s*\\w*(\\))?(\\s*=\\s*\\d*)?)*)*)";
        String funcPat = "(\\.*(int|char|double|float|void)\\s+\\w*\\s*\\((?:\\s*(,)?(int|char|double|float)\\s+\\w*\\s*)*\\))";
        String loopPat = "(\\.*(for|while)\\s*[(].*[)])|(\\.*do\\s*[{]\\.*)";
        String condPat = "(\\.*if\\s*[(].*[)])";
        findVar(line,intPat,"int");
        findVar(line,charPat,"char");
        findVar(line,douPat,"double");
        findVar(line,floatPat,"float");
        findFun(line,funcPat);
        findLoop(line,loopPat);
        findCond(line,condPat);
    }
    
    public void parser(File f) {
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())  {
                String l = sc.nextLine();
                //System.out.println(l);
                parsThis(l);
            }
            System.out.println("Functions");                    printMap(funs);         System.out.println("");
            System.out.println("Initialized variables");        printMap(ini);          System.out.println("");
            System.out.println("Non-Initialized variables");    printMap(nonini);       System.out.println("");
            System.out.println("Loops");                        printMap(loops);        System.out.println("");
            System.out.println("Conditions");                   printMap(conds);        System.out.println("");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
          File f = new File("/home/placements2017/soeas1/csnip.c");
          Soeas1 obj = new Soeas1();
          obj.parser(f);
    }
}
