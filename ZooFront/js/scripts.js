const urlGetCountries = 'http://localhost:8080/api/pais/'

const obtenerPaises = async() => {
    await $.ajax({
        method: 'GET',
        url: urlGetCountries
    }).done(res => {
        let spinner = $("#spinnerEspecies");
        let listCountries = res.data;
        spinner.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
        spinner.append(
            "<option selected>Selecciona...</option>"
        );

        if(listCountries.length > 0){
            for(let i = 0; i < listCountries.length; i++){
                spinner.append(
                    "<option value='"+ listCountries[i].id +"'>"+ listCountries[i].descripcion +"</option>"
                );
            };
        };
    })
};

const obtenerPaisesUpdate = async() => {
    
};