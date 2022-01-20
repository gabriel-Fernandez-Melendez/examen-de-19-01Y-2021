package entidades;

import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;

public class Atleta extends Participante {
	private long idAtleta;
	private float altura;
	private float peso;

	private DatosPersona persona;

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(idAtleta, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	// metodo de clase
	public static Atleta nuevoAtleta() {
		boolean val = false;
		long idAtleta = 0;
		float altura = 0.0f;
		float peso = 0.0f;
		DatosPersona dp= new DatosPersona();
		Scanner scan = new Scanner(System.in);
		Atleta ret;
		do {
			System.out.println("introduce el id del atleta");
			idAtleta = scan.nextLong();
			if(idAtleta<1) {
				System.out.println("su respuesta no es valida");
				val=false;
				}
			else {
				val=true;
			}
		} while (!val);
		do {
			//aqui hago uso del primer metodo creado en el examen 
			System.out.println("introduce la altura del atleta");
			altura=Utilidades.leerfloat();
			//pongo aqui valido como true por que el metodo leer float ya se comprueba que sea un  numero valido
			val=true;
		}while(!val);
		do {
			System.out.println("introduce el peso del atleta");
			peso=Utilidades.leerfloat();
		}while(!val);
		do {
			System.out.println("introduzca los datos personales del atleta");
			dp=DatosPersona.nuevaPersona();
		}while(!val);
		
        //nota personal , tengo que declarar los argunmentos del objeto acorte con su constructor
		ret = new Atleta(idAtleta,altura,peso,dp);
		return ret;
	}

}
