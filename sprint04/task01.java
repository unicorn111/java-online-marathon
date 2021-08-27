import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyUtils {
	private Map<String, List<String>> new_map = new HashMap<String, List<String>>();
	private List<String> value = new ArrayList<String>();
	
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
    	if (phones.isEmpty()) {
        	return new_map;
        }
    	 for (String key : phones.keySet()) {
    		 String newKey = phones.get(key);
             value = new_map.get(newKey);
             if (value == null) {
                 new_map.put(newKey, new ArrayList<String>(Arrays.asList(key)));
             } else {
                 value.add(key);
                 new_map.put(newKey, value);
             }

    	 }
    	
		return new_map;
    }
}
