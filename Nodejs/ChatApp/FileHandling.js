var fs = require('fs')
var filedata = fs.readFileSync("data.txt", "utf8")
console.log(filedata)
fs.writeFileSync("copy.txt", filedata)
fs.readFile("copy.txt", "utf8", function (err, data) {

    if (err) {
        console.log(err.message)
    }
    else {
        console.log(data)
    }
})
console.log("***************")
fs.unlink("copy.txt", function(err){

})