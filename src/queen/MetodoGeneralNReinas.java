package queen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MetodoGeneralNReinas {

	public static void main(String[] args) throws IOException {

		int numer_tablero = 8; // el numero de casillas horizontales del tablero cuadrado

		int[][] coorden_piramide_der_nega = new int[numer_tablero + 1][numer_tablero + 1];
		int[][] coorden_piramide_der_posi = new int[numer_tablero + 1][numer_tablero + 1];
		int[][] arr_tabla_coor_y = new int[numer_tablero][numer_tablero];

		int coor_y = 6; // la posicion de la primera reina en x=1

		int[] coordenadas_fila_gusano = new int[10000];

		int i = 0, i2 = 0, i3 = 0, i8 = 0, coorde_x_actual = 0;

		String coge_casilla = "", cada_casilla = "";
		String coge_fila_entera = "";

		int salida = 0;

		int my_casilla = 0, my_coorde = 0, numero_comas = 0, no_vale = 0;

		for (i = 0; i < numer_tablero; i++) {
			i3 = 0;
			for (i2 = 0; i2 < numer_tablero; i2++) {

				if ((i + 1) - (i2 + 1) > 1 || (i + 1) - (i2 + 1) < -1) {

					arr_tabla_coor_y[i][i3] = i2 + 1;
					i3++;

				}
			}
		}

		for (i = 0; i < numer_tablero; i++) {
			for (i2 = 0; i2 < numer_tablero; i2++) {

				i3 = numer_tablero - (i2);
				coorden_piramide_der_posi[i][i2] = i3 + (i);
				i3 = 0;

			}

		}

		for (i = 0; i < numer_tablero; i++) {
			for (i2 = 0; i2 < numer_tablero; i2++) {

				i3 = (i2) - numer_tablero;
				coorden_piramide_der_nega[i][i2] = i3 + (i);
			}

		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\queen\\gusano.txt")));

			out.println(coor_y);
			out.close();

		} catch (IOException e) {

		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\queen\\gusano.txt")));
			i = 0;
			i2 = 0;
			my_coorde = coor_y;
			for (i = 0; i < arr_tabla_coor_y[my_coorde - 1].length; i++) {
				my_casilla = arr_tabla_coor_y[my_coorde - 1][i];
				if (my_casilla != 0 && my_casilla != coor_y
						&& coorden_piramide_der_posi[i2][my_coorde - 1] != coorden_piramide_der_posi[i2 + 1][my_casilla
								- 1]
						&& coorden_piramide_der_nega[i2][my_coorde - 1] != coorden_piramide_der_nega[i2 + 1][my_casilla
								- 1]) {

					out.print(coor_y + "," + my_casilla + ";");

				}
				out.println();
			}

			out.close();
		} catch (IOException e) {

		}

		for (i8 = 0; i8 < numer_tablero - 2; i8++) {
			coorde_x_actual++;
			try {

				File dest = new File("C:\\queen\\gusano.txt");
				FileInputStream fis = new FileInputStream(dest);

				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\queen\\gusano2.txt", true)));
				int las_que_van = 0;
				char current;
				coordenadas_fila_gusano = new int[10000];
				numero_comas = 0;
				salida = 0;
				coge_casilla = "";
				coge_fila_entera = "";
				cada_casilla = "";
				while (fis.available() > 0) {
					current = (char) fis.read();

					if (numero_comas == coorde_x_actual) {
						if (current != ';' && current != '\n' && current != '+') {
							coge_casilla = coge_casilla + current;
						} else {
							salida = 1;
						}
					}

					if (current != ',' && current != ';' && current != '\n' && current != '+') {
						cada_casilla = cada_casilla + current;

					}

					if (current == ',' || current == ';') {
						cada_casilla = cada_casilla.trim();
						int numero = Integer.parseInt(cada_casilla);
						coordenadas_fila_gusano[numero_comas] = numero;
						cada_casilla = "";
						numero_comas++;
					}
					if (salida == 0) {
						coge_fila_entera = coge_fila_entera + current;

					}

					if (current == '+') {
						coordenadas_fila_gusano = new int[10000];
						numero_comas = 0;
						salida = 0;
						coge_casilla = "";
						coge_fila_entera = "";
						cada_casilla = "";

					}

					if (salida == 1) {

						my_coorde = Integer.parseInt(coge_casilla);
						int no_hay_mas = 0;
						for (i = 0; i < arr_tabla_coor_y[my_coorde - 1].length; i++) {
							my_casilla = arr_tabla_coor_y[my_coorde - 1][i];
							if (my_casilla != 0) {
								no_vale = 0;
								for (i2 = 0; i2 < numero_comas; i2++) {

									if (my_casilla == coordenadas_fila_gusano[i2]
											|| coorden_piramide_der_posi[i2][coordenadas_fila_gusano[i2]
													- 1] == coorden_piramide_der_posi[numero_comas][my_casilla - 1]
											|| coorden_piramide_der_nega[i2][coordenadas_fila_gusano[i2]
													- 1] == coorden_piramide_der_nega[numero_comas][my_casilla - 1]) {
										no_vale = 1;
									}

								}

								if (no_vale == 0) {
									coge_fila_entera = coge_fila_entera.trim();
									out.print(coge_fila_entera + "," + my_casilla + ";");
									out.println();
									las_que_van++;
									System.out.println(las_que_van + " coorde: " + coorde_x_actual);
									no_hay_mas = 1;
								}
							}

						}

						if (no_hay_mas == 0) {
							out.print("+");
							out.println();
						}

						coordenadas_fila_gusano = new int[10000];
						numero_comas = 0;
						salida = 0;
						coge_casilla = "";
						coge_fila_entera = "";
						cada_casilla = "";

					}
				}

				fis.close();
				out.close();

				if (dest.exists()) {
					dest.delete();
				}

				File file = new File("C:\\queen\\gusano2.txt");
				boolean renameResult = file.renameTo(new File("C:\\queen\\gusano.txt"));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}