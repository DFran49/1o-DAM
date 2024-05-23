function inicio() {
    document.getElementById('iniMovil').style.display = 'flex';
    document.getElementById('buscMovil').style.display = 'none';
    document.getElementById('msgMovil').style.display = 'none';
    document.getElementById('chatMovil').style.display = 'none';
    document.getElementById('perfilMovil').style.display = 'none';
    document.getElementById('ajustesMovil').style.display = 'none';
}

function buscar() {
    document.getElementById('iniMovil').style.display = 'none';
    document.getElementById('buscMovil').style.display = 'flex';
    document.getElementById('msgMovil').style.display = 'none';
    document.getElementById('chatMovil').style.display = 'none';
    document.getElementById('perfilMovil').style.display = 'none';
    document.getElementById('ajustesMovil').style.display = 'none';
}

function mensajes() {
    document.getElementById('iniMovil').style.display = 'none';
    document.getElementById('buscMovil').style.display = 'none';
    document.getElementById('msgMovil').style.display = 'flex';
    document.getElementById('chatMovil').style.display = 'none';
    document.getElementById('perfilMovil').style.display = 'none';
    document.getElementById('ajustesMovil').style.display = 'none';
}

function chat() {
    document.getElementById('iniMovil').style.display = 'none';
    document.getElementById('buscMovil').style.display = 'none';
    document.getElementById('msgMovil').style.display = 'none';
    document.getElementById('chatMovil').style.display = 'flex';
    document.getElementById('perfilMovil').style.display = 'none';
    document.getElementById('ajustesMovil').style.display = 'none';
}

function perfil() {
    document.getElementById('iniMovil').style.display = 'none';
    document.getElementById('buscMovil').style.display = 'none';
    document.getElementById('msgMovil').style.display = 'none';
    document.getElementById('chatMovil').style.display = 'none';
    document.getElementById('perfilMovil').style.display = 'flex';
    document.getElementById('ajustesMovil').style.display = 'none';
}

function ajustes() {
    document.getElementById('iniMovil').style.display = 'none';
    document.getElementById('buscMovil').style.display = 'none';
    document.getElementById('msgMovil').style.display = 'none';
    document.getElementById('chatMovil').style.display = 'none';
    document.getElementById('perfilMovil').style.display = 'none';
    document.getElementById('ajustesMovil').style.display = 'flex';
}

function comentarios() {
    if (document.getElementById('comentariosMovil').style.display == 'none') {
        document.getElementById('comentariosMovil').style.display = 'none';
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

function findUsers(event) {
    if (event.keyCode == 13) {
        alert('enter')
    } else {
        alert(event.keyCode);
    }
    
}

function saludo() {
    alert();
}
