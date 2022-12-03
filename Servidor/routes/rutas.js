const express = require("express");
const info = require("../info.model");
const connection = require("../conexion");


const { body, param, validationResult } = require("express-validator");
var router = express.Router();


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
