module.exports = {
  create: (connection, body, callback) => {
    connection.query("insert into users SET ?", body, (err, results) => {
      if (err) {
        callback({
          array: null,
          id: null,
          success: false,
          err: JSON.stringify(err),
        });
        return;
      }
      callback({ array: null, id: null, success: true });
    });
  },



  getTablero: (connection, req,callback) => {
    const info = req.params;
    //console.log("INFO: "+info.numero);
    var tablero = info.numero == 1 ? "tablero1" : "tablero2"; 

    connection.query("select * from "+tablero, (err, results) => {
      if (err) {
        callback({
          array: null,
          id: null,
          success: false,
          err: JSON.stringify(err),
        });
        return;
      }
      callback({ array: results, success: "true" });
    });
  },
  

  //Dice su posición al otro jugador
  atacarPosicion: (connection, body, callback) => {
    //var turno_jugada = body.turno_jugada;
    //console.log("El turno es: "+turno_jugada);
    //var query  = "INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES (NULL, '2', '4', '3');"
    connection.query("insert into jugada SET ?", body, (err, results) => {
      if (err) {
        callback({
          array: body,
          id: null,
          success: false,
          err: JSON.stringify(err),
        });
        return;
      }
      callback({ array: null, id: null, success: true });
    });
  },


  //Recibe la posición que el otro jugador está atacando
  getPosicion: (connection, req,callback) => {
    const info = req.params;
    //console.log("INFO: "+info.numero);
    //var tablero = info.numero == 1 ? "tablero1" : "tablero2"; 
    //"select * from "+tablero
    var query= "SELECT * FROM jugada order by numero_jugada desc limit 1;";
    
    connection.query(query, (err, results) => {
      if (err) {
        callback({
          array: null,
          id: null,
          success: false,
          err: JSON.stringify(err),
        }); 
        return;
      }
      callback({ array: results, success: "true" });
    });
  },

  //Dice si el ataque del enemigo fue hacia un barco o no (0. NO      1. SI)
  dictarDefinicion: (connection, body, callback) => {
    //var ataque = body.ataque;
    //var no_jugada = body.no_jugada;

    //console.log("El ataque fue: "+ataque);
    //console.log("El turno es: "+turno_jugada);
    //var query  = "INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES (NULL, '2', '4', '3');"
    
    connection.query("insert into ataques SET ?", body, (err, results) => {
      if (err) {
        callback({
          array: body,
          id: null,
          success: false,
          err: JSON.stringify(err),
        });
        return;
      }
      callback({ array: null, id: null, success: true });
    });
  },


   //Verifica si el ataque recibido fue certero o no (0. NO     1. SI)
   getDefinicion: (connection, req,callback) => {
    const info = req.params;
    //console.log("INFO: "+info.numero);
    //var tablero = info.numero == 1 ? "tablero1" : "tablero2"; 
    //"select * from "+tablero
    var query= "SELECT MAX(numero_jugada) as numero_jugada,jugada.turno_jugada, jugada.pos_x,jugada.pos_y FROM jugada";
    
    connection.query(query, (err, results) => {
      if (err) {
        callback({
          array: null,
          id: null,
          success: false,
          err: JSON.stringify(err),
        }); 
        return;
      }
      callback({ array: results, success: "true" });
    });
  },


};
