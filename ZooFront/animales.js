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

    document.getElementById('idAnimalUpdate').value = animal.data.id
    document.getElementById('name_update').value = animal.arreglo[0].name
    document.getElementById('descripcion_update').value = animal.arreglo[0].description
    document.getElementById('price_update').value = animal.arreglo[0].price
    document.getElementById('quantity_update').value = animal.arreglo[0].quantity
};

// //Actualizar arreglo

// const updateArreglo = async() => {
//     let id = document.getElementById('id_update').value;
//     let name = document.getElementById('name_update').value;
//     let description = document.getElementById('descripcion_update').value;
//     let price = document.getElementById('price_update').value;
//     let quantity = document.getElementById('quantity_update').value;

//     $.ajax({
//         type: 'POST',
//         url: urlA + '/producto/update/' + id,
//         data: { name, description, price, quantity }
//     }).done(function(res) {
//         findArreglo();
//     });
// };

findAnimales();




