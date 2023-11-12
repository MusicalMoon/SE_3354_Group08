//Perform necessary imports
const User = require("../models/userModel");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

// Function for user logins
const login = async (req, res, next) => {
  try {
    // Get user details from the request
    const { email, password } = req.body;

    // Make sure the email and password are provided.
    if (!email || !password) {
      //Missing email or password
      return res.status(400).json({ message: "Both email and password are required" });
    }

    // Use the email to search for the user
    const foundUser = await User.findOne({ email });
    if (!foundUser || foundUser.isDisabled) {
      
      // User was not found
      return res.status(401).json({ message: "The User is not found" });
    }

    // Compare the password that was given with the password of the foundUser
    const match = await bcrypt.compare(password, foundUser.password);
    if (!match) {
      //Wrong password, unauthorized user
      return res.status(401).json({ message: "Unauthorized" });
    }

  } catch (error) {
    // Error handling
    next(error);
  }
};

// Export to use in other areas.
module.exports = {login};
