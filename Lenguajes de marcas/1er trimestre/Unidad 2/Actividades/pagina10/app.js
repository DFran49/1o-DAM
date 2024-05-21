function MailCorto() {
    var Libro = document.getElementById("FormMailCorto").LibroFav.value;
    var Juego = document.getElementById("FormMailCorto").JuegoFav.value;
    var CadenaCorto = "Libro: "+Libro+"%0D%0A Juego: "+Juego;
    window.location.href="mailto:fcremarb@g.educaand.es?subject=Envio de Cuestionario&body="+CadenaCorto;
}

function AlertDatos() {
    var JugadaAjedrez = document.getElementById("FormAlert").AjedrezFav.value;
    var JugadaDamas = document.getElementById("FormAlert").DamasFav.value;
    alert(JugadaAjedrez+"\n"+JugadaDamas);
}

function EnableForma() {
    document.getElementById("FormaDirect1").disabled = false;
    document.getElementById("FormaDirect2").disabled = false;
    document.getElementById("FormaDirect3").disabled = false;
    document.getElementById("FormaDirect4").disabled = false;
    document.getElementById("FormaDirect5").disabled = false;
}

function DisableForma() {
    document.getElementById("FormaDirect1").disabled = true;
    document.getElementById("FormaDirect2").disabled = true;
    document.getElementById("FormaDirect3").disabled = true;
    document.getElementById("FormaDirect4").disabled = true;
    document.getElementById("FormaDirect5").disabled = true;
    document.getElementById("LOGSEInput").disabled = true;
    document.getElementById("COUInput").disabled = true;
    document.getElementById("OtrosInput").disabled = true;

    document.getElementById("FormaDirect1").value = "";
    document.getElementById("FormaDirect2").value = "";
    document.getElementById("FormaDirect3").value = "";
    document.getElementById("FormaDirect4").value = "";
    document.getElementById("FormaDirect5").value = "";
    document.getElementById("LOGSEInput").value = "";
    document.getElementById("COUInput").value = "";
    document.getElementById("OtrosInput").value = "";

    document.querySelectorAll('[name=FormaDirect]').forEach((x) => x.checked = false);
}

function DeactivateInForma() {
    document.getElementById("LOGSEInput").disabled = true;
    document.getElementById("COUInput").disabled = true;
    document.getElementById("OtrosInput").disabled = true;

    document.getElementById("FormaDirect1").value = "";
    document.getElementById("FormaDirect2").value = "";
    document.getElementById("FormaDirect3").value = "";
    document.getElementById("FormaDirect4").value = "";
    document.getElementById("FormaDirect5").value = "";
    document.getElementById("LOGSEInput").value = "";
    document.getElementById("COUInput").value = "";
    document.getElementById("OtrosInput").value = "";
}

function BachLOGSE() {
    document.getElementById("LOGSEInput").disabled = false;
    document.getElementById("COUInput").disabled = true;
    document.getElementById("OtrosInput").disabled = true;
}

function CouOpt() {
    document.getElementById("LOGSEInput").disabled = true;
    document.getElementById("COUInput").disabled = false;
    document.getElementById("OtrosInput").disabled = true;
}

function Otro() {
    document.getElementById("LOGSEInput").disabled = true;
    document.getElementById("COUInput").disabled = true;
    document.getElementById("OtrosInput").disabled = false;
}

function MailLargo() {
    var Nombre = document.getElementById("FormMail").Nombre.value;
    var Apellidos = document.getElementById("FormMail").Apellidos.value;
    var DNI = document.getElementById("FormMail").DNI.value;
    var LocNac = document.getElementById("FormMail").Localidad.value;
    var Provincia = document.getElementById("FormMail").Provincia.value;
    var FechaNac = document.getElementById("FormMail").FechaNac.value;
    var Direccion = document.getElementById("FormMail").Direccion.value;
    var CP = document.getElementById("FormMail").CP.value;

    var FormaAcces = document.getElementById("FormMail").Forma.value;
    var FormaDirect = document.getElementById("FormMail").FormaDirect.value;
    var Input1 = document.getElementById("FormMail").LOGSE.value;
    var Input2 = document.getElementById("FormMail").COU.value;
    var Input3 = document.getElementById("FormMail").Otros.value;

    var FotoDNI = document.getElementById("FormMail").FotoDNI.checked;
    var CertAcadem = document.getElementById("FormMail").CertAcadem.checked;
    var OtrosDocs = document.getElementById("FormMail").OtroDoc.checked;
    var DocsAñadidos = document.getElementById("FormMail").OtroDocIn.checked;

    if (FotoDNI == true) {
        FotoDNI = "Si";
    } else {
        FotoDNI = "No";
    }
    if (CertAcadem == true) {
        CertAcadem = "Si";
    } else {
        CertAcadem = "No";
    }
    if (OtrosDocs == true) {
        OtrosDocs = "Si";
    } else {
        OtrosDocs = "No";
    }
    if (DocsAñadidos == true) {
        DocsAñadidos = "Si";
    } else {
        DocsAñadidos = "No";
    }

    var CadenaLargo = "Nombre: "+Nombre+"%0D%0A Apellidos: "+Apellidos+"%0D%0A DNI: "+DNI+"%0D%0A Localidad de nacimiento: "+LocNac
    +"%0D%0A Provincia: "+Provincia+"%0D%0A Fecha de nacimiento: "+FechaNac+"%0D%0A Dirección: "+Direccion
    +"%0D%0A Código postal: "+CP+"%0D%0A Forma de acceso: "+FormaAcces+" "+FormaDirect+" "+Input1+Input2+Input3+"%0D%0A Fotocopia del DNI: "+FotoDNI
    +"%0D%0A Certificado académico: "+CertAcadem+"%0D%0A Otros documentos: "+OtrosDocs+"%0D%0A Documentos añadidos: "+DocsAñadidos;
    window.location.href="mailto:fcremarb@g.educaand.es?subject=Envio de Cuestionario&body="+CadenaLargo;
}