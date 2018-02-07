
public class Monitor {
	int contador=0;
	boolean ocupado = false;
	
	public synchronized void count() {
		if(ocupado==false) {
			ocupado=true;
		}else {
			try {
				System.out.println("holi");
				wait();
			}catch(Exception e) {}	
			
		}
		contador++;
		notify();
		ocupado=false;
		
	}
	
	public int getContador() {
		return this.contador;
	}
}
