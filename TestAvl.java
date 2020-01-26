import java.util.Scanner;

public class TestAvl
{
    public static void main(String args[])
    {
        AvlTree tr = new AvlTree();
        int n;
        int elem;
        Scanner ss = new Scanner(System.in);
        n = ss.nextInt();

        for(int i=0; i<n; i++)
        {
            elem = ss.nextInt();
            tr.insert(elem);
        }
        tr.display();
    }
}