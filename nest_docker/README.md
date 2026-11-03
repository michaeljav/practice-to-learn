hacer una api de nest
para ponerla a correr con docker. 

$ npm i -g @nestjs/cli
$ nest new project-name

cd api-docker
npm install
npm run start:dev

crear imagen docker
docker build -t mi-api .

docker build: construye una imagen.
-t mi-api: asigna el nombre mi-api a la imagen.
.: indica que Docker debe utilizar la carpeta actual como contexto de construcción.


docker run -d --name mi-api \
  --restart unless-stopped \
  -p 3000:3000 mi-api

  - -d: ejecuta el contenedor en segundo plano.
- --restart unless-stopped: configura Docker para reiniciar el contenedor si se detiene inesperadamente y cuando se reinicia Docker, salvo que lo hayas detenido manualmente.
- -p 3000:3000: publica el puerto 3000 del contenedor en el puerto 3000 del servidor.
Puedes cerrar tu terminal y la API continuará funcionando, mientras Docker y el servidor estén activos.