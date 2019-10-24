
function route(pathname,handle,response,postData)
{
    if(typeof handle[pathname] == 'function'){
        console.log("Hello I am routing :" + pathname)
        handle[pathname](response,postData);
    }
    else{
        console.log("Sorry handler not found for" + pathname)
    }
}

exports.route = route