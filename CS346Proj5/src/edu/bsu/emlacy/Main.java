package edu.bsu.emlacy;

import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;


class Main {

    public static void main(String args[])
            throws SQLException {

        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        System.out.println("Welcome!!");
        Scanner userInput = new Scanner(System.in);

        String serverName = "csor12c.dhcp.bsu.edu";
        String portNumber = "1521";
        String sid = "or12cdb";
        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

        Connection conn = DriverManager.getConnection(url,
                "emlacy", "3246");


        Statement stmt = conn.createStatement();
        Home(userInput, stmt);

        stmt.close();
        conn.close();
    }

    private static void Home(Scanner userInput, Statement stmt) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("HOME MENU");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("How would you like to search for recipes?\n"
                + "1) By serving size\n"
                + "2) By name\n"
                + "3) By category");

        int numSelected = userInput.nextInt();
        switch (numSelected) {
            case 1:
                servingSize(userInput, stmt);
                break;

            case 2:
                searchName(userInput, stmt);
                break;

            case 3:
                searchCat(userInput, stmt);
                break;

            default:
                System.out.println("Please try entering an option below.");
                Home(userInput, stmt);
                break;
        }
    }

    private static void servingSize(Scanner userInput, Statement stmt) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("What would you like to search by\n"
                + "1) Specific number of servings\n"
                + "2) Particular range of servings\n"
                + "3) Return to the main menu.");

        int numSelected = userInput.nextInt();
        switch (numSelected) {
            case 1:
                System.out.println("How many servings?");
                QueryOne(userInput.nextInt(), stmt);
                Home(userInput, stmt);
                break;

            case 2:
                System.out.println("What's the minimum serving size?");
                int min = userInput.nextInt();
                System.out.println("What's the maximum servings size?");
                int max = userInput.nextInt();
                QueryTwo(min, max, stmt);
                Home(userInput, stmt);
                break;
            case 3:
                Home(userInput, stmt);
                break;

            default:
                System.out.println("Oops! That's not an option! Try again.");
                servingSize(userInput, stmt);
                break;
        }
    }

    private static void searchName(Scanner userInput, Statement stmt) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("What would you like to search for?\n"
                + "1) Recipe\n"
                + "2) Categories\n"
                + "3) Ingredients\n"
                + "4) Users\n"
                + "5) Authors\n"
                + "6) Go Home");

        int numSelected = userInput.nextInt();

        switch (numSelected) {
            case 1:
                System.out.println("What Recipe to search for?");
                QueryThree(userInput.next(), stmt);
                searchName(userInput, stmt);
                break;
            case 2:
                System.out.println("What Category to search for?");
                QueryFive(userInput.next(), stmt);
                searchName(userInput, stmt);
                break;
            case 3:
                System.out.println("What Ingredient to search for?");
                QueryNine(userInput.next(), stmt);
                searchName(userInput, stmt);
                break;
            case 4:
                System.out.println("What User to search for?");
                QueryTen(userInput.next(), stmt);
                searchName(userInput, stmt);
                break;
            case 5:
                System.out.println("What Author to search for?");
                QueryFour(userInput.next(), stmt);
                searchName(userInput, stmt);
                break;
            case 6:
                Home(userInput, stmt);
                break;
            default:
                System.out.println("Oops! Please try an option from below!");
                searchName(userInput, stmt);
                break;
        }
    }

    private static void searchCat(Scanner userInput, Statement stmt) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Pick a Category:\n"
                + "1) Cake\n" +
                "2) Bread\n" +
                "3) Banana Bread\n" +
                "4) Chocolate Banana Bread\n" +
                "5) Pasta and Noodle\n" +
                "6) Pasta Salad\n" +
                "7) Salad \n" +
                "8) Vegetable Salad \n" +
                "9) Cauliflower Salad\n" +
                "10) St. Patrick’s Day\n" +
                "11) Corned Beef and Cabbage\n" +
                "12) Lasagna\n" +
                "13) Easy\n" +
                "14) Macaroni\n" +
                "15) Dessert\n" +
                "16) Cookie\n" +
                "17) Casserole\n" +
                "18) Breakfast\n" +
                "19) Pie\n" +
                "20) Beef\n" +
                "21) Main Dish Shrimp\n" +
                "22) Shrimp and Grits\n" +
                "23) Shrimp Scampi\n" +
                "24) Shrimp\n" +
                "25) Cake Pops\n"+
                "26)GO BACK TO THE MAIN MENU"
        );


        int numSelected = userInput.nextInt();
        switch (numSelected) {
            case 1:
                selection(userInput, "Cake Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 2:
                selection(userInput, "Bread Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 3:
                selection(userInput, "Banana Bread Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 4:
                selection(userInput, " Chocolate Banana Bread Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 5:
                selection(userInput, "Pasta and Noodle Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 6:
                selection(userInput, "Pasta Salad Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 7:
                selection(userInput, "Salad Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 8:
                selection(userInput, "Vegetable Salad Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 9:
                selection(userInput, "Cauliflower Salad Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 10:
                selection(userInput, "St. Patrick's Day Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 11:
                selection(userInput, "Corned Beef and Cabbage Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 12:
                selection(userInput, "Lasagna Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 13:
                selection(userInput, "Easy Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 14:
                selection(userInput, "Macaroni Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 15:
                selection(userInput, "Dessert Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 16:
                selection(userInput, "Cookie Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 17:
                selection(userInput, "Casserole Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 18:
                selection(userInput, "Breakfast Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 19:
                selection(userInput, "Pie Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 20:
                selection(userInput, "Beef Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 21:
                selection(userInput, "Main Dish Shrimp".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 22:
                selection(userInput, "Shrimp and Grits".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 23:
                selection(userInput, "Shrimp Scampi".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 24:
                selection(userInput, "Shrimp Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 25:
                selection(userInput, "Cake Pop Recipes".toString(), stmt);
                searchCat(userInput, stmt);
                break;
            case 26:
                Home(userInput, stmt);
                break;
            default:
                System.out.println("Select one from the following, dumbass");
                searchCat(userInput, stmt);
                break;
        }
    }

    private static void selection(Scanner userInput, String catTitle, Statement stmt) {
        System.out.println("What do you want to see?\n"
                + "1) Recipes\n"
                + "2) Authors\n"
                + "3) Sub-categories");

        int numSelected = userInput.nextInt();
        switch (numSelected) {
            case 1:
                QuerySeven(catTitle, stmt);
                break;
            case 2:
                QueryEight(catTitle, stmt);
                break;
            case 3:
                QuerySix(catTitle, stmt);
                break;
            default:
                selection(userInput, catTitle, stmt);
                break;
        }
    }

    // Query 1: Return recipes with a specific number of servings
    private static void QueryOne(int servCount, Statement stmt) {
        try {
            ResultSet rset = stmt.executeQuery("select * from RECIPE where SERVINGS=" + servCount);
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset.next()) {
                System.out.println(rset.getString(1) + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4));
            }
        } catch (SQLException e) {
        }
    }

    // Query 2: Return recipes within a specific range of servings
    private static void QueryTwo(int minServCount, int maxServCount, Statement stmt) {
        try {
            ResultSet rset2 = stmt.executeQuery("select * from RECIPE where SERVINGS between " + minServCount + " and " + maxServCount);
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset2.next()) {
                System.out.println(rset2.getString(1) + " " + rset2.getString(2)
                        + " " + rset2.getString(3)
                        + " " + rset2.getString(4));
            }
        } catch (SQLException e) {
        }
    }

    // Query 3: Return recipes with a specific phrase
    private static void QueryThree(String phraseSearch, Statement stmt) {
        try {
            ResultSet rset3 = stmt.executeQuery("select * from RECIPE where RECIPE_NAME like '%" + phraseSearch + "%'");
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset3.next()) {
                System.out.println(rset3.getString(1) + " " + rset3.getString(2)
                        + " " + rset3.getString(3)
                        + " " + rset3.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 4: Return published authors with a specific phrase
    private static void QueryFour(String phraseSearch, Statement stmt) {
        try {
            ResultSet rset4 = stmt.executeQuery("select * from PUBLISHED_AUTHOR where NICKNAME like '%" + phraseSearch + "%'");
            System.out.println("Authors table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset4.next()) {
                System.out.println(rset4.getString(1) + " " + rset4.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 5: Return category types with a specific phrase
    private static void QueryFive(String phraseSearch, Statement stmt) {
        try {
            ResultSet rset5 = stmt.executeQuery("select * from MEAL_TYPE where CAT_TITLE like '%" + phraseSearch + "%'");
            System.out.println("Category table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset5.next()) {
                System.out.println(rset5.getString(1) + " " + rset5.getString(2)
                        + " " + rset5.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 6: Return category subtypes for a given category
    private static void QuerySix(String parentCat, Statement stmt) {
        try {
            ResultSet rset6 = stmt.executeQuery("select M.* from Meal_Type M, CATEGORY_SUBGENRE C where C.Cat_subgenre=M.cat_Title AND C.CAT_TITLE LIKE '" + parentCat + "'");
            System.out.println("Category table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset6.next()) {
                System.out.println(rset6.getString(1) + " " + rset6.getString(2)
                        + " " + rset6.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 7: Return recipes with a given category
    private static void QuerySeven(String catType, Statement stmt) {
        try {
            ResultSet rset7 = stmt.executeQuery("select R.* from RECIPE R, CATEGORIZED_BY C where C.Recipe_name=R.Recipe_name AND C.Cat_title LIKE '" + catType + "'");
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset7.next()) {
                System.out.println(rset7.getString(1) + " " + rset7.getString(2)
                        + " " + rset7.getString(3)
                        + " " + rset7.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 8: Return authors contributing to a given category
    private static void QueryEight(String catType, Statement stmt) {
        try {
            ResultSet rset8 = stmt.executeQuery("select A.* from PUBLISHED_AUTHOR A, CONTRIBUTES_TO C where C.Nickname=A.Nickname AND C.Cat_title LIKE '" + catType + "'");
            System.out.println("Author table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset8.next()) {
                System.out.println(rset8.getString(1) + " " + rset8.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 9: Return ingredients with specific substring
    private static void QueryNine(String phraseSearch, Statement stmt) {
        try {
            ResultSet rset9 = stmt.executeQuery("select * from INGREDIENTS where ING_NAME like '%" + phraseSearch + "%'");
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset9.next()) {
                System.out.println(rset9.getString(1) + " " + rset9.getString(2)
                        + " " + rset9.getString(3)
                        + " " + rset9.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }

    // Query 10: Return users with a substring
    private static void QueryTen(String phraseSearch, Statement stmt) {
        try {
            ResultSet rset10 = stmt.executeQuery("select * from SITE_USER where USER_NUM like '%" + phraseSearch + "%'");
            System.out.println("Recipe table:");
            System.out.println("---------------------------------------------------------------------------");
            while (rset10.next()) {
                System.out.println(rset10.getString(1) + " " + rset10.getString(2)
                        + " " + rset10.getString(3)
                        + " " + rset10.getString(4)
                        + " " + rset10.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("There's an issue.");
        }
    }
}


