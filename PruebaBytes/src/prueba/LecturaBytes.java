package prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecturaBytes {

	public static void main(String[] args) {
		File fichero = new File("c:/Trastero/FichBytes.dat");

		try {
			FileInputStream fic = new FileInputStream(fichero);
			int i;

			while ((i = fic.read()) != -1) {
				System.out.print((char) + i);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
