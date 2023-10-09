import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class createPost {
    public static void main(String[] args) {
        Post recipe = new Post();
    }

    static class Post {
        ArrayList<String> ingredients = new ArrayList<String>();
        String description;


        public Post() {
            Scanner input = new Scanner(System.in);

            while(true) {
                System.out.println("Creating a post!");
                System.out.println("1. Attach Image");
                System.out.println("2. Modify Ingredients List");
                System.out.println("3. Modify Description");
                System.out.println("4. Save Draft");
                System.out.println("5. Publish Post");

                System.out.println("Enter your choice (1-3): ");
                int choice = input.nextInt();
                input.nextLine();

                switch(choice) {
                    case 1:
                        int width = 1920;
                        int height = 1080;
                        BufferedImage image = null;
                        System.out.println("Input image file path:")
                        File inputFile = new File(input.nextLine());
                        break;
                    case 2:
                        setIngredients();
                        System.out.println(ingredients);
                        break;
                    case 3:
                        System.out.println("Enter recipe description");
                        String descriptionStr;
                        descriptionStr = input.nextLine();
                        setDescription(descriptionStr);
                        System.out.println("Description Modified!");
                        break;
                    case 4:
                        System.out.println("Post saved as a draft!");
                        break;
                    case 5:
                        if(ingredients.size() == 0) {
                            System.out.println("ERROR: No Ingredient List");
                        }
                        else if(description.length() == 0) {
                            System.out.println("ERROR: No Description");
                        }
                        else {
                            System.out.println("Post Created!");
                        }
                        break;
                }
                if(choice == 4 || choice == 5) {
                    break;
                }
            }
        }

        public void setDescription(String descriptionStr) {
            this.description = descriptionStr;
        }

        public void setIngredients() {
            Scanner input = new Scanner(System.in);
            String item;

            System.out.println("Enter Ingredients 1 by 1. Press Enter to stop.");
            while(true) {
                item = input.nextLine();

                if(item == "") {
                    break;
                }

                this.ingredients.add(item);
                System.out.println("Enter next ingredient!");
            }
        }
    }
}