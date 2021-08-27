import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public class MyUtils {
    private Set<String> listSet = new HashSet<String>();
    private Set<String> mapSet = new HashSet<String>();
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        for (String s: list) {
        	listSet.add(s);
        }
        for (Map.Entry<String,String> entry : map.entrySet()) {
            mapSet.add(entry.getValue());
        }
        if(listSet.equals(mapSet)) {
        	return true;
        }
        return false;
    }
}
