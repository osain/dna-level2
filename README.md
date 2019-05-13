# dna-level2

<h3>ODA-DNA :: Guía rápida para ejecutar la API-REST (Nivel 2)</h3>

<p>
 <b>*ODA-DNA*</b> recibe como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN. 
 <b>*ODA-DNA*</b> determina que existe una mutación en el ADN si encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical, en cuyo caso responderá con un mensaje HTTP 200-OK. Si no existe mutación responderá con un mensaje HTTP 403-Forbidden.
</p>

<p>
 Como la API <b>*ODA-DNA*</b> está diseñada para recibir un JSON en formato POST, la sugerencia es primero instalar “Postman” en la computadora cliente y así poder acceder cumpliendo con los 2 requisitos. 
 Postman es una aplicación gratuita que puede descargarse desde la siguiente liga:
 https://www.getpostman.com/downloads/
 Una vez descargada, instalada y funcionando, deberán llevarse a cabo los siguientes 5 puntos para poder ver el resultado de nuestra API-REST <b>*ODA-DNA*</b> tal y como se muestra en el punto 6 de la siguiente captura de pantalla:
</p>
<img src="https://i.postimg.cc/0y4WgR8K/osain-dna.jpg" alt="ScreenShot" style="width:auto;"/>

<p>
 La URL para consumir el servicio de <b>*ODA-DNA*</b> es la siguiente:<br/>
 http://odadna.sd3g83xm2e.us-east-2.elasticbeanstalk.com/mutation
</p>
<p align="right">-- Osain Dabián -- 12/MAY/2019 --<p>
