const modelDatos = require("./info.model");

const getInfoEstado = {
  findDatos: async (req, res) => {
    const { estado } = req.params;

    const data = await modelDatos.getData(estado);
    //console.log("----->", data); //tiene muchas mas informacion que la que necesito
    console.log("----->", data.data);
    res.json(data.data.datos); //la respuesta del servidor se genera aqui
  },
};


module.exports = getInfoEstado;
