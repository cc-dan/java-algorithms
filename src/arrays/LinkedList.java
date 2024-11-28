package arrays;

public class LinkedList 
{
	NodeInt first;
	
	public int length()
	{
		NodeInt node = this.first;
		
		if (node == null)
			return 0;

		int length = 1;	
		while ((node = node.next) != null)
			length++;
		
		return length;
	}
	
	public boolean isEmpty()
	{
		return this.first == null;
	}
	
	public int sum()
	{
		if (this.isEmpty())
			return 0;
		
		int sum = 0;
		NodeInt node = this.first;
		while (node != null)
		{
			sum += node.data;
			node = node.next;
		}
		return sum;
	}
	
	public int average()
	{
		return this.isEmpty()? 0 : this.sum() / this.length();
	}
	
	public NodeInt nth(int n)
	{
		if (this.isEmpty() || n >= this.length() || n < 0)
			return null;
		NodeInt node = this.first;
		while (n > 0)
		{
			node = node.next;
			n--;
		}
		return node;
	}
	
	public int max()
	{
		if (this.isEmpty())
			throw new RuntimeException();
		NodeInt node = this.first;
		int n = node.data;
		while ((node = node.next) != null)
			if (node.data > n)
				n = node.data;
		return n;
	}
	
	public boolean isSorted()
	{
		if (this.isEmpty())
			return true;
		NodeInt node = this.first;
		while (node.next != null)
		{
			if (node.next.data < node.data)
				return false;
			node = node.next;
		}
		return true;
	}
	
	public boolean noDuplicates()
	{
		if (this.isEmpty())
			return true;
		
		NodeInt current = this.first;
		do
		{
			NodeInt check = current.next;
			while (check != null)
			{
				if (check.data == current.data)
					return false;
				check = check.next;
			}
			current = current.next;
		}
		while (current != null);
			
		return true;
	}
	
	public void rotateRight()
	{
		if (this.isEmpty() || this.length() == 1)
			return;
		
		NodeInt previous = this.first;
		NodeInt current = this.first.next;
		while (current.next != null)
		{
			previous = current;
			current = current.next;
		}
		current.next = this.first;
		this.first = current;
		previous.next = null;
	}
	
	public String toString()
	{
		String output = "";
		NodeInt node = this.first;
		while (node != null)
		{
			output += node.data + " ";
			node = node.next;
		}
		return output;
	}
	
	
	
	public void addAt(int position, int data)
	{
		if (position < 0 || position > this.length())
			throw new RuntimeException();
		
		NodeInt node = new NodeInt();
		node.data = data;
		
		NodeInt previous = this.nth(position - 1);
		if (previous == null)
		{
			node.next = this.first;
			this.first = node;
		}
		else if (previous.next == null)
		{
			previous.next = node;
			node.next = null;
		}
		else
		{
			node.next = previous.next;
			previous.next = node;
		}
	}
	
	public void insertOrdered(int n)
	{
		if (!this.isSorted())
			throw new RuntimeException();
		
		NodeInt addition = new NodeInt();
		addition.data = n;
		
		if (this.isEmpty())
		{
			this.first = addition;
			addition.next = null;
		}
		
		NodeInt node = this.first;
		while (node.next != null && node.next.data < n)
			node = node.next;
		
		if (node.next == null)
		{
			node.next = addition;
			addition.next = null;
		}
		else
		{
			addition.next = node.next;
			node.next = addition;
		}
	}
	
	public void remove(int e)
	{
		if (this.isEmpty())
			throw new RuntimeException();
		
		NodeInt node = this.first;
		if (node.data == e)
			this.first = node.next;
		else
			while (node.next != null)
			{
				if (node.next.data == e)
				{
					node.next = node.next.next;
					return;
				}
				node = node.next;
			}
	}
	
	public void removeAll(int e)
	{
		if (this.isEmpty())
			throw new RuntimeException();
		
		NodeInt previous = null;
		NodeInt node = this.first;
		while (node != null)
		{
			if (node.data == e)
			{
				if (previous == null)
					this.first = node.next;
				else
					previous.next = node.next;	
			}
			else
				previous = node;
			node = node.next;
		}
	}
	
	public void removeByIndex(int i)
	{
		if (i < 0 || i >= this.length())
			throw new RuntimeException();
		NodeInt previous = this.nth(i - 1);
		if (previous == null)
			this.first = this.first.next;
		else
			previous.next = previous.next.next;
	}
	
	public void exchange(int here, int there)
	{
		if (here < 0 || there >= this.length())
			throw new RuntimeException();
		NodeInt a = this.nth(here);
		NodeInt b = this.nth(there);
		int aux = a.data;
		a.data = b.data;
		b.data = aux;
	}
	
	public void removeDuplicates()
	{
		NodeInt iter = this.first;
		while (iter != null)
		{
			NodeInt previous = iter;
			NodeInt current = iter.next;
			while (current != null)
			{
				if (current.data == iter.data)
					previous.next = current.next;
				else
					previous = previous.next;
				current = current.next;
			}
			iter = iter.next;
		}
	}
	
	public void invert()
	{
		NodeInt previous = null;
		NodeInt current = this.first;
		while (current != null)
		{
			NodeInt next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		this.first = previous;
	}
	
	public void cutFrom(int index)
	{
		if (index < 0 || index >= this.length())
			throw new RuntimeException();
		this.nth(index).next = null;
	}
	
	public void cutTo(int index)
	{
		if (index < 0 || index >= this.length())
			throw new RuntimeException();
		this.first = this.nth(index);
	}
	
	public void insertMinMax()
	{
		if (this.isEmpty()) return;
		
		int min, max;
		min = max = this.first.data;
		
		NodeInt n = this.first.next;
		while (n.next != null)
		{
			if (n.data > max)
				max = n.data;
			if (n.data < min)
				min = n.data;
			n = n.next;
		}
		if (n.data > max)
			max = n.data;
		if (n.data < min)
			min = n.data;
		
		NodeInt a = new NodeInt();
		a.data = min;
		a.next = this.first;
		this.first = a;
		
		NodeInt b = new NodeInt();
		b.data = max;
		n.next = b;
	}
	
	void eliminarNoDivisores()
	{
		int valor = 0;
		NodeInt n = this.first;
		while (n != null)
		{
			valor += n.data;
			n = n.next;
		}
		System.out.println(valor);
		
		while (this.first != null && valor % this.first.data != 0)
			this.first = this.first.next;
		
		NodeInt anterior = this.first;
		n = anterior.next;
		while (n != null)
		{
			if (valor % n.data != 0)
				anterior.next = n.next;
			else
				anterior = n;
			n = n.next;
		}
	}
	
	void eliminarMaximosLocales()
	{
		int eliminados = 0;
		NodeInt anterior = this.first;
		if (anterior == null)
		{
			NodeInt nuevo = new NodeInt();
			nuevo.data = 0;
			this.first = nuevo;
			return;
		}
		NodeInt actual = anterior.next;
		if (actual == null)
		{
			NodeInt nuevo = new NodeInt();
			nuevo.data = 0;
			this.first.next = nuevo;
			return;
		}
		while (actual.next != null)
		{
			if (anterior.data < actual.data && actual.next.data < actual.data)
			{
				anterior.next = actual.next;
				eliminados++;
			}
			else
				anterior = actual;
			actual = actual.next;
		}
		NodeInt nuevo = new NodeInt();
		nuevo.data = eliminados;
		actual.next = nuevo;
	}
	
	void sumarExtremos(int m)
	{
		int longitud = 0;
		NodeInt n = this.first;
		while (n != null)
		{
			longitud++;
			n = n.next;
		}
		
		int izquierda = 0;
		int derecha = 0;
		
		n = this.first;
		int iterador = 0;
		while (n != null)
		{
			if (iterador < m)
				izquierda += n.data;
			else if (iterador >= longitud - m)
				derecha += n.data;
			iterador++;
			n = n.next;
		}
		
		n = this.first;
		iterador = 0;
		while (iterador < m)
		{
			n = n.next;
			iterador++;
		}
		NodeInt izq = n;
		
		n = this.first;
		iterador = 0;
		while (iterador < longitud - m)
		{
			n = n.next;
			iterador++;
		}
		NodeInt der = n;
		
		der.data = derecha;
		der.next = null;
		izq.data = izquierda;
		this.first = izq;
	}
	
	int quitar(int pos, int n)
	{
		if (pos == 0)
		{
			int eliminados = 0;
			while (n > 0 && this.first != null)
			{
				this.first = this.first.next;
				eliminados++;
			}
			return eliminados;
		}
		NodeInt anterior = this.first;
		NodeInt actual = anterior.next;
		while (pos > 1 && actual != null)
		{
			anterior = actual;
			actual = actual.next;
			pos--;
		}
		int eliminados = 0;
		while (n > 0 && actual != null)
		{
			anterior.next = actual.next;
			actual = actual.next;
			eliminados++;
			n--;
		}
		return eliminados;
	}
	
	void sublistaParesDesde(int k)
	{
		NodeInt n = this.first;
		while (k > 0 && n != null)
		{
			n = n.next;
			k--;
		}
		this.first = n;
		if (this.first == null) return;
		
		NodeInt anterior = this.first;
		NodeInt actual = this.first.next;
		while (actual != null)
		{
			if (actual.data % 2 != 0)
				anterior.next = actual.next;
			else
				anterior = actual;
			actual = actual.next;
		}
	}
}
