import java.util.concurrent.atomic.AtomicInteger;

public class Contador extends Thread {
	private AtomicInteger contador;
	private char vocal;
	private Monitor monitor;
	private String texto;
	
	public Contador(char vocal, AtomicInteger contador, Monitor monitor,String texto) {
		this.contador=contador;
		this.vocal=vocal;
		this.monitor=monitor;
		this.texto=texto;
	}
	
	public void run() {
		char textC[] =texto.toCharArray(); 
		for(int i=0;i<textC.length;i++) {
			if(textC[i]==vocal) {
				contador.incrementAndGet();
				monitor.count();
			}
		}	
	}
	
}
