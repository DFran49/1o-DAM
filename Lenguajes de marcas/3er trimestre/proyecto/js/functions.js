function logIn() {
    let x = document.forms["formLogIn"]["username"].value;
    /*if (x == "") {
        alert("Name must be filled out");
        return false;
    } else {*/
        document.getElementById('logIn').style.display = 'none';
        document.getElementById('contenido').style.display = 'flex';
        document.getElementById('footerMovil').style.display = 'flex';
    /*}*/
}

function inicio() {
    document.getElementById('contenido').style.display = 'flex';
    document.getElementById('buscar').style.display = 'none';
    document.getElementById('mensajes').style.display = 'none';
    document.getElementById('chat').style.display = 'none';
    document.getElementById('perfil').style.display = 'none';
    document.getElementById('ajustes').style.display = 'none';
}

function buscar() {
    document.getElementById('contenido').style.display = 'none';
    document.getElementById('buscar').style.display = 'flex';
    document.getElementById('mensajes').style.display = 'none';
    document.getElementById('chat').style.display = 'none';
    document.getElementById('perfil').style.display = 'none';
    document.getElementById('ajustes').style.display = 'none';
}

function mensajes() {
    document.getElementById('contenido').style.display = 'none';
    document.getElementById('buscar').style.display = 'none';
    document.getElementById('mensajes').style.display = 'flex';
    document.getElementById('chat').style.display = 'none';
    document.getElementById('perfil').style.display = 'none';
    document.getElementById('ajustes').style.display = 'none';
}

function chat() {
    document.getElementById('mensajes').style.display = 'none';
    document.getElementById('chat').style.display = 'flex';
}

function perfil() {
    document.getElementById('contenido').style.display = 'none';
    document.getElementById('buscar').style.display = 'none';
    document.getElementById('mensajes').style.display = 'none';
    document.getElementById('chat').style.display = 'none';
    document.getElementById('perfil').style.display = 'flex';
    document.getElementById('ajustes').style.display = 'none';
}

function ajustes() {
    document.getElementById('contenido').style.display = 'none';
    document.getElementById('buscar').style.display = 'none';
    document.getElementById('mensajes').style.display = 'none';
    document.getElementById('chat').style.display = 'none';
    document.getElementById('perfil').style.display = 'none';
    document.getElementById('ajustes').style.display = 'flex';
}

function comentarios() {
    if (document.getElementById('comentariosMovil').style.display == 'none') {
        document.getElementById('comentariosMovil').style.display = 'flex';
        alert('b');
    }
    
    alert(document.getElementById('comentariosMovil').textContent);
}

function cambiarMeGusta() {
    if (document.getElementById('cora-no-visto').style.display == 'none') {
        document.getElementById('cora-no-visto').style.display = 'inline';
        document.getElementById('cora-visto').style.display = 'none';
    } else {
        document.getElementById('cora-no-visto').style.display = 'none';
        document.getElementById('cora-visto').style.display = 'inline';
    }   
}

function cambiarGuardado() {
    if (document.getElementById('marca-no-visto').style.display == 'none') {
        document.getElementById('marca-no-visto').style.display = 'inline';
        document.getElementById('marca-visto').style.display = 'none';
    } else {
        document.getElementById('marca-no-visto').style.display = 'none';
        document.getElementById('marca-visto').style.display = 'inline';
    }   
}

function busqueda(a,b) {
    console.log(a);
    console.log(b);
    var input, div, p, a, i;
    input = a;
    div = b;
    p = div.getElementsByTagName("p");
    for (i = 0; i < p.length; i++) {     
        a = p[i].textContent;
        if (a.indexOf(input) > -1) {
            p[i].style.display = "";
        } else {
            p[i].style.display = "none";
        }
    }
    
}

function buscarPerfiles(event) {
    if (event.keyCode == 13) {
        alert('enter')
    } else {
        var input, div;
        input =  document.forms["busquedaMovil"]["buscarPerfiles"].value;
        div = document.getElementById("listaUsers");
        busqueda(input, div);
    }
    alert('a');
}

function hola(event) {
    if (event.keyCode == 13) {
        alert('a');
    } else {
        var input, div;
        input =  document.forms["busquedaMovil"]["buscarPerfiles"].value;
        div = document.getElementById("listaUsers");
        busqueda()
    }
    alert(event.keyCode);
}

function volverMensajes() {
    document.getElementById('mensajes').style.display = 'flex';
    document.getElementById('chat').style.display = 'none';
}

function cambiarNombre() {
    document.getElementById('contenedorAjustes').style.display = 'none';
    document.getElementById('topAjustes').style.display = 'none';
    document.getElementById('cambiarNombre').style.display = 'flex';
}

function borrarPubli() {
    document.getElementById('contenedorAjustes').style.display = 'none';
    document.getElementById('topAjustes').style.display = 'none';
    document.getElementById('borrarPublicaciones').style.display = 'flex';
}

function borrarAmigos() {
    document.getElementById('contenedorAjustes').style.display = 'none';
    document.getElementById('topAjustes').style.display = 'none';
    document.getElementById('borrarAmigos').style.display = 'flex';
}

function borrarCuenta() {
    document.getElementById('contenedorAjustes').style.display = 'none';
    document.getElementById('topAjustes').style.display = 'none';
    document.getElementById('borrarCuenta').style.display = 'flex';
}

function logOut() {
    location.reload();
}

function volverAjustes() {
    document.getElementById('contenedorAjustes').style.display = 'flex';
    document.getElementById('topAjustes').style.display = 'flex';
    document.getElementById('cambiarNombre').style.display = 'none';
    document.getElementById('borrarPublicaciones').style.display = 'none';
    document.getElementById('borrarAmigos').style.display = 'none';
    document.getElementById('borrarCuenta').style.display = 'none';
    document.getElementById('logOutMovil').style.display = 'none';
}
