const bgpos = document.getElementById("ejemplo_bgpos")
const bgpos_interactivo = document.getElementById("bgpos_interactivo")
const bgpos_enviar = document.getElementById("bgpos_submit")

bgpos_enviar.addEventListener("click", ()=>{
    let lado1 = bgpos_interactivo.children[0].value
    let dist1 = bgpos_interactivo.children[1].value
    let ud1 = bgpos_interactivo.children[2].value

    let lado2 = bgpos_interactivo.children[3].value
    let dist2 = bgpos_interactivo.children[4].value
    let ud2 = bgpos_interactivo.children[5].value

    let valor = `${lado1} ${dist1}${ud1} ${lado2} ${dist2}${ud2}`

    //console.log(valor)

    bgpos.style.backgroundPosition = valor
})

const bgrep = document.getElementById("ejemplo_bgrep")
const bgrep_interactivo = document.getElementById("bgrep_interactivo")
const bgrep_enviar = document.getElementById("bgrep_submit")

bgrep_enviar.addEventListener("click", ()=>{
    bgrep.style.backgroundRepeat = `${bgrep_interactivo.children[0].value} ${bgrep_interactivo.children[1].value }`
})

const bcolor = document.getElementById("color_borde")
const bcolor_elemento = document.getElementById("ejemplo_color_borde")
const bcolor_enviar = document.getElementById("enviar_color_borde")

bcolor_enviar.addEventListener("click", ()=>{
    bcolor_elemento.style.borderColor = "#"+bcolor.value.toUpperCase()
})

const ccolor = document.getElementById("color_contorno")
const ccolor_ejemplo = document.getElementById("ejemplo_contorno")
const ccolor_enviar = document.getElementById("enviar_color_contorno")

ccolor_enviar.addEventListener("click", () =>{
    ccolor_ejemplo.style.outlineColor = "#"+ccolor.value.toUpperCase()
})

document.getElementById("bgsize_submit").addEventListener("click", () => {
    let x = document.getElementById("bgsize_value_x").value
    let y = document.getElementById("bgsize_value_y").value

    document.getElementById("ejemplo_bgsize").style.backgroundSize = `${x}px ${y}px`
})

document.getElementById("border_submit").addEventListener("click", () =>{
    let width = document.getElementById("border_value_width").value
    let style = document.getElementById("border_value_style").value
    let color = document.getElementById("border_value_color").value

    document.getElementById("ejemplo_borde").style.border = `${width}px ${style} #${color}`
})

document.getElementById("border-width_submit").addEventListener("click", () => {
    let width = document.getElementById("border-width_value").value
    document.getElementById("ejemplo_border_width").style.borderWidth = width+"px"
})

document.getElementById("border-style_submit").addEventListener("click", () => {
    let style = document.getElementById("border-style_value").value
    document.getElementById("ejemplo_border_style").style.borderStyle = style
})

const $ =  function(query){
    return document.querySelector(query)
}

$("#enviar_border_radius").addEventListener("click", () =>{
    let radio = $("#border-radius-value").value
    $("#ejemplo_border_radius").style.borderRadius = radio+"px"
})

$("#box_shadow_btn").addEventListener("click", () =>{
    let x = $("#box_shadow_x").value
    let y = $("#box_shadow_y").value
    let bx = $("#box_shadow_bx").value
    let by = $("#box_shadow_by").value
    let color = $("#box_shadow_color").value

    $("#ejemplo_box_shadow").style.boxShadow = `${x}px ${y}px ${bx}px ${by}px #${color}`
})