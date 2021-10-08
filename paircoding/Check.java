package paircoding;


import java.util.Stack;

public class Check {
	static String str="";
	public static String chaChong(String s){
	   str=Calculate.generate(s) ;
	   suffixExpressionTree(s);
		return str;
		
	}
	static class Node {
		String value;
		Node leftchild;
		Node rightchild;

		Node(String value) {
			this.value = value;
			leftchild = null;
			rightchild = null;
		}
	}

	
	/**
	 * ��׺���ʽת������ʽ��
	 * 
	 * @param suffixStr
	 */
	public static void suffixExpressionTree(String suffixStr) {
		String[] chs=suffixStr.split(" ");
	    // ������ʱ�洢�ڵ��ջ
	    Stack<Node> stack=new Stack<Node>();
	    // ���������ַ����������������ջ����������ģ���ջ�������ڵ�ȡ�����ϳ�һ����Ȼ����ջ
	    for(int i=0;i<chs.length;i++)
	    {
	    	
	    	String c=chs[i]+"";
	    	if(c.equals(" "))
	    		continue;
	        if(isOperator(c))
	        {
	            if(stack.isEmpty()||stack.size()<2)
	            {
	                System.err.println("����ĺ�׺���ʽ����ȷ");
	                return;
	            }
	            if(c.equals("+")||c.equals("*"))
	            {
	            	Node root=new Node(c);
	            	Node a=stack.pop();
	            	Node b=stack.pop();
	            	if(isOperator(a.value)&&isOperator(b.value))
	            	{
	            		if(Calculate.opValue(a.value)>Calculate.opValue(b.value))
	            		{
	            			root.leftchild=a;
				            root.rightchild=b;
	            		}
	            		else if(Calculate.opValue(a.value)<Calculate.opValue(b.value))
	            		{
	            			root.leftchild=b;
				            root.rightchild=a;
	            		}
	            		else
	            		{
	            			if(compare(a.leftchild.value,b.leftchild.value)==1)
	            			{
	            				root.leftchild=a;
					            root.rightchild=b;
	            			}
	            			else if(compare(a.leftchild.value,b.leftchild.value)==-1)
	            			{
	            				root.leftchild=b;
					            root.rightchild=a;
	            			}
	            			else
	            			{
	            				if(compare(a.rightchild.value,b.rightchild.value)==1)
		            			{
		            				root.leftchild=a;
						            root.rightchild=b;
		            			}
		            			else if(compare(a.rightchild.value,b.rightchild.value)==-1)
		            			{
		            				root.leftchild=b;
						            root.rightchild=a;
		            			}
		            			else
		            			{
		            				root.leftchild=a;
						            root.rightchild=b;
		            			}
	            			}

	            		}
	            	}
	            	else if(isOperator(a.value)&&(!isOperator(b.value)))
	            	{
	            		 root.leftchild=a;
				            root.rightchild=b;
	            	}
	            	else if((!isOperator(a.value))&&isOperator(b.value))
	            	{
	            		root.leftchild=b;
			            root.rightchild=a;
	            	}else
	            	{
	            		if(compare(a.value,b.value)==1||compare(a.value,b.value)==0)
	            		{
	            			 root.leftchild=a;
					            root.rightchild=b;
	            		}
	            		else if(compare(a.value,b.value)==-1)
	            		{
	            			root.leftchild=b;
				            root.rightchild=a;
	            		}
	            		
	            	}
	            	 stack.push(root);
	            }
	            else
	            {
	            	 Node root=new Node(c);
			            root.leftchild=stack.pop();
			            root.rightchild=stack.pop();
			            stack.push(root);
	            }
	           
	        }
	        else
	        {
	        	Node root=new Node(c);
	            stack.push(root);
	        }
	    }
	    if(stack.isEmpty()||stack.size()>1)
	    {
	        System.err.println("����ĺ�׺���ʽ����ȷ");
	        return;
	    }
	    PostOrderTravels(stack.pop());
	}

	public static boolean isOperator(String s) {
		if (s.equals("+")) {
			return true;
		} else if (s.equals("-")) {
			return true;
		} else if (s.equals("*")) {
			return true;
		} else if (s.equals("��")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ���ʽڵ㣺���ڵ��ֵȡ��������ӡ��
	 * 
	 * @param node
	 *            ����ʵĽڵ㡣
	 */
	private static void visit(Node node) {
		/**
		 * ���ڵ�Ϊ��ʱ���ء�
		 */
		if (node == null) {
			return;
		}

		String value = node.value;
		str = str + value + " ";
		// System.out.println(str);
	}

	/**
	 * ��ָ���ڵ���Ϊ���ڵ㿪ʼ�ݹ�������к��������
	 * 
	 * @param node
	 *            ָ���ڵ㡣
	 */
	private static void PostOrderTravels(Node node) {
		if (node == null) {
			return;
		} else {

			PostOrderTravels(node.leftchild);
			PostOrderTravels(node.rightchild);
			visit(node);
		}
	}
	//�Ƚ����������Ĵ�С
	public static int compare(String a,String b)
	{
		int fenmu;
		int fenzi;
		// ת��
		fenshu f1 = new fenshu();
		f1 = Calculate.OperandChange(a);
		fenshu f2 = new fenshu();
		f2 = Calculate.OperandChange(b);
		int fenmu1 = f1.getFenmu();
		int fenzi1 = f1.getFenzi();
		int fenmu2 = f2.getFenmu();
		int fenzi2 = f2.getFenzi();
		int gcm = Calculate.getMCM(fenmu1, fenmu2);
		fenzi1 = gcm * fenzi1 / fenmu1;
		fenzi2 = gcm * fenzi2 / fenmu2;
		if(fenzi1>fenzi2)
			return 1;
		else if(fenzi1<fenzi2)
			return -1;
		else
			return 0;
	}
}