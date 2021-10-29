function trocar(elemento) {
    var tag=document.getElementById(elemento);
    tag.style.display = tag.style.display === 'block' ? 'none' : 'block';
}