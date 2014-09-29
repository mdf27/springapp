var exprNombre = /^[0-9\.]*$/;

$(document).ready(function () { //Verificamos que el documento este listo
    
     $("#botonLogin").click(function (){
        var nombre = $("#idUsuario").val();

        $("#errorNombreCaracter").fadeOut();  
        $("#errorNombreVacio").fadeOut();


        if(nombre === "Codigo de usuario" ) {
            $("#errorNombreCaracter").fadeOut();
            $("#errorNombreVacio").fadeIn("slow"); //Muestra mensaje de error
            return false; 
        }
        else if(!exprNombre.test(nombre)){
            $("#errorNombreVacio").fadeOut();
            $("#errorNombreCaracter").fadeIn("slow"); //Muestra mensaje de error
            return false;                             // con false sale de la secuencia
        }
    });//fin onClick
    
    
    //Ocultando Datos luego del primer envio si son correctos
    $("#idUsuario").keyup(function(){
        if( $(this).val() !== "" && exprNombre.test($(this).val())){
            $("#errorNombreCaracter, #errorNombreVacio").fadeOut();
            return false;
        }
    });
    
    
    
});//fin ready



