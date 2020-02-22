<h1>ENDPOINTS   :satellite: </h1>
<h4>Todos los metodos POST y PUT necesitan body en Json. En el caso de los 
POST no hace falta especificar el id en el body. Te dejo en cada seccion
como serian los body correspondientes</h4>
<hr>
<h3> Producto :basketball: </h3>
    
    {
        "id" : "1",   
        "codigo": "Kakaroto-00",
        "nombre": "Dragon Ball Z Kakaroto",
        "descripcion": "maso game",
        "precio": 1999.99
    }


<p>/api/productos <b>GET :arrow_down: </b> </p>

<p>/api/productos/{id} <b>GET :arrow_down: </b></p>

<p>/api/productos/search?query={loquesea} <b>GET :arrow_down: </b></p>

<p>/api/productos <b>POST :arrow_up_small: </b></p>

<p>/api/productos <b>PUT :id:</b></p>

<p>/api/productos/{id} <b>DELETE :x: </b></p>

<hr>
<h3> Cliente :bust_in_silhouette: </h3>

    {
        "id" : 1,
        "nombre": "Luis Iguerri",
        "cuit": "22376262",
        "direccion": "UTN 388",
        "condicionIva": "RESPONSABLE_INSCRIPTO"
    }

<p>/api/clientes <b>GET :arrow_down: </b> </p>

<p>/api/clientes/{id} <b>GET :arrow_down: </b></p>

<p>/api/clientes/search?query={loquesea} <b>GET :arrow_down: </b></p>

<p>/api/clientes <b>POST :arrow_up_small: </b></p>

<p>/api/clientes <b>PUT :id:</b></p>

<p>/api/clientes/{id} <b>DELETE :x: </b></p>

<hr>
<h3> Empresa :department_store: </h3>

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

<p>/api/empresa <b>GET :arrow_down: </b> </p>

<p>/api/empresa/{id} <b>GET :arrow_down: </b></p>

<p>/api/empresa <b>POST :arrow_up_small: </b></p>

<p>/api/empresa <b>PUT :id:</b></p>

<p>/api/empresa/{id} <b>DELETE :x: </b></p>

<hr>
<h3> Factura :clipboard: </h3>
<h4> lo que tenes que enviar </h4>

    {
        "encabezado" : {
            "cliente" : {
                "id" : 3
            }
        },

        "items" : [
            {
                "producto" : {
                    "id" : 3
                },
                "cantidad" : 4
            },
            {
                "producto" : {
                    "id" : 4
                },
                "cantidad" : 12
            },
            {
                "producto" : {
                    "id" : 2
                },
                "cantidad" : 6
            },
            {
                "producto" : {
                    "id" : 1
                },
                "cantidad" : 1
            }

            ],
            "pie" : {
                "observaciones" : "La compra del mes"

            }
    }



<h4> lo que te contesta </h4>

    {
        "encabezado": {
            "id": 24,
            "fecha": "2020-02-21T03:00:00.000+0000",
            "letra": "B",
            "cliente": {
                "id": 3,
                "nombre": "Luna Facunditaaaa",
                "cuit": "398376262",
                "direccion": "Cayetano Silva",
                "condicionIva": "CONSUMIDOR_FINAL"
            }
        },
        "items": [
            {
                "id": 17,
                "producto": {
                    "id": 1,
                    "codigo": "0093",
                    "nombre": "Fernet",
                    "descripcion": "Bebida alcoholica",
                    "precio": 240.5
                },
                "cantidad": 1,
                "subTotal": 240.5
            },
            {
                "id": 16,
                "producto": {
                    "id": 2,
                    "codigo": "0049",
                    "nombre": "Coca cola",
                    "descripcion": "Bebida sin Alcohol",
                    "precio": 120
                },
                "cantidad": 6,
                "subTotal": 720
            },
            {
                "id": 14,
                "producto": {
                    "id": 3,
                    "codigo": "10-SMOKE-2",
                    "nombre": "Vaper SMOKE modulo aleman pro",
                    "descripcion": "Vaper germanico",
                    "precio": 200
                },
                "cantidad": 4,
                "subTotal": 800
            },
            {
                "id": 15,
                "producto": {
                    "id": 4,
                    "codigo": "01-SMOKE-23939012",
                    "nombre": "E-Liquid germanico",
                    "descripcion": "Best liquid ever",
                    "precio": 16.5
                },
                "cantidad": 12,
                "subTotal": 198
            }
        ],
        "pie": {
            "pie_id": 24,
            "precioTotal": 1958,
            "observaciones": "La compra del mes",
            "id": 24
        }
    }

<p>/api/facturas/{id} <b> GET :arrow_down: </b> </p>

<p>/api/facturas/cliente/{idcliente} <b> GET :arrow_down: </b> </p>

<p>/api/facturas <b> POST :arrow_up_small: </b> </p>
