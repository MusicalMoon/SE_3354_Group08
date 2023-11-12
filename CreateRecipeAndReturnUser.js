const User = require("../models/userModel");
const jwt = require("jsonwebtoken");
const Recipe = require("../models/recipeModel"); // Assuming you have a Recipe model

const postRecipe = async (req, res, next) => {
  try {
    const { title, ingredients, instructions } = req.body;

    // Assuming you have a Recipe model
    const newRecipe = await Recipe.create({
      title,
      ingredients,
      instructions,
      createdBy: req.user, // Associate the recipe with the user
    });

    const foundUser = await User.findById(req.user);

    if (!foundUser) {
      return res.sendStatus(401);
    }

    const roles = Object.values(foundUser.roles);

    const accessToken = jwt.sign(
      {
        UserInfo: {
          userId: foundUser._id,
          name: foundUser.name,
          email: foundUser.email,
          profilePicture: foundUser.profilePicture,
          roles: roles,
          favorites: foundUser.favorites,
        },
      },
      process.env.ACCESS_TOKEN_SECRET,
      { expiresIn: "1d" }
    );

    res.status(200).json({ recipe: newRecipe, accessToken });
  } catch (error) {
    next(error);
  }
};

module.exports = { postRecipe };
