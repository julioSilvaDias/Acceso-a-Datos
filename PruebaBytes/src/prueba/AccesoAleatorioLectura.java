package prueba;

import java.io.File;
import java.io.RandomAccessFile;

public class AccesoAleatorioLectura {

	private static final String RUTA = "C:/Trastero/AleatorioEmple.dat";

	public static void main(String[] args) {

		try {
			File fichero = new File(RUTA);
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			int id, dep, posicion;
			Double salario = null;
			char apellido[] = new char[10], aux = 0;
			posicion = 0;
			int i;
			while ((i = file.read()) != -1) {
				file.seek(posicion);
				id = file.readInt();
				
				for (int j = 0; j < apellido.length; j++) {
					aux=file.readChar();
					apellido[j] = aux;
				}

				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();

				if (id > 0)
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f, %n", id, apellidos.trim(),
							dep, salario);
				posicion = posicion + 36;

			}

			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
