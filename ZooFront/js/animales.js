const urlA = "http://localhost:8080/api/animal";
const urlAnimal = "http://localhost:8080/api/animal";

//-----------------------REGISTRAR ANIMALES----------------------------------//

const registerAnimal = () => {
  let claveAnimal = document.getElementById("claveAnimal").value;
  let birthday = document.getElementById("birthday").value;
  let zoo = document.getElementById('zoo').value
  let especie = document.getElementById('esp').value
  let genero = document.getElementById('gen').value

  let animal = {
    "claveAnimal": claveAnimal,
    "fechaNacimiento": birthday,
    "zoologico": {
      "id": zoo
    },
    "genero": {
      "id": genero
    },
    "especie": {
      "id": especie
    },
  };

  $.ajax({
    type: "POST",
    headers: { "Content-Type": "application/json" },
    url: urlA + "/",
    data: JSON.stringify(animal),
  }).done((res) => {
    document.getElementById('claveAnimalUpdate').value = "";
    document.getElementById('birthdayUpdate').value = "";
    findAnimales()
    
  });
};


const findAnimales = async () => {
  await $.ajax({
    method: 'GET',
    headers: { "Accept": "application/json" },
    url: urlAnimal + '/'
  }).done(function (res) {
    content = "";
    res = res.data;
    for (let i = 0; i < res.length; i++) {
      content += `
          <tr class="text-center">
              <td>${res[i].id}</td>
              <td>${res[i].claveAnimal}</td>
              <td>${res[i].fechaNacimiento} </td>
              <td>${res[i].genero.descripcion}</td>
              <td>${res[i].especie.nombreComun}</td>
              <td>
                  <button class='btn btn-warning' data-toggle='modal' onclick='getInfoUpdateAnimal(${res[i].id})' data-target='#modificarAnimal'><i class="fa-solid fa-pen-to-square"></i></button>
              </td>
          </tr>
              `;
    };
    $("#table3 > tbody").html(content)
  });
};
findAnimales();

const getByIdF = async id => {
  return await $.ajax({
    type: 'GET',
    url: urlAnimal + '/' + id
  }).done(res => {
    console.log(res);
  });
};

const getInfoUpdateAnimal = async id => {
  let animal = await getByIdF(id);

  await $.ajax({
    method: 'GET',
    url: url + '/'
  }).done(res => {
    let spinner1 = $("#u_spinnerEspeciesA");
    let listEspecies = res.data;
    spinner1.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
    spinner1.append(
      "<option selected>Selecciona...</option>"
    );

    if (listEspecies.length > 0) {
      for (let i = 0; i < listEspecies.length; i++) {
        spinner1.append(
          "<option value='" + listEspecies[i].id + "'>" + listEspecies[i].familia + "</option>"
        );
      };
    };
  })

  await $.ajax({
    method: 'GET',
    url: 'http://localhost:8080/api/zoo/'
  }).done(res => {
    let spinner3 = $("#zooSpinner");
    let lisZoos = res.data;
    spinner3.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
    spinner3.append(
      "<option selected>Selecciona...</option>"
    );

    if (lisZoos.length > 0) {
      for (let i = 0; i < lisZoos.length; i++) {
        spinner3.append(
          "<option value='" + lisZoos[i].id + "'>" + lisZoos[i].nombre + "</option>"
        );
      };
    };
  })

  document.getElementById('zooSpinner').value = animal.data.zoologico.id;
  document.getElementById('u_spinnerEspeciesA').value = animal.data.especie.id;
  document.getElementById('generoSpinner').value = animal.data.genero.id;
  document.getElementById('idAnimalUpdate').value = animal.data.id;
  document.getElementById('claveAnimalUpdate').value = animal.data.claveAnimal;
  document.getElementById('birthdayUpdate').value = animal.data.fechaNacimiento;
};



// //Actualizar animal

const updateAnimal = async () => {
  let id = document.getElementById('idAnimalUpdate').value;
  let claveAnimal = document.getElementById('claveAnimalUpdate').value;
  let fechaNacimiento = document.getElementById('birthdayUpdate').value;
  let especie = document.getElementById('u_spinnerEspeciesA').value;
  let genero = document.getElementById('generoSpinner').value;
  let zoologico = document.getElementById('zooSpinner').value;

  let animal = {
    id: id,
    claveAnimal: claveAnimal,
    fechaNacimiento: fechaNacimiento,
    especie: {
      id: especie
    },
    genero: {
      id: genero
    },
    zoologico: {
      id: zoologico
    }
  }

  $.ajax({
    type: 'PUT',
    url: urlA + '/' + id,
    data: JSON.stringify(animal)
  }).done(function (res) {
    console.log()
  });
};