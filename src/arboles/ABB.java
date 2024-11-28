package arboles;

public class ABB<T extends Comparable<T>> {
	
	private class Nodo {
		Nodo izq, der;
		T elem;
		
		Nodo(T elem) {
			this.elem = elem;
		}
		
		T get() {
			return elem;
		}
	}
	
	private Nodo raiz;
	
	// Constructor
	public ABB() {}
	
	public void agregar(T elem) {
		raiz = agregar(raiz, elem);
	}
	
	// Argumento nodo = espacio en el que se va a chequear si se puede crear.
	private Nodo agregar(Nodo nodo, T elem) {
		// Complejidad: o(n), o(log n) cuando el arbol está balanceado.
		if (nodo == null) return new Nodo(elem);
		if (nodo.elem.compareTo(elem) < 0)
			nodo.der = agregar(nodo.der, elem);
		else if (nodo.elem.compareTo(elem) > 0)
			nodo.izq = agregar(nodo.izq, elem);
		return nodo;
	}

	public boolean pertenece(T elem) {
		return pertenece(raiz, elem);
	}
	
	private boolean pertenece(Nodo nodo, T elem) {
		// Complejidad: o(n), o(log n) cuando el arbol está balanceado.
		if (nodo == null) return false;
		if (nodo.elem.equals(elem)) return true;
		return nodo.elem.compareTo(elem) < 0? pertenece(nodo.der, elem) : pertenece(nodo.izq, elem);
	}

	public void quitar(T elem) {
		raiz = quitar(raiz, elem);
	}
	
	private Nodo quitar(Nodo nodo, T elem) {
		// casos que se pueden dar:
		// 1. no lo encuentra
		// 2. es una hoja
		// 3. tiene 1 hijo
		// 4. tiene 2 hijos
		// Complejidad: o(n), o(log n) cuando el arbol está balanceado.
		if (nodo == null) return null;
		if (nodo.elem.equals(elem)) {
			if (nodo.der == null) return nodo.izq;
			if (nodo.izq == null) return nodo.der;
			// agarrar el máximo de la izquierda
			T maximo = maximo(nodo.izq);
			nodo.izq = quitar(nodo.izq, maximo);
			nodo.elem = maximo;
			return nodo;
		}
		if (nodo.elem.compareTo(elem) < 0)
			nodo.der = quitar(nodo.der, elem);
		else
			nodo.izq = quitar(nodo.izq, elem);
		return nodo;
	}
	
	public int cantElementos() {
		return cantElementos(raiz);
	}
	
	private int cantElementos(Nodo n) { // metodo recursivo
		// Complejidad: o(n)
		return n == null? 0 : 1 + cantElementos(n.izq) + cantElementos(n.der);
	}
	
	public int altura() {
//	        * 1+ max( 2 ; 1) = 3
//		   / \
//1+(1;0) *   * 1 + (0; 0)
//		 /   
//	1	*
		return altura(raiz);
	}
	
	private int altura(Nodo n) {
		// Complejidad: o(n)
		return n == null? 0 : 1 + maximo(altura(n.izq), altura(n.der));
	}
	
	private int maximo(int altura, int altura2) {
		return Math.max(altura, altura2);
	}
	
	private T maximo(Nodo nodo) {
		// Complejidad: o(n), o(log n) cuando el arbol está balanceado.
		if (nodo == null) return null;
		if (nodo.der == null) return nodo.elem;
		return maximo(nodo.der);
	}
	
	private T minimo(Nodo nodo) {
		if (nodo == null) return null;
		if (nodo.izq == null) return nodo.elem;
		return minimo(nodo.izq);
	}

	public boolean estaBalanceado() {
		return Math.abs(altura(raiz.izq) - altura(raiz.der)) <= 1;
	}
	
	@Override
	public String toString() {
		return print(raiz);
	}
	
	private String print(Nodo nodo) {
		if (nodo == null) return "";
		return nodo.elem + " " + print(nodo.izq) + print(nodo.der);
	}
}
