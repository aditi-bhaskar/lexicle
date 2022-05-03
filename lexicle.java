import java.util.* ;
// Written by Aditi B
// spin-off of wordle
class Main {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in) ;
    boolean is_play_over = false ;
    boolean is_game_over = false ;

    System.out.println("\nPLAYING LEXICLE \n\n") ; 

    System.out.println(".................................... \n" +
                        "How to play:\n" +
                        "enter a starting word," +
                        "then repeatedly enter more words\n" +
                        "until you guess the correct word entirely\n" +
                        " >> *letter* means letter is not in the word\n" +
                        " >> +letter+ means letter is in word, incorrect spot\n" +
                        " >>  letter  (by itself) means letter is in word, correct spot\n" +
                        "good luck!\n ***** \n") ;
    
    //initializing options to play with
    ArrayList<String> ans = new ArrayList<String>();
    ans.add("TRIAL") ;

    //other initializations
    ArrayList<String> past_guesses = new ArrayList<String>() ;
    int guess_count = 0 ;
    boolean random_length_mode = false ;

    //and, now to the game
    while(!is_play_over) {
        
      is_game_over = false ;

      // player action...
      System.out.print(".................................... \n" + 
                        "Would you like to:\n" + 
                        "  a - add to your lexicon (dictionary)?\n" +
                        "  e - enable/disable random-length mode?\n" +
                        "  s - see your dictionary?\n" +  
                        "  p - play the game?\n" +
                        "  q - quit?\n" + 
                        "enter the mode's corresponding letter \n>>") ;
      String play = s.nextLine() ;
      System.out.print(".................................... \n") ; 

      if (play.equals("q")) { // QUITTING
        is_play_over = true ;
        System.out.println("You have sucessfully quit :)") ;
      } 
      else if (play.equals("e")) { // RANDOM LENGTH MODE
        if (random_length_mode == false) {
          random_length_mode = true ;
        } else { // random_length_mode == true
          // remove all words from ans (dictionary) that are != 5 letters in length
          for (int i = ans.size() - 1; i > 0; i--) {
            if (ans.get(i).length() > 5) {
              ans.remove(i) ;
            }
          }
          random_length_mode = false ;
        }

        String k ;
        if (random_length_mode) 
          k = "enabled" ;
        else
          k = "disabled" ;
        System.out.println("you have " + k + " random length mode") ;
      }
      else if (play.equals("s")) { // SEE DICTIONARY
        System.out.println("***** Your Dictionary *****") ;
        for (String k : ans) {
          System.out.println("  " + k) ;
        }
        System.out.println("***************************") ;
      }
      else if (play.equals("a")) { // ADD TO DICTIONARY
        //taking the words for the dictionary
        System.out.println("enter a word") ;
        String f = "" ;
        if (!random_length_mode) {
          while (f.length() != 5) {
            System.out.print("only 5-letter words allowed:\n>>") ;
            f = s.nextLine() ;
          }
        }
        else {
          System.out.print(">>");
          f = s.nextLine() ;
        }
        ans.add(f.toUpperCase()) ;
        System.out.println("You have successfully added \"" + f + "\" to your dictionary") ;
      }
      else if (play.equals("p")) {// -- PLAY GAME
        //separation of key word and game
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
        "Starting game now.") ;
        guess_count = 0 ;
        
        //setting the answer word to one from the dictionary
        String ans_word = ans.get((int)(Math.random()*ans.size())).toUpperCase() ;
        int len = ans_word.length() ;

        while (!is_game_over) {
          String guesses = "" ;

          //taking a guess
          // len usually is = 5, unless you're in random length mode
          System.out.println("enter your " + len + "-letter guess") ;
          while (guesses.length() != len) {
            System.out.print("only " + len + "-letter words allowed:\n>>") ;
            guesses = s.nextLine() ;
          }
          guess_count += 1 ;

          //comparing
          String printing = "" ;
          boolean incorrect = false ;
          for(int i = 0; i < len; i++) {
            String ans_letter = ans_word.substring(i, i+1) ;
            String guess_letter = guesses.substring(i, i+1).toUpperCase() ;
            
            if(ans_letter.equals(guess_letter)) { // in word, right spot
              printing += " " + guess_letter + "   " ;
            }
            else if (ans_word.indexOf(guess_letter) != -1) { // in word, wrong spot
              printing += "+" + guess_letter + "+  " ;
              incorrect = true ;
            }
            else { // not in word
              printing += "*" + guess_letter + "*  " ;
              incorrect = true ;
            }
          }

          //printing
          past_guesses.add(printing) ;
          for (String guess : past_guesses) {
            System.out.println(guess) ;
          }
          if (!incorrect) {
            System.out.println("*******************************\n" + 
                               "YOU WIN! \nGAME OVER!\n" + 
                               "You took " + guess_count + " guesses\n" +
                               "The word was: " + ans_word + 
                               "\n*******************************\n");    
            is_game_over = true ;  
          }
        }    
      } else { //bc sometimes people be dumb and don't follow instructions
        System.out.println("por favor, vuelves despues de aprender ingles") ;
        System.out.println("or, if you know English, answer the prompt plz");
      }
  
    }
  }
}

