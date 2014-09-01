<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <script>
            
            $(document).on('ready', function(){  
                $('#prueba').text('Hola mundito');
            });
            
        </script>
    
    </head>
   
    <body>
        <div id="prueba"></div>
    </body>

</html>
