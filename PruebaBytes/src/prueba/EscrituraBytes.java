package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class EscrituraBytes {

	public static void main(String[] args) {

		File fichero = new File("c:/Trastero/FichBytes.dat");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fichero);

			String password = "Elorrieta00";
			char[] pass = password.toCharArray();

			for (int i = 0; i < pass.length; i++) {

				fileOutputStream.write(pass[i]);

			}
			
			fileOutputStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
