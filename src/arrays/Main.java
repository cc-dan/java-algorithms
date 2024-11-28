package arrays;

public class Main 
{
	public static void main(String[] args) 
	{
		NodeInt a = new NodeInt();
		a.data = 7;
		NodeInt b = new NodeInt();
		b.data = 15;
		a.next = b;
		NodeInt c = new NodeInt();
		c.data = 6;
		b.next = c;
		NodeInt d = new NodeInt();
		d.data = 13;
		c.next = d;
		NodeInt e = new NodeInt();
		e.data = 7;
		d.next = e;
		LinkedList list = new LinkedList();
		list.first = a;
		System.out.println(list);
		list.sublistaParesDesde(2);
		System.out.println(list);
		/*list.addAt(3, 123);
		list.insertOrdered(200);
		list.insertOrdered(8);
		list.insertOrdered(200);
		System.out.println(list.toString());
		list.cutTo(2);
		System.out.println(list.toString());
		list.insertMinMax();
		System.out.println(list.toString());*/
	}
}
