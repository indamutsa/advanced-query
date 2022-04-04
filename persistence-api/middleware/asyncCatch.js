module.exports = function(handler) {
    // Catching error at the end of all middleware
    return async(req,res,next){
        try {
            await handler(req,res);
        } catch (err) {
            next(err);        
        }
    }
}