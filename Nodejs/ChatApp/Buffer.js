var fs = require('fs')

var myReadStream = fs.createReadStream(__dirname+'/readMe.txt','utf-8')
var myWriterStream = fs.createWriteStream(__dirname+'/writeMe.txt')

myReadStream.on('data' , function(chunk) {
    console.log('new chunk recieved: ')
    myWriterStream.write(chunk)
})