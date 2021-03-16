package listlistlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOkOk {
    public void testList() {
        List<String> list = new ArrayList<String>();
        List<Long> oList = new ArrayList<>();
        list.add("abc");

        list.add("");
        list.add(1,"");
        list.get(0);
        int size = list.size();
        Iterator<String> iterator = list.iterator();
        iterator.hasNext();
        iterator.hashCode();
        list.hashCode();
        boolean flag = list.contains("");
        list.toArray();


    }
}
