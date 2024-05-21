function Mail() {
    var Nombre = document.getElementById("FormMail").nombre.value;
    var Apellidos = document.getElementById("FormMail").apellidos.value;
    var Mail = document.getElementById("FormMail").email.value;
    var Mensaje = document.getElementById("FormMail").mensaje.value;

    var CadenaLargo = "Nombre: "+Nombre+"%0D%0A Apellidos: "+Apellidos+"%0D%0A Email: "+Mail+"%0D%0A Mensaje: "+Mensaje;
    window.location.href="mailto:fcremarb@g.educaand.es?subject=Envio de Cuestionario&body="+CadenaLargo;
}