package bullyfox.sangeeth.testube.component;

import java.util.List;

/**
 * Created by Sangeeth Nandakumar on 21-05-2017.
 */

public class DataRack {
    String name;
    String value;

    public DataRack(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
