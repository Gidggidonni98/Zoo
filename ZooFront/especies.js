const url = "http://localhost:8080/api/especie";

//-----------------------REGISTRAR ESPECIE----------------------------------//

const registerEspecie = () => {
  let familia = document.getElementById("familia").value;
  let nombre_cientifico = document.getElementById("nombre_cientifico").value;
  let nombre_comun = document.getElementById("nombre_comun").value;
  // let peligro_extincion = document.getElementById('peligro_extincion');
  // let pais_id = document.getElementById('pais_id');

  let especie = {
    nombreComun: nombre_comun,
    nombreCientifico: nombre_cientifico,
    familia: familia,
    peligroExtincion: "si",
    pais: {
      id: 1,
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
