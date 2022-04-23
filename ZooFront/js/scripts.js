console.log('first')

const urlGetCountries = 'http://localhost:8080/api/pais/'

async function obtenerPaises() {
    await $.ajax({
        method: 'GET',
        url: urlGetCountries
    }).done(res => {
        console.log(res)
    })
}