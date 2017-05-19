package bullyfox.sangeeth.testube.component;

import bullyfox.sangeeth.testube.options.AdapterImageMode;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class TripleItem {
    private String maintext;
    private String subtext;
    private String tagline;
    private int imageres;
    private String webres;
    private AdapterImageMode imagemode;


    public TripleItem(String maintext, String subtext, String tagline) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.tagline = tagline;
        imagemode=AdapterImageMode.NONE;
    }

    public TripleItem(String maintext, String subtext, String tagline, int imageres) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.tagline = tagline;
        this.imageres = imageres;
        imagemode=AdapterImageMode.RESOURCE;
    }

    public TripleItem(String maintext, String subtext, String tagline, String webres) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.tagline = tagline;
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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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
