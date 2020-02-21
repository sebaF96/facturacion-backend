<h1>ENDPOINTS</h1>
<h4>Todos los metodos POST y PUT necesitan body en Json. En el caso de los 
POST no hace falta especificar el id en el body. Te dejo en cada seccion
como serian los body correspondientes</h4>
<hr>
<h3> Producto </h3>
    
    {
        "id" : "1"   
        "codigo": "Kakaroto-00",
        "nombre": "Dragon Ball Z Kakaroto",
        "descripcion": "maso game",
        "precio": 1999.99
    }


<p>/api/productos <b>GET</b> </p>

<p>/api/productos/{id} <b>GET</b></p>

<p>/api/productos/search?query={loquesea} <b>GET</b></p>

<p>/api/productos <b>POST</b></p>

<p>/api/productos <b>PUT</b></p>

<p>/api/productos/{id} <b>DELETE</b></p>

<hr>
<h3> Cliente </h3>

    {
        "id" : 1,
        "nombre": "Matias Ahumada",
        "cuit": "368376262",
        "direccion": "Peru 3839",
        "condicionIva": "RESPONSABLE_INSCRIPTO"
    }

<p>/api/clientes <b>GET</b> </p>

<p>/api/clientes/{id} <b>GET</b></p>

<p>/api/clientes/search?query={loquesea} <b>GET</b></p>

<p>/api/clientes <b>POST</b></p>

<p>/api/clientes <b>PUT</b></p>

<p>/api/clientes/{id} <b>DELETE</b></p>

<hr>
<h3> Empresa </h3>

    {
        "nombre" : "Madrigal Electr.",
        "direccion" : "Germany 420",
        "provincia" : "Frankfurt",
        "pais" : "ALemania",
        "cuit" : "9393927661",
        "codigo_postal" : "838",
        "ciudad" : "Mercedes Benz Arena",
        "condicionIva" : "RESPONSABLE_INSCRIPTO
    }

<p>/api/empresa <b>GET</b> </p>

<p>/api/empresa/{id} <b>GET</b></p>

<p>/api/empresa <b>POST</b></p>

<p>/api/empresa <b>PUT</b></p>

<p>/api/empresa/{id} <b>DELETE</b></p>