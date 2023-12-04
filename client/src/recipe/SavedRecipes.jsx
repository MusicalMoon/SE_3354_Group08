import React from "react";
import { AllCards, ComponentLoading } from "../../components";
import { useGetRecipesQuery } from "../../features/recipe/recipeApiSlice";
import useAuth from "../../hooks/useAuth";
import useTitle from "../../hooks/useTitle";

const index = () => {
  const { data, isLoading } = useGetRecipesQuery();
  const user = useAuth();
  useTitle("Reciply - Saved Recipes");
  const updatedData = data?.filter((obj) =>
    user?.favorites?.includes(obj._id.toString())
  );

  return (
    <>
      {isLoading ? (
        <ComponentLoading />
      ) : (
        <AllCards
          mainTitle={"Your Flavorful Collection"}
          tagline={
            "Welcome to your personal culinary treasury - a haven for your favorite recipes!"
          }
          type={"recipe"}
          data={updatedData}
        />
      )}
    </>
  );
};

export default index;
