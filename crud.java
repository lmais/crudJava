//CRUD app
//Laura Maisenhelder


import java.util.*;

public class crud{


        static List<String> toDoList = new ArrayList<String>();  
        static String[] arrOfInput = new String[2];
        static String[] detail = new String[2];
        static Scanner userInput = new Scanner(System.in);
        static String command, text, input;
        static int status = 1, entry;

        //welcome message and get input
        static void run(){

            System.out.println("/***************************************/"
                + "\r\n" + "Welcome to the grocery list manager.  Please add/show/update/delete an entry in the format of: " 
                + "\r\n" + "add, item   (add, apples)"
                + "\r\n" + "show, list  (show, list)"
                + "\r\n" + "update, #, replacement     (update, 2, gala apples)"
                + "\r\n" + "delete, #    (delete, 3)"
                + "\r\n" + "exit, list   (exit, list)"
                + "\r\n" + "/***************************************/");

            while(status == 1){
                input = userInput.nextLine();
                if(input.contains(",")){
                    arrOfInput = input.split(",", 2);}
                else{
                    System.out.println("*I didn't understand, please try again");
                } 
                if(arrOfInput[0] == null || arrOfInput[1] == null){
                    System.out.println("*I didn't understand, please try again");
                }
                else{
                    command = arrOfInput[0].trim();
                    text = arrOfInput[1].trim();
                    handle();
                }
            }

            userInput.close();
        }

        //handle inputs
        static void handle(){
            switch(command){

                case "add":
                    toDoList.add(text);
                    break;

                case "show":
                    System.out.println("/***Current List***/");
                    for (String i : toDoList) {
                        System.out.println( toDoList.indexOf(i) + 1 + " " + i);
                    }
                    System.out.println("/******************/");
                    break;
                case "update":
                    detail = text.split(",", 2); 
                    entry = Integer.parseInt(detail[0].trim());
                    if(entry > toDoList.size()){
                        System.out.println("Entry not found, please try again");
                    }
                    else{
                    toDoList.set(entry - 1, detail[1].trim());
                    }
                    break;
                case "delete":
                    entry = Integer.parseInt(text.trim());
                    if(entry > toDoList.size()){
                        System.out.println("Entry not found, please try again");
                    }
                    else{
                    toDoList.remove(entry -1);  
                    }
                    break;
                case "exit":
                    System.out.println("Goodbye");
                    status = 0;
                    break;
                default: 
			        System.out.println("*I didn't understand, please try again");
               }
        }

    public static void main(String[] args){
        crud.run();
    }
}