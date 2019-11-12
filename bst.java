package ds;

public class BST {
	
	
	class Node{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
		
		
	}
	Node root;
	BST(){
		root=null;
	}
	void insert(int data)
	{
		root=insertTree(root,data);
	}
	Node insertTree(Node root,int data)   //insertion 
	{
		if(root==null)
		{
			root=new Node(data);
			return root;
		}
		 if(data<root.data)
		{
			root.left=insertTree(root.left,data);
		}
		 else
		 {
			 root.right=insertTree(root.right,data);
		 }
		 return root;
	}
	void preorder() {   //given preorder cal post and inorder
		pPreorder(root);
		System.out.println();
	}
	void pPreorder(Node root)
	{
		if(root==null)
		{
			return ;
		}
		else
		{
			System.out.println(root.data+" ");
			pPreorder(root.left);
			pPreorder(root.right);
		}
	}
	void postorder()
	{
		pPostorder(root);
		System.out.println();
	
		
	}
	void pPostorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			pPostorder(root.left);
			pPostorder(root.right);
			System.out.println(root.data+" ");
		}
	}
	void inorder()
	{
		pinorder(root);
		System.out.println();
	
		
	}
	void pinorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			pinorder(root.left);
			System.out.println(root.data+" ");
			pinorder(root.right);
			
		}
	}
	void ascending() {
		inorder();
	}
	void descending() {
		pdescending(root);
		System.out.println();
	}
	void pdescending(Node root) {
		if(root==null)
		{
			return;
		}
		else {
			pdescending(root.right);
			System.out.println(root.data+" ");
			pdescending(root.left);
		
			
		}
	}
	
	int height() {   //height of a binary tree
		int h;
		h=cHeight(root);
		return h;
	}
	int cHeight(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		else {
			int lh=cHeight(root.left);
			int rh=cHeight(root.right);
			
			if(lh>=rh)
				return lh+1;
			else
				return rh+1;
			
		}
	}
	 int treeHeight(Node root){     //heightEdges
            if(root == null){
                return -1;
            }
            else{
                return 1+Math.max(treeHeight(root.left), treeHeight(root.right));
            }
        }
	void level()   //breadth first search (height according to edges)
	{
		int h;
		h=height();
		for(int i=1;i<=h;i++)
		{
			printLevel(root,i);
			System.out.println();
		}
		
	}
	void printLevel(Node root,int level)
	{
		if(root==null)
		{
			return ;
		}
		if(level==1)
		{
			System.out.println(root.data+" ");
			
		}
		else if(level>1)
		{
			printLevel(root.left,level-1);
			printLevel(root.right,level-1);
		}
	}

	void rLevel() {    //reverse the level of tree
		int h;
		h=height();
		for(int i=h;i>=1;i--) {
			System.out.println();
			prLevel(root,i);
		}
		
	}
	void prLevel(Node root,int level) {
		if(root==null)
		{
			return;
		}
		if(level==1)
		{
			System.out.println(root.data+" ");
			
		}
		else if(level>1)
		{
			printLevel(root.left,level-1);
			printLevel(root.right,level-1);
		}
	}
	void rtl() {
		int h=height();
		for(int i=0;i<=h;i++)
		{
			printrtlLevel(root,i);
			System.out.println();
		}
		
	}
	void printrtlLevel(Node root,int level) {     //level of tree fro right to left
		
		if(root==null)
		{
			return;
		}
		if(level==1)
		{
			System.out.println(root.data+" ");
			
		}
		else if(level>1)
		{
			printLevel(root.right,level-1);
			printLevel(root.left,level-1);
			
		}
	}
	void spiral()  //spiral printing of a given tree
    {
        printinSpiral(root);
    }
    void printinSpiral(Node root)
    {
        int h = height();
        for(int i = 1 ; i<=h ; i++)
        {
            if(i%2==1)
            {
                printrtlLevel(root, i);
                System.out.println();
            }
            else
            {
                printLevel(root, i);
                System.out.println();
            }
        }
    }

	
	
