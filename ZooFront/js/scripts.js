console.log('first')

const urlGetCountries = 'http://localhost:8080/api/pais/'

const obtenerPaises = async() => {
    await $.ajax({
        method: 'GET',
        url: urlGetCountries
    }).done(res => {
        let spinner = $('#inputState');
        let listCountries = res.data;

        spinner.append(
            "<option>Selecciona...</option>"
        );

        if(listCountries.length > 0){
            for(let i = 0; i < listCountries.length; i++){
                spinner.append(
                    "<option>"+ listCountries[i].descripcion +"</option>"
                );
            };
        };
    })
};