import java.util.Scanner;
import java.util.LinkedList; 
import java.util.Queue;

public class BreadthFirstSearch
{
    public BNode root;

    public BreadthFirstSearch()
    {
        root = null;
    }

    BNode insert(int val)
    {
        root = insertNode(val, root);
        return root;
    }

    BNode insertNode(int val, BNode node)
    {
        if(node == null)
        {
            return new BNode(val);
        }
        else if(val < node.data)
        {
            node.left = insertNode(val, node.left);
        }
        else if(val > node.data)
        {
            node.right = insertNode(val, node.right);
        }
        return node;
    }

    public void display()
    {
        traverseinorder(root);
    }

    public void traverseinorder(BNode node)
    {
        if(node.left != null)
        {
            traverseinorder(node.left);
        }
        System.out.println(node.data);
        if(node.right != null)
        {
            traverseinorder(node.right);
        }
    }

    public void BFSTraversal()
    {
        Queue<BNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size() != 0)
        {
            BNode temp = q.peek();
            System.out.println(temp.data);
            q.poll();
            if(temp.left != null)
            {
                q.offer(temp.left);
            }
            if(temp.right != null)
            {
                q.offer(temp.right);
            }
            
        }
    }


    public static void main(String args[])
    {
        BreadthFirstSearch tr = new BreadthFirstSearch();
        int n,elem;
        System.out.println("Enter the number of elements in a Tree..:\n");
        Scanner ss = new Scanner(System.in);
        n = ss.nextInt();
        for(int i=0; i<n; i++)
        {
            elem = ss.nextInt();
            tr.insert(elem);
        }
        System.out.println("\n");
        tr.display();
        System.out.println("BFS Traversal : \n");
        tr.BFSTraversal();


    }


}