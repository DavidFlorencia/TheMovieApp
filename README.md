# The Movie App

[TheMovie.apk](/TheMovie.apk)

Esta es una aplicación que implementa las librerias: https://github.com/DavidFlorencia/TheMovieLibraries. 
Esta implementación se realizo de forma local agregando los archivos .aar dentro del proyecto y declarandoles en gradle.

Esta desarrollada con la arquitectura Model View View Model basado en la [Guía de Arquitectura de Apps](https://developer.android.com/jetpack/guide?hl=es-419) de Google. 

Esta arquitectura se compone de tres capas: Vista - Modelo - Modelo de Vista. 
El fundamento principal de la arquitectura MVVM es que la comunicación es de un solo sentido. 
La Vista transmite las acciones del usuario al Modelo de Vista, pero el Modelo de Vista no debe responder de forma explícita (no debe instanciar la vista),
por ello se se usa un patrón de observador que es facilitado por las variables tipo ViewModel.
El Modelo de Vista solicita información del Modelo, el cual solo responde y no puede realizar ningún otro tipo de acción ni sobre el Modelo de Vista ni sobre la Vista.

En este proyecto se utilizan las siguientes librerías:

* Navigation Graph y SafeArgs: Para la navegación y transferencia de datos entre fragments.
* DataBinding: Para el enlace entre los elementos de diseño y el código ejecutable.
* ViewModel: Para la implementación del patrón observador.
* Retrofit: Para la comunicación con el API. Lo hace la librería **The Movie Api**.
* Moshi: Para el formateo de los datos obtenidos del API. Lo hace la librería **The Movie Api**.
* Hilt: Para la inyección de dependencias.
* Room: Para la persistencia de datos. Lo hace la librería **The Movie Database**.
* Mockito y JUnit: Para la implementación de pruebas unitarias e instrumentadas.
