const urlA = "http://localhost:8080/api/animal";
const urlAnimal = "http://localhost:8080/api/animal";

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
  }).done((res) => {
    console.log(res);
    document.getElementById("claveAnimal").value = "";
  });
};


const findAnimales = async() => {
  await $.ajax({
      method: 'GET',
      headers: { "Accept": "application/json" },
      url: urlAnimal + '/'
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
    url: urlAnimal + "/"
}).done(res => {
    let spinner = $("#generoSpinner");
    let dataAni = res.data;
    spinner.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
    spinner.append(
        "<option selected>Selecciona...</option>"
    );

    if(dataAni.length > 0){
        for(let i = 0; i < dataAni.length; i++){
            spinner.append(
              "<option value='"+ dataAni[i].genero.id +"'>"+ dataAni[i].genero.descripcion +"</option>"
              );
        };
    };
})
  document.getElementById('generoSpinner').value = animal.data.genero.id;
  document.getElementById('idAnimalUpdate').value = animal.data.id;
  document.getElementById('claveAnimalUpdate').value = animal.data.claveAnimal;
  document.getElementById('birthdayUpdate').value = animal.data.fechaNacimiento;
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
      console.log()
  });
};