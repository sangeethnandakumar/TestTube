package bullyfox.sangeeth.testube.component;

import bullyfox.sangeeth.testube.options.AdapterImageMode;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class SimpleItem {
    private String maintext;
    private int imageres;
    private String webres;
    private AdapterImageMode imagemode;

    public SimpleItem(String maintext) {
        this.maintext = maintext;
        imagemode=AdapterImageMode.NONE;
    }

    public SimpleItem(String maintext, int imageres) {
        this.maintext = maintext;
        this.imageres = imageres;
        imagemode=AdapterImageMode.RESOURCE;
    }

    public SimpleItem(String maintext, String webres) {
        this.maintext = maintext;
        this.webres = webres;
        imagemode=AdapterImageMode.WEB;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public int getImageres() {
        return imageres;
    }

    public void setImageres(int imageres) {
        this.imageres = imageres;
    }

    public String getWebres() {
        return webres;
    }

    public void setWebres(String webres) {
        this.webres = webres;
    }

    public AdapterImageMode getImagemode() {
        return imagemode;
    }
}
