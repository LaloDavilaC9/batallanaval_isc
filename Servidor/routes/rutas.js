const express = require("express");
const info = require("../info.model");
const connection = require("../conexion");


const { body, param, validationResult } = require("express-validator");
var router = express.Router();


//Se manda llamar cuando un jugador se quiere registrar
router.post(
  "/registarJugador",
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      res.json({ success: false, err: JSON.stringify(errors) });
      return;
    }
    console.log("La info: ",req.body);
    let body = req.body;
    info.registrarJugador(connection, body, (data) => {
      res.json(data);
    });
  }
);

//Se manda llamar cuando un jugador quiere invitar a otro
router.post(
  "/invitarJugador",
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      res.json({ success: false, err: JSON.stringify(errors) });
      return;
    }
    console.log("La info: ",req.body);
    let body = req.body;
    info.invitarJugador(connection, body, (data) => {
      res.json(data);
    });
  }
);

//Pregunta si hay invitaciones para el jugador
router.get("/invitaciones/:correo", [], (req, res) => {
  info.getInfoInvitaciones(connection,req, (data) => {
    res.json(data);
  });
});



router.get("/tablero/:jugador", [], (req, res) => {
  info.getTablero(connection,req, (data) => {
    res.json(data);
  });
});


//Pregunta qué posición atacó el contrario
router.get("/preguntarPosicion", [], (req, res) => {
  info.getPosicion(connection,req, (data) => {
    res.json(data);
  });
});

//Pregunta si el ataque fue certero o no   0: NO   1. SI
router.get("/preguntarCerteza", [], (req, res) => {
  info.getDefinicion(connection,req, (data) => {
    res.json(data);
  });
});


//Se manda llamar cuando un jugador ataca al otro
router.post(
  "/atacarCelda",
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      res.json({ success: false, err: JSON.stringify(errors) });
      return;
    }
    console.log("La info: ",req.body);
    let body = req.body;
    info.atacarPosicion(connection, body, (data) => {
      res.json(data);
    });
  }
);


//Indica si le atinó o no
router.post(
  "/dictarDefinicion",
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      res.json({ success: false, err: JSON.stringify(errors) });
      return;
    }
    console.log("La info: ",req.body);
    let body = req.body;
    info.dictarDefinicion(connection, body, (data) => {
      res.json(data);
    });
  }
);

router.post(
  "/user",
  [
    body("name").not().isEmpty().isString(),
    body("lastname").not().isEmpty().isString(),
    body("contact").not().isEmpty().isString(),
    body("cellphone").not().isEmpty().isString(),
  ],
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      res.json({ success: false, err: JSON.stringify(errors) });
      return;
    }
    let body = req.body;
    user.create(connection, body, (data) => {
      res.json(data);
    });
  }
);


module.exports = router;
