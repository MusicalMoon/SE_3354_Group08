/**
 * Limits number of logins by performed by the user.
 */

//Imports required to limit number of logins
const rateLimit = require("express-rate-limit");

// Create a rate limit rule for login attempts.
const loginLimit = rateLimit({
  // Count logins within a minute
  windowMs: 60 * 1000, // 1 minute in milliseconds

  // Max number of logins within the window
  max: 3, 

  // Custom message to be returned when the rate limit is exceeded.
  message: {
    message: "Too many login attempts, please try again in a minute",
  },
});

// Export for use in other parts of the program
module.exports = loginLimit;
