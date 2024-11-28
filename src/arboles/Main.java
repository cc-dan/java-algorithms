package arboles;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ABB<Integer> arbol = new ABB<Integer>();
		arbol.agregar(14);
		arbol.agregar(3);
		arbol.agregar(34);
		arbol.agregar(5);
		arbol.agregar(1);
		System.out.println(arbol.toString());
		System.out.println(arbol.cantElementos());
	}

}
