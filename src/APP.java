import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class APP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String texto;
		char vocales[]= {'a','e','i','o','u'};
		Contador[] thread= new Contador[5];
		AtomicInteger[] count=new AtomicInteger[5];
		Monitor monitor = new Monitor();
		
		System.out.println("Introduce una cadena de texto(No se realizaran comprobaciones de introduccion de caracteres numericos)");
		texto = sc.nextLine();
		texto=texto.toLowerCase();
		
		
		for(int i=0;i<vocales.length;i++) {
		count[i] = new AtomicInteger(0);
		thread[i] = new Contador(vocales[i], count[i], monitor, texto);	
		thread[i].start();
		}
		
		for(int i =0;i<count.length;i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Letra "+vocales[i]+": "+count[i].get());

		}
		System.out.println("Cantidad total de vocales: "+monitor.getContador());
		
	}

}
