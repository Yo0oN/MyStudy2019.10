var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  // viws/index.ejs
  // /로 요청을 하면 이곳의 일을 하고, index.js에서 연결해준 페이지로 응답한다.
  res.render('index', { title: 'Express' });
});

module.exports = router;
