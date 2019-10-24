package App;

import javax.swing.*;
import java.util.*;

public class Rate {

    Map<String,Integer> rating= new HashMap<String,Integer>();
    ValueComparator bvc = new ValueComparator(rating);
    TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);

    void save()
    {
        int min=10000;
        String key=null;
        String name;
        Iterator<Map.Entry<String, Integer>> iIterator = rating.entrySet().iterator();
        while(iIterator.hasNext())
        {
            Map.Entry<String,Integer> kv= iIterator.next();
            if(kv.getValue()<min) {
                min = kv.getValue();
                key = kv.getKey();
            }
        }
        if(Frame.Score>min) {
            name = JOptionPane.showInputDialog("Вы побили рекорд! Введите ваше имя");
            rating.put(name, Frame.Score);
        }
        if((key!=null)&&(rating.size()>10))
            rating.remove(key);
    }

    void show()
    {
        sorted_map.putAll(rating);
        int n=0;
        int k=0;
        String name=null;
        String records[]=new String[rating.size()];
        Iterator<Map.Entry<String, Integer>> iIterator = sorted_map.entrySet().iterator();
        while(iIterator.hasNext())
        {
            Map.Entry<String,Integer> kv= iIterator.next();
            n=kv.getValue();
            name=kv.getKey();
            records[k++]=(k+": "+name+" "+n);
        }
        JList<String> jlst = new JList<String>(records);
        JScrollPane jscrl = new JScrollPane(jlst);
        int j=JOptionPane.showConfirmDialog(Frame.frame, jscrl,"Рекорды",JOptionPane.OK_CANCEL_OPTION);
        sorted_map.clear();
    }

    class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
