// Libraries
const express = require('express');
const router = express.Router();
const Gamer = require('../models/gamer');
const ObjectId = require('mongodb').ObjectID;

/** Se obtiene los nombres de los jugadores por el frontend */
router.get('/register', function (req, res, next) {
  res.render('index')
});

/** Se crea el nuevo jugador */
router.post('/', function (req, res, next) { 
    const gamercreated = new Gamer({
      name: req.body.name,
      username: req.body.username,      
      password: [req.body.password]    
    });
  gamercreated.save()
    .then((result) => { res.json(result) })
    .catch((err) => { res.json(err) });
  });
module.exports = router;