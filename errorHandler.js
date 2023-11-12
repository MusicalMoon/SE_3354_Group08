/**
 * Handles any errors that occur within the program
 */
const errorHandler = (err, req, res, next) => {
  // Get status code and if its not there, default to 500.
  // HTTP status code 500 indicates an internal server error.
  const errStatus = req.statusCode || 500;

  // Extract the error message from the error object. Provide a default message
  // in case none is available in the error object.
  const errMessage = err.message || "Something went wrong";

  // Use the response object to send back a JSON response. This response contains
  // the error message and a flag indicating an error occurred.
  return res.status(errStatus).json({
    message: errMessage,
    isError: true,
  });

};

// Export the errorHandler middleware to enable its use across the application.
module.exports = errorHandler;
