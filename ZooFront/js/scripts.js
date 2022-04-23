const urlGetCountries = 'http://localhost:8080/api/pais/'

const obtenerPaises = async() => {
    await $.ajax({
        method: 'GET',
        url: urlGetCountries
    }).done(res => {
        let spinner = $("#spinnerEspecies");
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
};

const loadSpinners = async() => {
    
      await $.ajax({
        method: 'GET',
        url: url + '/'
      }).done(res => {
          let espEsp = $("#esp");
          let listEspecies = res.data;
          espEsp.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
          espEsp.append(
              "<option selected>Selecciona...</option>"
          );
    
          if(listEspecies.length > 0){
              for(let i = 0; i < listEspecies.length; i++){
                  espEsp.append(
                      "<option value='"+ listEspecies[i].id +"'>"+ listEspecies[i].familia +"</option>"
                  );
              };
          };
      })
    
      await $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/api/zoo/'
      }).done(res => {
          let zooEsp = $("#zoo");
          let lisZoos = res.data;
          zooEsp.empty(); // Esta funcion vacia el select para evitar que se dupliquen los options
          zooEsp.append(
              "<option selected>Selecciona...</option>"
          );
    
          if(lisZoos.length > 0){
              for(let i = 0; i < lisZoos.length; i++){
                  zooEsp.append(
                      "<option value='"+ lisZoos[i].id +"'>"+ lisZoos[i].nombre +"</option>"
                  );
              };
          };
      })
};