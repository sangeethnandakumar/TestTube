package bullyfox.sangeeth.testube.managers;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class AutoStack {
    String[] values=new String[100];
    int count=0;

    public void push(String value)
    {
        values[++count]=value;
    }

    public String pop()
    {
        return values[count--];
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
}

