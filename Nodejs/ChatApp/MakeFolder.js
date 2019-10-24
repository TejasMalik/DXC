var fs = require('fs')

fs.mkdir('DXC', function(){
    fs.mkdir('./DXC/Cust', function() {
        fs.mkdir('./DXC/Cust/Emp', function() {
            fs.readFile("data.txt", "utf8", function(err,data){
                fs.writeFileSync('./DXC/Cust/Emp/ReadMe.txt', data)
            })
        })
    })
})