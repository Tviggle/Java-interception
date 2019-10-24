package App;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DB implements Serializable {

    private static final long serialVersionUID = 2;

    private Map<String,Integer> rating= new HashMap<String,Integer>();

    DB(Map mp)
    {
        rating=mp;
    }

    void load()
    {
        Frame.record.rating.putAll(rating);
    }
}
