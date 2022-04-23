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
  }).done((res) => {
    console.log(res);
    document.getElementById("claveAnimal").value = "";
  });
};
