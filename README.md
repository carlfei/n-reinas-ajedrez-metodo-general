# n-reinas-ajedrez-metodo-general

Metodo lógico parecido a aplicar un ábaco.


Método general para obtener reinas en tableros cuadrados de ajedrez de un número de casillas horizontales:  x=4+n, igual al número de reinas, las cuales cumplen la propiedad de no amenazarse entre ellas según los movimientos de la reina en el juego de ajedrez, computacionalmente no viable para un número grande de reinas en el tablero.


Para aplicar el método se  empieza colocando una reina sobre cualquier casilla vertical de x=1,  a continuación : colocar en las casillas verticales siguientes de x=2 todas las reinas que no se amenacen con la anterior de x=1, repetir este procedimiento con todas las reinas de x=2 sobre x=3 , a partir de la casilla x=3  eliminar del procedimiento las reinas dispuestas en las casillas actuales de x que se amenazan con las de las casillas anteriores, con las reinas que no han sido eliminadas repetir el proceso hasta llegar si se puede a x=n.

Para el codigo -->en la variable numer_tablero -->pon el numero de casillas del tablero EJ: 8
en la variable coor_y  -->pon la coordenada y que es la posicion de la reina en x=1, en la que empieza a calcular, si quisieras sacar todas
las reinas de un tablero de 8 tendrias que ir poniendo y ejecutando: coor_y=1, coor_y=2, coor_y=3, coor_y=4,
coor_y=5, coor_y=6, coor_y=7, coor_y=8

En el directorio C crea una carpeta con el nombre de "queen", es donde escribe el fichero





Ejemplo de operación fallida


![Alt text](https://github.com/carlfei/n-reinas-ajedrez-metodo-general/blob/master/ejemplo_fallido.png "")







Ejemplo de operación exito


![Alt text](https://github.com/carlfei/n-reinas-ajedrez-metodo-general/blob/master/1.png "")
![Alt text](https://github.com/carlfei/n-reinas-ajedrez-metodo-general/blob/master/2.png "")


![Alt text](https://github.com/carlfei/n-reinas-ajedrez-metodo-general/blob/master/3.png "")
![Alt text](https://github.com/carlfei/n-reinas-ajedrez-metodo-general/blob/master/4.png "")








En el codigo para las variables con  numer_tablero=8 y coor_y=6, el codigo genera un fichero:


+
+
6,1,5,2,8,3,7,4;
+
+
+
+
+
+
+
+
6,2,7,1,3,5,8,4;
6,2,7,1,4,8,5,3;
+
+
+
+
6,3,1,7,5,8,2,4;
6,3,1,8,4,2,7,5;
6,3,1,8,5,2,4,7;
6,3,5,7,1,4,2,8;
6,3,5,8,1,4,2,7;
+
6,3,7,2,4,8,1,5;
6,3,7,2,8,5,1,4;
+
6,3,7,4,1,8,2,5;
+
+
6,4,1,5,8,2,7,3;
+
+
+
+
+
+
6,4,2,8,5,7,1,3;
6,4,7,1,3,5,2,8;
+
6,4,7,1,8,2,5,3;
+
+
+
+
6,8,2,4,1,7,5,3;
+
+
+
+
+
+

que para la primera reina colocada en y=6, son todas las reinas que hay en un tablero de 8 


https://problema-de-las-1000-reinas-resuelto.blogspot.com/2019/08/metodo-general-8-reinas.html

