function route(pathname, handle, response, postData) {
    console.log("Your request will be routed to: " + pathname)
    if (typeof handle[pathname] == 'function') {
        console.log("Hello I am routing to " +pathname)
        handle[pathname](response, postData)
    } else {
        console.log("Sorry no handlers found for " + pathname)

    }
}

exports.route = route