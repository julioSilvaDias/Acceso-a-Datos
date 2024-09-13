package prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PruebaEncriptacion {

	public static void main(String[] args) {
		ArrayList<Character> passChar = new ArrayList<Character>();
		String passString = "";
		int intentos = 0;

		Scanner teclado = new Scanner(System.in);
		String passwordUser = null;

		boolean valido = false;

		do {
			System.out.println("Dime la contraseña: ");
			passwordUser = teclado.nextLine();
			String passwordEncript = md5OfString(passwordUser);

			File fichero = new File("c:/Trastero/FichBytes.dat");

			try {
				FileInputStream fic = new FileInputStream(fichero);
				int i;

				while ((i = fic.read()) != -1) {
					// System.out.print((char) +i);
					passChar.add((char) +i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int i = 0; i < passChar.size(); i++) {
				passString += passChar.get(i).toString();
			}

			System.out.println(passString);

			if (passwordEncript.equals(passString)) {
				System.out.println("bienvenido");
				intentos=0;

			} else {
				System.out.println("contraseña incorrecta");
				intentos++;
				escribirLog(intentos);

			}
		} while (!valido);

	}

	public static void escribirLog(int intento) {
		File fichero = new File("c:/Trastero/miApp.log");
		Date current = new Date();

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fichero);

			String log = current + " intento: " + intento + ". INTENTO Fallido de Acceso a ROOT.\r\n";
			char[] pass = log.toCharArray();

			for (int i = 0; i < pass.length; i++) {

				fileOutputStream.write(pass[i]);

			}
			
			fileOutputStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String md5OfString(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
