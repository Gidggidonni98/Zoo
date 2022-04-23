const url = "http://localhost:8080/api/zoo";

const registerZoo = () => {
    let nombre = document.getElementById('nombre').value;
    let tamanyo = document.getElementById('tamanyo').value;
    let presupuesto = document.getElementById('presupuesto').value;
    let ciudad_id = document.getElementById('ciudad').value;

    console.log(nombre, tamanyo, presupuesto, ciudad)

    let zoo = {
        "nombre": nombre,
        "tamanyo": tamanyo,
        "presupuesto": presupuesto,
        "ciudad_id": {
            "id": ciudad_id
        }
    }

    $.ajax({
        type: 'POST',
        headers: { "Content-Type": "application/json" },
        url: url + "/",
        data: JSON.stringify(zoo)
    }).done(res => {
            console.log(res)
    });
};
