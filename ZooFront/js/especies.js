const url = "http://localhost:8080/api/especie";

//-----------------------REGISTRAR ESPECIE----------------------------------//

const registerEspecie = () => {
  let familia = document.getElementById("familia").value;
  let nombre_cientifico = document.getElementById("nombre_cientifico").value;
  let nombre_comun = document.getElementById("nombre_comun").value;
  let peligro_extincion = document.getElementById('peligro_extincion').value;
  let pais_id = document.getElementById('spinnerEspecies').value;

  let especie = {
    nombreComun: nombre_comun,
    nombreCientifico: nombre_cientifico,
    familia: familia,
    peligroExtincion: peligro_extincion,
    pais: {
      id: pais_id,
    },
  };

  $.ajax({
    type: "POST",
    headers: { "Content-Type": "application/json" },
    url: url + "/",
    data: JSON.stringify(especie),
  }).done((res) => {
    console.log(res);
    document.getElementById("familia").value = "";
    document.getElementById("nombre_cientifico").value = "";
    document.getElementById("nombre_comun").value = "";
    findEspecies();
  });
};

const getEspecie = async (id) => {
  return await $.ajax({
    method: 'GET',
    url: url + '/' + id
  }).done(res => res);
}

const getEspecieDetails = async (id) => {
  let especie = await getEspecie(id);

  await $.ajax({
    method: 'GET',
    url: urlGetCountries
  }).done(res => {
      let spinner = $("#u_spinnerEspecies");
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

  document.getElementById('id').value = especie.data.id
  document.getElementById('u_familia').value = especie.data.familia
  document.getElementById('u_c_name').value  = especie.data.nombreCientifico
  document.getElementById('u_com_name').value  = especie.data.nombreComun
  document.getElementById('u_direccion').value  = especie.data.peligroExtincion
  document.getElementById('u_spinnerEspecies').value = especie.data.pais.id
}

const updadteEspecie = async () => {
  let id = document.getElementById('id').value
  let familia = document.getElementById('u_familia').value
  let nombreCientifico = document.getElementById('u_c_name').value
  let nombreComun = document.getElementById('u_com_name').value
  let perligroExtincion = document.getElementById('u_direccion').value
  let pais_id = document.getElementById('u_spinnerEspecies').value

  let especie = {
    id: id,
    familia: familia,
    nombreCientifico: nombreCientifico,
    nombreComun: nombreComun,
    peligroExtincion: perligroExtincion,
    pais: {
      id: pais_id
    }
  }
  console.log(especie)

  await $.ajax({
    method: 'PUT',
    url: url + '/' + id,
    data: JSON.stringify(especie),
    headers: {
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin': '*'
    }
  }).done(res => console.log(res));
}

const findEspecies = async() => {
    await $.ajax({
        method: 'GET',
        headers: { "Accept": "application/json" },
        url: url + '/'
    }).done(function(res) {
        content = "";
        res = res.data;
        for (let i = 0; i < res.length; i++) {
            content += `
            <tr class="text-center">
                <td>${res[i].id}</td>
                <td>${res[i].familia}</td>
                <td>${res[i].nombreCientifico} </td>
                <td>${res[i].nombreComun}</td>
                <td>${res[i].peligroExtincion}</td>
                <td>
                    <button class='btn btn-warning' data-toggle='modal' onclick='getEspecieDetails(${res[i].id})' data-target='#modificarEspecie'><i class="fa-solid fa-pen-to-square"></i></button>
                    <button class='btn btn-warning' data-toggle='modal' data-target='#'><i class="fa-solid fa-pen-to-square"></i></button>
                </td>
            </tr>
                `;
        };
        $("#table2 > tbody").html(content)
    }); // onclick='getAnimalDetails(${res[i].id})'
};
findEspecies();
