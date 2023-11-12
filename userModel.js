//Import mongoose
const mongoose = require("mongoose");

// Define the schema for our User model
const schema = mongoose.Schema(
  {
    //Strings to hold name, email, and password
    name: { 
      type: String, 
    },
    email: {
      type: String, 
    },
    password: {
      type: String, 
    },
  }
);

// User utilizes the specified schema
const User = mongoose.model("User", schema);

//Export to use in other areas
module.exports = User;
