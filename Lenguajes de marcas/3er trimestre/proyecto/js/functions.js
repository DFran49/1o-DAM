function logIn() {
    let x = document.forms["formLogIn"]["username"].value;
    let y = document.forms["formLogIn"]["passwd"].value;
    /*if (x == "") {
        alert("El campo 'Nombre de usuario' no puede estar vacío");
        return false;
    } else {
        if (y == "") {
            alert("Debe introducir una contraseña");
        } else {*/
            document.getElementById('logIn').style.display = 'none';
            document.getElementById('signIn').style.display = 'none';
            document.getElementById('contenido').style.display = 'flex';
            document.getElementById('footerMovil').style.display = 'flex';
            document.getElementById('comentariosMovil').style.display = 'none';
        /*}
    }*/
}

function signIn() {
    let x = document.forms["formSignIn"]["passwd"].value;    
    let y = document.forms["formSignIn"]["confPasswd"].value;
    let z = document.forms["formSignIn"]["username"].value;
    if (z == "") {
        alert("El campo 'Nombre de usuario' no puede estar vacío");
    } else {
        if (x == "" || y == "") {
            alert("Debe introducir una contraseña");
        } else {
            if (x != y) {
                alert('Las contraseñas deben de ser iguales');
            } else {
                document.getElementById('signIn').style.display = 'none';
                document.getElementById('contenido').style.display = 'flex';
                document.getElementById('footerMovil').style.display = 'flex';
                document.getElementById('comentariosMovil').style.display = 'none';
            }
        }
    }    
}

function cambiarLog() {
    if (document.getElementById('logIn').style.display = 'flex') {
        document.getElementById('logIn').style.display = 'none';
        document.getElementById('signIn').style.display = 'flex';
    }
}

function cambiarSign() {
    if (document.getElementById('signIn').style.display = 'flex') {
        document.getElementById('logIn').style.display = 'flex';
        document.getElementById('signIn').style.display = 'none';
    }
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
    } else {
        document.getElementById('comentariosMovil').style.display = 'none';
    }
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

function busqueda(c,b) {
    var input, div, p, a, i;
    input = c;
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

function buscarPC(event) {
    if (event.keyCode == 13) {
        alert('a');
    } else {
        var input, div;
        input =  document.forms["search"]["myBusqueda"].value;
        /* falta cambiar esto */
        div = document.getElementById("listaUsers");
        busqueda(input, div);
    }
}

function buscarusers(event) {
    if (event.keyCode == 13) {
        alert('a');
    } else {
        var input, div;
        input =  document.forms["busquedaMovil"]["buscarPerfiles"].value;
        div = document.getElementById("listaUsers");
        busqueda(input, div);
    }
}

function buscarchats(event) {
    if (event.keyCode == 13) {
        alert('a');
    } else {
        var input, div;
        input =  document.forms["abrirChatMovil"]["buscarChats"].value;
        div = document.getElementById("bandejaEntrada");
        busqueda(input, div);
    }
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

function confCambiarNombre() {
    var x, y;
    x = document.forms["cambiarUsername"]["passwd"].value;
    y = document.forms["cambiarUsername"]["newUsername"].value;
    if (x == "") {
        alert('Debes introducir tu contraseña para confirmar el cambio');
    } else {
        if (y == "") {
            alert('Debes introducir un nombre de usuario para hacer un cambio');
        } else {
            alert('Usuario cambiado');
        }
    }
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
