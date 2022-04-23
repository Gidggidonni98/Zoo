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
                  <button class='btn btn-warning' data-toggle='modal' onclick='getInfoClient()' data-target='#detallesCliente'><i class="fa-solid fa-pen-to-square"></i></button>
              </td>
          </tr>
              `;
      };
      $("#table3 > tbody").html(content)
  });
};
findAnimales();
