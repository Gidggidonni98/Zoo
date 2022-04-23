
const urlEspecies = "http://localhost:8080/api/especie";

//-----------------------REGISTRAR ESPECIE----------------------------------//

const registerEspecie = () => {
  let familia = document.getElementById("familia").value;
  let nombre_cientifico = document.getElementById("nombre_cientifico").value;
  let nombre_comun = document.getElementById("nombre_comun").value;
  // let peligro_extincion = document.getElementById('peligro_extincion');
  // let pais_id = document.getElementById('pais_id');

  let especie = {
    "nombreComun": nombre_comun,
    "nombreCientifico": nombre_cientifico,
    "familia": familia,
    "peligroExtincion": "si",
    "pais": {
      "id": 1,
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
  });
};


const findEspecies = async() => {
    await $.ajax({
        method: 'GET',
        headers: { "Accept": "application/json" },
        url: urlEspecies + '/'
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
                    <button class='btn btn-warning' data-toggle='modal' onclick='getInfoEspecies(${res[i].id})' data-target='#actualizarEspecies'><i class="fa-solid fa-pen-to-square"></i></button>
                </td>
            </tr>
                `;
        };
        $("#table2 > tbody").html(content)
    });
};

const getByIdE = async id => {
    return await $.ajax({
        type: 'GET',
        url: urlEspecies + '/' + id
    }).done(res => {
       
    });
};

//Obtener la información del arreglo

const getInfoEspecies = async id => {
    let especie = await getByIdE(id);
    console.log(especie)
    document.getElementById('idEspecieUpdate').value = especie.data.id;
    document.getElementById('familiaU').value = especie.data.familia;
    document.getElementById('nombre_cientificoU').value = especie.data.nombreCientifico;
    document.getElementById('nombre_comunU').value = especie.data.nombreComun;
    document.getElementById('peligro_extincionU').value = especie.data.peligroExtincion;
    
}

const getInfoUpdateAnimal = async id => {
  let animal = await getByIdA(id);

  document.getElementById('idEspecieU').value = animal.data.id;
  document.getElementById('nombre_comunU').value = animal.data.nombreComun;
  document.getElementById('nombre_cientificoU').value = animal.data.nombreCientifico;
  document.getElementById('familiaU').value = animal.data.familia;
  document.getElementById('paisesUpdate').value = animal.data.pais.id;
};

// //Actualizar animal

const updateAnimal = async() => {
  let id =  document.getElementById('idEspecieU').value;
  let nombreComun =  document.getElementById('nombre_comunU').value ;
  let nombreCientifico = document.getElementById('nombre_cientificoU').value;
  let familia = document.getElementById('familiaU').value;
  let pais = document.getElementById('paisUpdate').value;

  let especieUpdate = {
    "nombreComun": nombreComun,
    "nombreCientifico": nombreCientifico,
    "familia": familia,
    "peligroExtincion": "si",
    "pais": {
      "id": 1,
    },
  };
  

  $.ajax({
      type: 'PUT',
      url: urlEspecies + '/' + id,
      data: JSON.stringify(especieUpdate)
  }).done(function(res) {
      findEspecies();
  });
};

findEspecies();
