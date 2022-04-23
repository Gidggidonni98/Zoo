const url = "http://localhost:8080/api/zoo";

const getCities = async () => {
    await $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/api/ciudad/'
    }).done(res => {
        let citySpinner = $('#citySpinner');
        let cityList = res.data;

        citySpinner.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
        citySpinner.append(
            "<option selected>Selecciona...</option>"
        );

        if (cityList.length > 0) {
            for (let i = 0; i < cityList.length; i++) {
                citySpinner.append(
                    "<option value='" + cityList[i].id + "'>" + cityList[i].descripcion + "</option>"
                );
            };
        };
    });
}

getCities();

const registerZoo = () => {
    let nombre = document.getElementById('nombre').value;
    let tamanyo = document.getElementById('tamanyo').value;
    let presupuesto = document.getElementById('presupuesto').value;
    let ciudad_id = document.getElementById('citySpinner').value;

    console.log(nombre, tamanyo, presupuesto, ciudad_id)

    let zoo = {
        "nombre": nombre,
        "tamanyo": tamanyo,
        "presupuesto": presupuesto,
        "ciudad": {
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


const getByIdF = async id => {
    return await $.ajax({
        type: 'GET',
        url: urlAnimal + '/' + id
    }).done(res => {
        console.log(res);
    });
};

const getZoo = async id => {

    await $.ajax({
        method: 'GET',
        url: urlAnimal + "/"
    }).done(res => {
        let spinner = $("#zooSpinner");
        let dataAni = res.data;
        spinner.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
        spinner.append(
            "<option selected>Selecciona...</option>"
        );

        if(dataAni.length > 0){
            for(let i = 0; i < dataAni.length; i++){
                spinner.append(
                  "<option value='"+ dataAni[i].zoologico.id +"'>"+ dataAni[i].zoologico.descripcion +"</option>"
                  );
            };
        };

    })
};
