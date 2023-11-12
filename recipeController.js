const Recipe = require("../models/recipeModel");
const User = require("../models/userModel");
const jwt = require("jsonwebtoken");

//Creates a function called addRecipe. This function will be called whenever the "Post a recipe" button is clicked.
const addRecipe = async (req, res, next) => {
  try {
    const {
      title,
      image,
      description,
      ingredients,
    } = req.body;
    if (
      //Checks to make sure the recipe has a picture, title, description, and ingredients
      !title ||
      !image ||
      !description ||
      !ingredients.length ||
    ) {
      return res.status(422).json({ message: "Insufficient data" });
    }
    const recipe = Recipe({ ...req.body, author: req.user });
    await recipe.save();
    res.status(201).json({ success: "Recipe added successfully" });
  } catch (error) {
    next(error);
  }
};

module.exports = {
  addRecipe
};
