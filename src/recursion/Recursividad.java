package recursion;

public class Recursividad {
	public static int sum_to(int n)
	{
		return (n > 0)? n + sum_to(n-1) : 0;
	}
	
	public static void print_to(int n)
	{
		if (n > 0)
		{
			print_to(n - 1);
			System.out.println(n);
		}
	}
	
	public static void print_from(int n)
	{
		if (n > 0)
		{
			System.out.println(n);
			print_from(n - 1);
		}
	}
	
	public static int squares_sum_to(int n)
	{
		return (n > 0)? (n * n) + squares_sum_to(n - 1) : 0;
	}
	
	public static int power(int number, int exponent)
	{
		return (exponent > 0)? number * power(number, exponent - 1) : 1;
	}
	
	public static int sum_between(int a, int b)
	{
		return (a < b)? a + sum_between(a + 1, b) : a;
	}
	
	public static boolean is_prime(int n)
	{
		if (n < 2)
			return false;	
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	
	public static int primes_between(int a, int b)
	{
		return (is_prime(a)? 1 : 0) + ((a < b)? primes_between(a + 1, b) : 0);
	}
	
	public static boolean is_even(int n)
	{
		return (n > 0)? is_even(n - 2) : n == 0;
	}
	
	public static boolean is_uneven(int n)
	{
		return (n > 0)? is_uneven(n - 2) : n != 0;
	}
	
	public static int digits(int n)
	{
		return (n > 9)? 1 + digits(n / 10) : 1;
	}
	
	public static int[] remainder(int[] complete)
	{
		int[] cut = new int[complete.length - 1];
		for (int i = 0; i < cut.length; i++)
			cut[i] = complete[i + 1];
		return cut;
	}
	
	public static void print(int[] a) 
	{
		System.out.print(a[0] + " ");
		if (a.length > 1)
			print(remainder(a));
	}
	
	public static int sum(int[] a)
	{
		return (a.length > 0)? (a[0] + ((a.length > 1)? sum(remainder(a)) : 0)) : 0;
	}
	
	public static boolean is_sorted(int[] a)
	{
		if (a.length > 1)
			return (a[0] < a[1])? is_sorted(remainder(a)) : false;
		return true;
	}
	
	public static int apparitions(int[] a, int n)
	{
		return ((a[0] == n)? 1 : 0) + ((a.length > 1)? apparitions(remainder(a), n) : 0);
	}
	
	public static boolean belongs(int[] array, int number)
	{
		if (array[0] == number)
			return true;
		if (array.length > 1)
			return belongs(remainder(array), number);
		return array[0] == number;
	}
	
	public static int length(String s)
	{
		return s.equals("")? 0 : 1 + length(s.substring(1));
	}
	
	public static String reverse(String s)
	{
		return s.length() > 1? reverse(s.substring(1)) + s.charAt(0) : s;
	}
	
	public static String combine(String a, String b)
	{
		if (a.equals("") && !b.equals(""))
			return b.charAt(0) + combine(a, b.substring(1));
		else if (b.equals("") && !a.equals(""))
			return a.charAt(0) + combine(a.substring(1), b);
		else if (a.equals("") && b.equals(""))
			return "";
		return ((a.charAt(0) < b.charAt(0))? a.charAt(0) : b.charAt(0)) + combine(a.substring(1), b.substring(1));
	}
	
	public static void starry(String s)
	{
		if (s.length() > 1)
		{
			System.out.print(s.charAt(0) + "*");
			starry(s.substring(1));
		}
		else
			System.out.println(s);
	}
	
	public static boolean is_alphabetic(String s)
	{
		if (s.length() > 1)
			return (s.charAt(0) <= s.charAt(1))? is_alphabetic(s.substring(1)) : false;
		return true;
	}
	
	public static int fibonacci(int index)
	{
		if (index > 1)
			return fibonacci(index - 1) + fibonacci(index - 2);
		return (index == 1)? 1 : 0;
	}
	
	public static int fibiter(int index)
	{		
		int a = 0, b = 1;
		for (int i = 1; i < index; i++)
		{
			int aux = b;
			b += a;
			a = aux;
		}
		return b;
	}
	
	public static void collatz(int n)
	{
		if (n > 1)
		{
			if (n % 2 == 0) 
				collatz(n / 2);
			else
				collatz(3 * n + 1);
		}
		System.out.println(n);
	}
	
	public static int mcd(int a, int b)
	{
		return (b != 0)? mcd(b, a % b) : a;
	}
	
	public static String no_repeats(String s)
	{
		if (s.length() > 1)
		{
			if (s.substring(1).charAt(0) == s.charAt(0))
				return no_repeats(s.substring(1));
			return s.charAt(0) + no_repeats(s.substring(1));
		}
		return s;
	}
	
	public static int prodCifras(int n)
	{
		if (n < 10)
			return (n == 0)? 1 : n;
		int digit = n % 10;
		return (digit == 0)? prodCifras(n / 10) : digit * prodCifras(n / 10);
	}
	
	public static String first(String a, String b)
	{
		if (a.charAt(0) < b.charAt(0))
			return a;
		else if (b.charAt(0) < a.charAt(0))
			return b;
		return a.charAt(0) + first(a.substring(1), b.substring(1));
	}
	
	public static String resto(String s) { 
		String nuevo = "";
		for (int i = 1; i < s.length(); i++) { //arranca en la posici�n 1 dejando afuera la posici�n 0
			nuevo = nuevo + s.charAt(i);
		}
		return nuevo;
	}
	
	public static String rotate(String s, int n)
	{
		return (n > 0)? rotate(s.substring(1) + s.charAt(0), n - 1) : s;
	}
	
	public static String take_from(String s, int from, int quantity)
	{
		if (quantity > 0 && from < s.length())
			return s.charAt(from) + take_from(s, from + 1, quantity - 1);
		return "";
	}
	
	public static String insert_ordered(String s, char c)
	{
		if (s.length() > 1)
			return (c <= s.charAt(0))? c + s : s.charAt(0) + insert_ordered(s.substring(1), c);
		return (c <= s.charAt(0))? c + s : s + c;
	}
	
	public static boolean starts_with(String prefix, String s)
	{
		if (s.length() < prefix.length())
			return false;
		if (prefix.length() == 0)
			return true;
		if (prefix.length() > 1)
			return (prefix.charAt(0) == s.charAt(0))? starts_with(prefix.substring(1), s.substring(1)) : false;
		return prefix.charAt(0) == s.charAt(0);
	}
	
	public static String cut_vowels_and_revert(String s)
	{
		if (s.length() > 0 &&
			(s.charAt(0) == 'a') ||
			(s.charAt(0) == 'e') ||
			(s.charAt(0) == 'i') ||
			(s.charAt(0) == 'o') ||
			(s.charAt(0) == 'u'))
			return (s.length() > 1)? cut_vowels_and_revert(s.substring(1)) : "";
		
		return (s.length() > 1)? cut_vowels_and_revert(s.substring(1)) + s.charAt(0) : s;
	}
	
	public static String reemplazarAlternando(String s, char c0, char c1, char c2)
	{
		if (s.isEmpty()) return "";
		if (s.charAt(0) == c0)
			return c1 + reemplazarAlternando(s.substring(1), c0, c2, c1);
		return s.charAt(0) + reemplazarAlternando(s.substring(1), c0, c1, c2);
	}
	
	public static boolean esGeneradoPor(String s, String t)
	{
		if (s.isEmpty()) return true;
		if (t.isEmpty()) return false;
		if (s.charAt(0) != t.charAt(0)) return false;
		return esGeneradoPor(s.substring(1), t.substring(1) + t.charAt(0));
	}
	
	public static String eliminarYDuplicar(String s, int indice)
	{
		if (s.isEmpty()) return "";
		char c = s.charAt(0);
		if (indice == 0)
			if (!esVocal(c))
				return c + "" + c + eliminarYDuplicar(s.substring(1), 0);
			else
				return eliminarYDuplicar(s.substring(1), 0);
		return c + eliminarYDuplicar(s.substring(1), indice - 1 );
	}
	
	public static boolean esVocal(char c)
	{
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	public static void main(String[] args) {
		System.out.println(sum_to(10));
		print_from(10);
		System.out.println(squares_sum_to(3));
		System.out.println(power(4, 3));
		System.out.println(sum_between(1, 8));
		System.out.println(primes_between(0, 99));
		System.out.println(is_even(13));
		System.out.println(is_uneven(13));
		System.out.println(digits(4));
		System.out.println(belongs(new int[]{1, 8, 6, 4}, 4));
		System.out.println(combine("fgd", "adfxgtgs"));
		starry("hola");
		System.out.println(is_alphabetic("adioss"));
		//System.out.println(fibiter(47));
		//collatz(9);
		System.out.println(mcd(36, 20));
		System.out.println(no_repeats("gggeeeeeuddddduu"));
		System.out.println(prodCifras(2034));
		System.out.println(first("candelabro", "canario"));
		System.out.println(rotate("abcdefghi", 3));
		System.out.println(take_from("", 1, 5));
		System.out.println(insert_ordered("abcdefghi", 'j'));
		System.out.println(starts_with("lastima", "las"));
		System.out.println(cut_vowels_and_revert("fadap"));
		System.out.println(reemplazarAlternando("a", 'a', 'e', 'o'));
		System.out.println(esGeneradoPor("ab", "abc"));
		System.out.println(eliminarYDuplicar("murcielago", 3));
	}

	
}
