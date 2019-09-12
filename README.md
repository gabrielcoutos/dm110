# trabalho-dm110 #

## CREATE NEW PRODUCT ##
- METHOD: POST
- URL: http://{localhost}/trabalho-web/api/product
- Content:{"codigo": 1 , "nome":"teste", "descricao":"descricao", "preco": 5, "categoria":"teste1"}


## GET ALL ##
- METHOD:GET
- URL: http://{localhost}/trabalho-web/api/products

## GET BY ID ##
- METHOD: GET
- URL:http://{localhost}/trabalho-web/api/product?codigo=1

## UPDATE ##
- METHOD:PUT
- URL:URL: http://{localhost}/trabalho-web/api/product
