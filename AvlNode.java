public class AvlNode
{
    public int data;
    public AvlNode left;
    public AvlNode right;
    public int height;

    AvlNode(int val)
    {
        data = val;
        left = null;
        right = null;
        height = 0;
    }
}