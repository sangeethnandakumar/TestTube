package bullyfox.sangeeth.testube.managers;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class AutoStack {
    String delemer="/";
    String page="";
    String[] values=new String[100];
    int count=0;

    public AutoStack(String delemer) {
        this.delemer = delemer;
    }

    public void push(String value)
    {
        count++;
        values[count]=value;
    }

    public String pop()
    {
        String result=values[count];
        count--;
        return result;
    }

    public boolean isEmpty()
    {
        if (count>0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String getPage()
    {
        page="";
        for (int i=1;i<=count;i++)
        {
            page+=delemer+values[i];
        }
        return page;
    }

    public String getAt(int possition)
    {
        return values[possition];
    }

}

