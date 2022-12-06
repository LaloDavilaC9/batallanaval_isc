module.exports = {
 
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
  



  //Mete a un nuevo jugador a la base de datos
  registrarJugador: (connection, body, callback) => {
    //var turno_jugada = body.turno_jugada;
    //console.log("El turno es: "+turno_jugada);
    //var query  = "INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES (NULL, '2', '4', '3');"
    connection.query("insert into jugador SET ?", body, (err, results) => {
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

  //Obtiene la información de inicio de sesión de un usuario
  getInfoUsuario: (connection, req,callback) => {
    const info = req.params;
    //console.log("INFO: "+info.numero);
    //var tablero = info.numero == 1 ? "tablero1" : "tablero2"; 
    //"select * from "+tablero
    var query= "SELECT * FROM jugador WHERE correo='"+info.correo+"'";
    
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

  

   //Invita a un jugador a una partida
   invitarJugador: (connection, body, callback) => {
    //var turno_jugada = body.turno_jugada;
    //console.log("El turno es: "+turno_jugada);
    //var query  = "INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES (NULL, '2', '4', '3');"
    connection.query("insert into invitacion SET ?", body, (err, results) => {
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

  //Indica si hay invitaciones para el jugador que llega como parámetro
  getInfoInvitaciones: (connection, req,callback) => {
    const info = req.params;
    console.log("INFO: "+info.correo);
    //var tablero = info.numero == 1 ? "tablero1" : "tablero2"; 
    //"select * from "+tablero
    var query= "SELECT * FROM invitacion WHERE invitado='"+info.correo+"'";
    
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

//Acepta o rechaza la invitación a una partida
confirmarInvitacion: (connection, body, callback) => {
      //var turno_jugada = body.turno_jugada;
      //console.log("El turno es: "+turno_jugada);
      //var query  = "INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES (NULL, '2', '4', '3');"
      connection.query("update invitacion SET enlazado = "+body.enlazado+" WHERE invita='"+body.invita+"' and invitado='"+body.invitado+"'", body, (err, results) => {
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
    var query= "SELECT * FROM ataques order by no_jugada desc limit 1;";
    
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
