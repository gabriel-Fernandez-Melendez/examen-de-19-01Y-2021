package entidades;

import java.util.Scanner;

import utils.Datos;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;

	private DatosPersona persona;

	public Manager(long id, String telefono, String direccion) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Manager(long id, String telefono, String direccion, DatosPersona dp) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = dp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}
	
	public static Manager nuevoManager() {
		boolean val=true;
		long id=0;
		String telefono="";
		String direccion="";
		Manager ret=new Manager();
		Scanner scan=new Scanner(System.in);
		
		do {
		System.out.println("introduce el id del manager");
		id=scan.nextLong();
		if(id<1) {
			System.out.println("su valor no es valido,introduzca un valor valido");
			val=false;
		}
		else {
			val=true;
		}
		}while(!val);
		val=false;
		do {
			System.out.println("introduce el telefono del manager");
			telefono=scan.nextLine();
			if(telefono.length()<9) {
				System.out.println("su valor no es valido,introduzca un valor valido");
				val=false;
			}
			else {
				val=true;
			}
			}while(!val);
		val=false;
		do {
			System.out.println("introduce la direccion del manager");
			direccion=scan.nextLine();
			if(direccion.length()<29) {
				System.out.println("su valor no es valido,introduzca un valor valido");
				val=false;
			}
			else {
				val=true;
			}
			}while(!val);
		
		return ret(id,telefono,direccion);
		
	}
	

}
