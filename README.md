# btree-test

Para usar seguir instrucciones:

1. Abrir proyecto en IntelliJ y sincronizar las dependencias
2. Correr el proyecto
3. Para crear el arbol seguir la firma (donde el array es el orden ):

curl -X POST \
  http://localhost:8080/btree \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 45599d31-2e2d-430e-b3c1-3bcb4a037421' \
  -H 'cache-control: no-cache' \
  -d '[69,
   51,
   84,
   31,
   80,
   85,
   20,
   37,
   77,
   81]'
   
   donde el array son los elementos a insertar en el arbol.
   
   4. para consultar el LCA seguir la firma:
   
   curl -X GET \
  'http://localhost:8080/btree/lca?a=20&b=37' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: cd9256ce-ba9c-4e95-a69e-56f9e28066f7' \
  -H 'cache-control: no-cache'
  
  donde a y b son los nodos a analizar.
  
  


