import React, { useEffect } from "react";
import { AllCards, ComponentLoading } from "../../components";
import { useDispatch } from "react-redux";
import { setRecipes } from "../../features/recipe/recipeSlice";
import { useGetRecipesQuery } from "../../features/recipe/recipeApiSlice";
import useTitle from "../../hooks/useTitle";

const Recipe = () => {
  const { data, isLoading } = useGetRecipesQuery();
  const dispatch = useDispatch();
  useTitle("Recipen - All Recipes");

  useEffect(() => {
    if (!isLoading) {
      dispatch(setRecipes(data));
    }
  }, [isLoading]);

  return (
    <>
      {isLoading ? (
        <ComponentLoading />
      ) : (
        <AllCards
          mainTitle={"Discover Flavorful Creations"}
          tagline={
            "Enjoy a collection of recipes, curated and shared by enthusiastic food enthusiasts."
          }
          type={"recipe"}
          data={data}
        />
      )}
    </>
  );
};

export default Recipe;
