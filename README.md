<h1>facturacion-backend</h1>

![madewith](https://img.shields.io/badge/made%20with-SpringBoot-green?logo=spring&style=for-the-badge)

<hr>
<h2> Endpoints </h3>
<hr>
<h3> Producto :high_heel: </h3>
    
    {
        "id" : "1",   
        "codigo": "Kakaroto-00",
        "nombre": "Dragon Ball Z Kakaroto",
        "descripcion": "manso game",
        "precio": 1999.99
    }


<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/productos </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg)   &nbsp; &nbsp; <b> /api/productos/{id} </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg)   &nbsp; &nbsp; <b> /api/productos/search?query={loquesea} </b>
</p>

<p>

![GET](https://img.shields.io/badge/method-POST-yellow.svg) &nbsp; &nbsp; <b> /api/productos </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-PUT-blueviolet.svg)   &nbsp; &nbsp; <b> /api/productos </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-PUT-blueviolet.svg)   &nbsp; &nbsp; <b> /api/productos/{id} </b> (Soft delete)

</p>

<hr>
<h3> Cliente :bust_in_silhouette: </h3>

    {
        "id" : 1,
        "nombre": "Marcelo Gallardo",
        "cuit": "22376262",
        "direccion": "UTN 388",
        "condicionIva": "RESPONSABLE_INSCRIPTO"
    }
    
<p>
    
![GET](https://img.shields.io/badge/method-GET-success.svg)   &nbsp; &nbsp; <b> /api/clientes </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-GET-success.svg)   &nbsp; &nbsp; <b> /api/clientes/{id} </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-GET-success.svg)   &nbsp; &nbsp; <b> /api/clientes/search?query={loquesea} </b>

</p>
<p>
    
![GET](https://img.shields.io/badge/method-POST-yellow.svg)   &nbsp; &nbsp; <b> /api/clientes </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-PUT-blueviolet.svg)   &nbsp; &nbsp; <b> /api/clientes </b>

</p>

<p>
    
![GET](https://img.shields.io/badge/method-PUT-blueviolet.svg)   &nbsp; &nbsp; <b> /api/clientes/{id} </b> (Soft delete)

</p>

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

<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/empresa </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/empresa/{id} </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-POST-yellow.svg) &nbsp; &nbsp; <b> /api/empresa </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-PUT-blueviolet.svg) &nbsp; &nbsp; <b> /api/empresa </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-DELETE-red.svg) &nbsp; &nbsp; <b> /api/empresa/{id} </b>

</p>

<hr>
<h3> Factura :clipboard: </h3>
<h4> formato necesario para post </h4>

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



<h4> formato de response </h4>

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
            "precioTotal": 1958,
            "observaciones": "La compra del mes",
            "id": 24
        }
    }


<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/facturas </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/facturas/{id} </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-GET-%3CCOLOR%3E.svg) &nbsp; &nbsp; <b> /api/facturas/cliente/{idcliente} </b>

</p>


<p>

![GET](https://img.shields.io/badge/method-POST-yellow.svg) &nbsp; &nbsp; <b> /api/facturas </b>

</p>

<p>

![GET](https://img.shields.io/badge/method-DELETE-red.svg) &nbsp; &nbsp; <b> /api/facturas/{id} </b>

</p>
