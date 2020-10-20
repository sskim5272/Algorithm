package hw.step04;

public class SimpleLinkedList
{
	private  Node head;
	
	public void addFirseNode(String data)
	{
		Node newNode =new Node(data,head);
		head =newNode;
	}
	public void deleteFirseNode(String data)
	{
		Node newNode =new Node(data,head);
		head =newNode;
	}
	
	
	
	public void printLisg()
	{
		for(Node currNede=head;currNede!=null;currNede=currNede.link) {
			System.out.print(currNede.data+"	");
		}
		System.out.println();
	}
}
