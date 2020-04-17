"use strict"

module.exports = function(app) {
    app.get('/', (req, res) => {
        res.render('index.html');
    });
    
    app.get('/result.do', (req, res) => {
        res.render('result', {
            gugudan : req.query.gugudan
        })
    });
}