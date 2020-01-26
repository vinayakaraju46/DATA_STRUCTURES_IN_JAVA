public class AvlTree
{
    public AvlNode root;

    public AvlTree()
    {
        root = null;
    }

    public int CalcHeight(AvlNode node)
    {
        if(node == null)
        {
            return -1;
        }
        return node.height;
    }

    public int CalcBalance(AvlNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return (CalcHeight(node.left) - CalcHeight(node.right)); 
    }

    public AvlNode insert(int val)
    {
        root = insertNode(val, root);
        return root;
    }

    public AvlNode insertNode(int val, AvlNode node)
    {
        if(node == null)
        {
            return new AvlNode(val);
        }
        else if(val < node.data)
        {
            node.left = insertNode(val, node.left);
        }
        else if(val > node.data)
        {
            node.right = insertNode(val, node.right);
        }
        return Settleviolations(val, node);
    }

    public AvlNode Settleviolations(int val, AvlNode node)
    {
        int bal = CalcBalance(node);

        if(bal > 1 && val < node.left.data)
        {
            return rotateright(node);
        }
        else if(bal > 1 && val > node.left.data)
        {
            node.left = rotateleft(node.left);
            return rotateright(node);
        }
        else if(val < -1 && val > node.right.data)
        {
            return rotateleft(node);
        }
        else if(val < -1 && val < node.right.data)
        {
            node.right = rotateright(node);
            return rotateleft(node);
        }
        return node;
    }



    public AvlNode rotateright(AvlNode node)
    {
        AvlNode templeftchild = node.left;
        AvlNode t = templeftchild.right;

        templeftchild.right = node;
        node.left = t;

        node.height = Math.max(CalcHeight(node.left), CalcHeight(node.right)) + 1;
        templeftchild.height = Math.max(CalcHeight(templeftchild.left), CalcHeight(templeftchild.right)) + 1;
        return templeftchild;
    }

    public AvlNode rotateleft(AvlNode node)
    {
        AvlNode temprightchild = node.right;
        AvlNode t = temprightchild.left;

        temprightchild.left = node;
        node.right = t;

        node.height = Math.max(CalcHeight(node.left), CalcHeight(node.right)) + 1;
        temprightchild.height = Math.max(CalcHeight(temprightchild.left), CalcHeight(temprightchild.right)) + 1;
        return temprightchild;
    }


    public void display()
    {
        traverseinorder(root);
    }

    public void traverseinorder(AvlNode node)
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





}    