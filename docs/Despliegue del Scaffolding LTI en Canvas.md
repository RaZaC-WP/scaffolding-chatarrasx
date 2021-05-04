# Despliegue del Scaffolding LTI en Canvas

Requisitos:
- Java jdk 8
- Maven
- Git
- IDE
- Chocolatey
- Mkcert

 ### Paso 1: Java jdk
Descargar Java jdk para nuestro sistema operativo.
    [Link de descarga](https://www.oracle.com/es/java/technologies/javase/javase-jdk8-downloads.html)

Ejecutamos el instalador de jdk
![Instalador jdk](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/01.PNG?raw=true)

Elegimos ruta de instalacion o dejamos la por defecto, le damos a siguiente y empezara el proceso de instalación. 
![Instalador jdk](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/02.PNG?raw=true)

Nos saldrá esta pantalla indicando que la instalación se ha completado correctamente.
![Instalador jdk](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/03.PNG?raw=true)


### Paso 2: Maven
Instalación de Maven para ello vamos a su web oficial [Link de descarga](https://maven.apache.org/download.cgi) y descargamos el archivo Binary zip archive
![Instalador Maven](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/04.PNG?raw=true)

Extraemos el archivo zip. Añadimos la ruta de nuestro directorio **bin** a la variable de entorno **Path**
![Instalador Maven](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/05.png?raw=true)
![Instalador Maven](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/06.png?raw=true)

Abrimos una consola del sistema escribiendo cmd en el buscador de Windows y escribimos `mvn -v` para comprobar que funciona, debería salir una pantalla como esta.
![Instalador Maven](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/07.PNG?raw=true)

### Paso 3: Conectarse a Canvas
Nos registramos como profesores. [Link de registro](https://canvas.instructure.com/register_from_website)

![Conectarse a Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/08.png?raw=true)
![Conectarse a Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/09.PNG?raw=true)

Iniciamos sesion en el siguiente enlace. [Link](https://canvas.instructure.com/login/canvas)



### Paso 4: Instalación Git
Descargamos del siguiente enlace Git.
[Link de descarga](https://git-scm.com/downloads) 

Ejecutamos el instalador de Git
![Instalador Git](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/10.PNG?raw=true)

Damos a next y vamos eligiendo las opciones dependiendo de nuestras preferencias.

A continuación creamos una nueva carpeta y damos click derecho y **Git Bash Here**  se nos abrirá una consola y escribimos `git clone urlDirectorio`

![Ejecutar Git](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/11.PNG?raw=true)
![Ejecutar Git](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/12.PNG?raw=true)

 Se nos creara una carpeta con nuestro proyecto del Scaffolding LTI.
 
### Paso 5: Instalación IDE
En este caso voy a instalar Eclipse pero funciona con cualquier otro IDE. 
[Link de descarga de Eclipse](https://www.eclipse.org/downloads/)

Ejecutamos le instalador y elegimos **Eclipse IDE for Enterprise Java and Web Developers**
![Instalar Eclipse](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/13.png?raw=true)

En la siguiente ventana elegimos la ruta de instalación y presionamos en install.


### Paso 6: Importar proyecto y arrancarlo

Ejecutamos Eclipse y le damos a **File** -> **Import**
![Importar proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/14.png?raw=true)

Dentro de la carpeta Maven seleccionamos **Existing Maven Projects**.
![Importar proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/15.png?raw=true)
Seleccionamos la ruta de nuestro proyecto y damos a finish. 
![Importar proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/16.PNG?raw=true)

Vamos a el menú de help y damos click en **Eclipse Marketplace...**
![Instalar SpringBoot](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/17.png?raw=true)

Buscamos Spring Tool 4 y le damos a install.
![Instalar SpringBoot](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/18.PNG?raw=true)

Le damos click derecho a nuestro proyecto **Run As** -> **Spring Boot App**.  
![Ejecutar proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/19.png?raw=true)

Si todo ha ido bien por consola nos saldrá un mensaje así: 
![Ejecutar proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/20.PNG?raw=true)


### Paso 7: Instalación Chocolatey y Mkcert

Para la instalación de Chocolatey damos a inicio y buscamos **powershell** damos click derecho y ejecutar como administrador.
![Instalacion Chocolatey](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/21.png?raw=true)

Ejecutamos `Get-ExecutionPolicy` si devuelve `Restricted` entonces ejecutamos `Set-ExecutionPolicy AllSigned` o `Set-ExecutionPolicy Bypass -Scope Process`. Volvemos a ejecutar `Get-ExecutionPolicy` para comprobar que ya no devuelve restricted.
![Instalacion Chocolatey](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/22.PNG?raw=true)

Ahora ejecutamos el siguiente comando en la misma consola: `Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))`

Si no vemos ningún  error escribimos choco para comprobar que ha salido bien. Ahora para instalar Mkcert ejecutamos el comando `choco install mkcert`

Para usar Mkcert vamos a la carpeta donde hemos clonado el repositorio y vamos a **\src\main\resources** damos Shift+click derecho en un espacio en blanco dentro de la carpeta y **abrir la ventana de Powershell aquí** ejecutamos el comando `mkcert -pkcs12 localhost`, nos devolverá  una pantalla como esta:  
![Instalacion Mkcert](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/23.PNG?raw=true)

Esto creara un certificado en la carpeta en la que hemos ejecutado la consola. La contraseña de la Key será "changeit" por defecto. 

Dentro de la misma carpeta de **resources** abrimos el archivo **application.properties** y cambiamos la línea de **server.port=8080** por **server.port=8443** y añadimos las líneas  
```
server.ssl.key-store=classpath:localhost.p12
server.ssl.key-store-type=PKCS12
server.ssl.key-store-password=changeit
```

Por tanto nuestro archivo quedara así:
![configuracion proyecto](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/24.PNG?raw=true)


### Paso 8: Configurar App en Canvas
Volver a la página de Canvas [Aquí](https://canvas.instructure.com/).
Vamos al Dashboard y le damos a **Start a New course**
![Configurar Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/25.png?raw=true)

Seguido vamos a ese curso a  **Settings** y le damos a **View App Configurations**
![Configurar Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/26.PNG?raw=true)

Le damos a el botón de **+APP** y se nos abrirá una ventana con la configuración de nuestro LTI.
En Configuration type elegimos **Paste XML**, en Title ponemos el titulo que le queramos dar a nuestra app dentro de Canvas. En Consumer Key y Shared Secret escribimos **canvas** y en XML Configuration: 
```
<?xml version="1.0" encoding="UTF-8"?>
<cartridge_basiclti_link xmlns="http://www.imsglobal.org/xsd/imslticc_v1p0"
                         xmlns:blti = "http://www.imsglobal.org/xsd/imsbasiclti_v1p0"
                         xmlns:lticm ="http://www.imsglobal.org/xsd/imslticm_v1p0"
                         xmlns:lticp ="http://www.imsglobal.org/xsd/imslticp_v1p0"
                         xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
                         xsi:schemaLocation = "http://www.imsglobal.org/xsd/imslticc_v1p0 http://www.imsglobal.org/xsd/lti/ltiv1p0/imslticc_v1p0.xsd
    http://www.imsglobal.org/xsd/imsbasiclti_v1p0 http://www.imsglobal.org/xsd/lti/ltiv1p0/imsbasiclti_v1p0.xsd
    http://www.imsglobal.org/xsd/imslticm_v1p0 http://www.imsglobal.org/xsd/lti/ltiv1p0/imslticm_v1p0.xsd
    http://www.imsglobal.org/xsd/imslticp_v1p0 http://www.imsglobal.org/xsd/lti/ltiv1p0/imslticp_v1p0.xsd">
    <blti:launch_url>https://localhost:8443/launch</blti:launch_url>
    <blti:title>Scaffold LTI</blti:title>
    <blti:description>Scaffold LTI</blti:description>
    <blti:extensions platform="canvas.instructure.com">
        <lticm:property name="privacy_level">public</lticm:property>
        <lticm:options name="course_navigation">
            <lticm:property name="enabled">true</lticm:property>
            <lticm:property name="default">disabled</lticm:property>
        </lticm:options>
    </blti:extensions>
</cartridge_basiclti_link>
```

Y nos quedaria así: 
![Configurar Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/27.PNG?raw=true)

Ahora vamos a Navigation y subimos nuestra aplicación a la parte de arriba y damos a save:
![Configurar Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/28.png?raw=true) 

Ahora en la barra de la derecha le damos click a la App que hemos creado y nos tendría que devolver una ventana así:
![Configurar Canvas](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/29a59d461d506368a4ba9c55a82a95cb4169e6ec/docs/Imagenes/29.PNG?raw=true) 


### Paso 9: Configurar App en Moodle

Nos logeamos en Moodle y entramos en nuestro curso. Damos click en "Add an activity or resource".
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/30.PNG?raw=true) 

Damos click en External Tool.
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/31.PNG?raw=true) 

Escribimos un nombre y damos click en el mas del campo preconfigured tool.
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/32.PNG?raw=true) 

Rellenamos los campos con nuestros datos asi y guardamos.
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/33.PNG?raw=true) 

Seleccionamos la preconfiguracion que acabamos de crear y damos click en "save and Display"
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/34.PNG?raw=true)

Si todo funciona bien tendremos esta pantalla.
![Configurar Moodle](https://github.com/IvanGoHeQ/Scaffold-LTI/blob/0cb58c9b9db349172dfa48ed73779ac44a75da70/docs/Imagenes/35.PNG?raw=true) 




