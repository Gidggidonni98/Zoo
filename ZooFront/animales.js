const urlA = "http://localhost:8080/api/animal";


//-----------------------REGISTRAR ANIMALES----------------------------------//

const registerAnimal = () => {
  let claveAnimal = document.getElementById("claveAnimal").value;
  let birthday = document.getElementById("birthday").value;



  let animal = {
    "claveAnimal": claveAnimal,
    "fechaNacimiento": birthday,
    "zoologico": {
        "id": 5
    },
    "genero": {
        "id": 1
    },
    "especie": {
        "id" : 1
    },
  };

  $.ajax({
    type: "POST",
    headers: { "Content-Type": "application/json" },
    url: urlA + "/",
    data: JSON.stringify(animal),
  }).done(() => {
    findAnimales();
    document.getElementById("claveAnimal").value = "";
  });
};

//--------------OBTENER ANIMALES---------------//

const findAnimales = async() => {
  await $.ajax({
      method: 'GET',
      headers: { "Accept": "application/json" },
      url: urlA + '/'
  }).done(function(res) {
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
                  <button class='btn btn-warning' data-toggle='modal2' onclick='getInfoAnimals(${res[i].id})' data-target='#modal2'><i class="fa-solid fa-pen-to-square"></i></button>
              </td>
          </tr>
              `;
      };
      $("#table3 > tbody").html(content)
  });
};

const getByIdA = async id => {
    return await $.ajax({
        type: 'GET',
        url: urlA + '/' + id
    }).done(res => {

    });
};

//Obtener la información del arreglo

const getInfoAnimals = async id => {
    let animal = await getByIdA(id);
    console.log(animal)

}

//Obtener informacion para actualizar

const getInfoUpdateAnimal = async id => {
    let animal = await getByIdA(id);

    document.getElementById('idAnimalUpdate').value = animal.data.id;
    document.getElementById('calveAnimalUpdate').value = animal.data.claveAnimal;
    document.getElementById('birthdayUpdate').value = animal.data.fechaNacimiento;
    document.getElementById('generoUpdate').value = animal.data.generoUpdate;
    document.getElementById('especieNombreComun').value = animal.data.quantity;
};

// //Actualizar animal

const updateAnimal = async() => {
    let id =  document.getElementById('idAnimalUpdate').value;
    let claveAnimal =  document.getElementById('calveAnimalUpdate').value ;
    let birthday = document.getElementById('birthdatUpdate').value;
    let genero = document.getElementById('generoUpdate').value;
    let especie = document.getElementById('especieEUpdate').value;

    let animalUpdate = {
        "claveAnimal": claveAnimal,
        "fechaNacimiento": birthday,
        "zoologico": {
            "id": 5
        },
        "genero": {
            "id": 1
        },
        "especie": {
            "id" : 1
        },
      };
    

    $.ajax({
        type: 'Put',
        url: urlA + '/' + id,
        data: JSON.stringify(animalUpdate)
    }).done(function(res) {
        findAnimales();
    });
};

findAnimales();




