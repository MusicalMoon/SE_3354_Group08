// controllers/recipeController.js

const Recipe = require("../models/recipeModel");
const User = require("../models/userModel");
const jwt = require("jsonwebtoken");

// Other imports...

const getAllRecipes = async (req, res, next) => {
  // Existing code...
};

const getRecipe = async (req, res, next) => {
  // Existing code...
};

const addRecipe = async (req, res, next) => {
  // Existing code...
};

const updateRecipe = async (req, res, next) => {
  // Existing code...
};

const rateRecipe = async (req, res, next) => {
  // Existing code...
};

const deleteRecipe = async (req, res, next) => {
  // Existing code...
};

const addComment = async (req, res, next) => {
  // Existing code...
};

const deleteComment = async (req, res, next) => {
  // Existing code...
};

const toggleFavoriteRecipe = async (req, res, next) => {
  // Existing code...
};

// New controller function for editing a recipe
const editRecipe = async (req, res, next) => {
  try {
    const {
      title,
      image,
      description,
      calories,
      cookingTime,
      ingredients,
      instructions,
    } = req.body;

    if (
      !title ||
      !image ||
      !description ||
      !calories ||
      !cookingTime ||
      !ingredients.length ||
      !instructions.length
    ) {
      return res.status(422).json({ message: "Insufficient data" });
    }

    const foundRecipe = await Recipe.findById(req.params.id);

    if (!foundRecipe) {
      return res.status(404).json({ message: "Recipe not found" });
    }

    if (foundRecipe.author !== req.user) {
      return res.status(401).json({ message: "Unauthorized" });
    }

    foundRecipe.title = title;
    foundRecipe.description = description;
    foundRecipe.image = image;
    foundRecipe.calories = calories;
    foundRecipe.ingredients = ingredients;
    foundRecipe.cookingTime = cookingTime;
    foundRecipe.instructions = instructions;

    const updatedRecipe = await foundRecipe.save();
    res.status(200).json(updatedRecipe);
  } catch (error) {
    next(error);
  }
};

module.exports = {
  getAllRecipes,
  getRecipe,
  addRecipe,
  updateRecipe,
  rateRecipe,
  deleteRecipe,
  addComment,
  deleteComment,
  toggleFavoriteRecipe,
  editRecipe, // Add the new controller function to exports
};
