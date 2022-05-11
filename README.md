# TrabajoPractico2
Para poder cargar el archivo JSON con los ninjas correctamente, siga las siguientes instrucciones: 1 - Abra el archivo JSON "pruebaManejoJSON". 2 - Modifique exactamente los valores del archivo o cree un archivo nuevo con el mismo esquema. 3 - Guarde el archivo modificado o creado en cualquier parte de su ordenador con la extension JSON.

PD: "verticesConVecinos": [ [ 1, 7 ],

En esta seccion se representan los ninjas que pueden comunicarse entre si, por ejemplo en este caso, el Ninja 0 ( cada ninja inicial es representado por los [] ) puede comunicarse con el Ninja 1 y 7; y viceversa. Se pueden agregar mas de una conexion, por ejemplo: [ 1, 3, 5, 8 ],

PD2: "aristas": [ { "1": 4, "7": 8 },

En esta seccion se establece la posibilidad de interferencia sobre un Ninja con un enemigo, donde "1" es el Ninja al que puede ser el mensaje entregado y 4 es el riesgo de interferencia.

WARNING!!! RESPETAR EL ORDEN EN EL CUAL SE AGREGAN LOS NINJAS Y EL ORDEN QUE SE AGREGAN LOS NINJAS QUE SE PUEDE COMUNICAR JUNTO CON SU PROBABILIDAD DE INTERFERENCIA.
