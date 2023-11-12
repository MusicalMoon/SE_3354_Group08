const mongoose = require("mongoose");

//Creates a class for recipes.
//Puts the class in the mongo database to store other recipes using this class.
const schema = mongoose.Schema(
  //Class has title, author, description, image, and ingredient categories
  {
    title: {
      type: String,
    },
    author: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "User",
    },
    description: { type: String },
    image: { type: String },
    ingredients: [{ type: String }],
  },
);

const Recipe = mongoose.model("Recipe", schema);
module.exports = Recipe;
