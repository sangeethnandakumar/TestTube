package bullyfox.sangeeth.testube.component;

import bullyfox.sangeeth.testube.options.AdapterImageMode;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class DualItem {
    private String maintext;
    private String subtext;
    private int imageres;
    private String webres;
    private AdapterImageMode imagemode;

    public DualItem(String maintext, String subtext) {
        this.maintext = maintext;
        this.subtext = subtext;
        imagemode=AdapterImageMode.NONE;
    }

    public DualItem(String maintext, String subtext, int imageres) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.imageres = imageres;
        imagemode=AdapterImageMode.RESOURCE;
    }

    public DualItem(String maintext, String subtext, String webres) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.webres = webres;
        imagemode=AdapterImageMode.WEB;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
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
